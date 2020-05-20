package com.czl.base.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Tom
 */
@Slf4j
public class DateUtil {

    private DateUtil () {
    }

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    private static final String YYYY_MM = "HH:mm";

    public static final DateTimeFormatter yyyyMmDdHhMmSsFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);

    public static final DateTimeFormatter yyyyMmDdFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);

    /**
     * 获取现在时间,date
     */
    public static Date getNow () {
        return new Date();
    }

    /**
     * 获取现在时间,yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String toNowDateString () {
        return LocalDateTime.now().format(yyyyMmDdHhMmSsFormatter);
    }


    /**
     * 获取指定年月的起点时间
     *
     * @param day 不传默认指定月第一天
     */
    public static Date getAppointStartTime (Integer year, Integer month, Integer day) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate;
        if (day != null) {
            localDate = yearMonth.atDay(day);
        } else {
            localDate = yearMonth.atDay(1);
        }
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取指定年月日的终点时间
     *
     * @param day 　　不传默认指定月最后一天
     */
    public static Date getAppointEndTime (Integer year, Integer month, Integer day) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate dateTime;
        if (day != null) {
            dateTime = yearMonth.atDay(day);
        } else {
            dateTime = yearMonth.atEndOfMonth();
        }
        LocalDateTime localDateTime = dateTime.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * date类型 -> string类型
     *
     * @return
     */
    public static String dateToText () {
        return dateToText(new Date(), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * date类型 -> string类型
     *
     * @param date
     * @return
     */
    public static String dateToText (Date date) {
        return dateToText(date, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * date类型 -> string类型
     *
     * @return
     */
    public static String dateToTextShort () {
        return dateToText(new Date(), YYYY_MM_DD);
    }

    /**
     * date类型 -> string类型
     *
     * @param date
     * @return
     */
    public static String dateToTextShort (Date date) {
        return dateToText(date, YYYY_MM_DD);
    }

    /**
     * date类型 -> string类型
     *
     * @return
     */
    public static String dateTohoursAndseconds () {
        return dateToText(new Date(), YYYY_MM);
    }

    /**
     * date类型 -> string类型
     *
     * @param date
     * @return
     */
    public static String dateTohoursAndseconds (Date date) {
        return dateToText(date, YYYY_MM);
    }


    /**
     * date类型 -> string类型
     *
     * @param date
     * @param formatPattern
     * @return
     */
    public static String dateToText (Date date, String formatPattern) {
        if (date == null) {
            return StringUtils.EMPTY;
        } else {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(formatPattern);
        }

    }

    /**
     * string类型 -> date类型
     *
     * @param timeStr
     * @return
     */
    public static Date textToLongDate (String timeStr) {
        org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM_SS);
        DateTime dateTime = dateTimeFormatter.parseDateTime(timeStr);
        return dateTime.toDate();
    }

    /**
     * string类型 -> date类型
     *
     * @param timeStr
     * @return
     */
    public static Date textToDate (String timeStr) {
        org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM);
        DateTime dateTime = dateTimeFormatter.parseDateTime(timeStr);
        return dateTime.toDate();
    }

    /**
     * 获取两个时间之间时间段
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static String periodOfTwoTime (String startTime, String endTime) {
        Date startDate = textToDate(startTime);
        Date endDate = textToDate(endTime);
        String startDay = dateToTextShort(startDate);
        String endDay = dateToTextShort(endDate);
        String startHours = dateTohoursAndseconds(startDate);
        String endHours = dateTohoursAndseconds(endDate);
        return startDay.equals(endDay)
                ? startDay + " " + startHours + "-" + endHours
                : startDay + " " + startHours + "-" + endDay + " " + endHours;
    }

    /**
     * 判断 beforeTime , afterTime 的大小
     *
     * @param beforeTimeStr
     * @param afterTimeStr
     * @return ture afterTime 大
     */
    public static boolean isLatedThanAnother (String beforeTimeStr, String afterTimeStr) {
        org.joda.time.format.DateTimeFormatter format = DateTimeFormat.forPattern ( YYYY_MM_DD_HH_MM_SS );
        DateTime beforeTime = DateTime.parse ( beforeTimeStr , format );
        DateTime afterTime = DateTime.parse ( afterTimeStr , format );
        return afterTime.isAfter ( beforeTime );
    }


    /**
     * 判断date日期是否过期(与当前时刻比较)
     *
     * @param date
     * @return
     */
    public static boolean isLatedThanAnother (Date date) {
        if (null == date) {
            return true;
        } else {
            String timeStr = dateToText(date);
            return isBeforeNow(timeStr);
        }
    }

    /**
     * 判断date日期是否过期(与当前时刻比较)
     *
     * @param timeStr
     * @return
     */
    public static boolean isLatedThanAnother (String timeStr) {
        if (StringUtils.isBlank(timeStr)) {
            return true;
        }
        return isBeforeNow(timeStr);
    }

    /**
     * 判断timeStr是否在当前时刻之前
     *
     * @param timeStr
     * @return
     */
    private static boolean isBeforeNow (String timeStr) {
        org.joda.time.format.DateTimeFormatter format = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM_SS);
        DateTime dateTime = DateTime.parse(timeStr, format);
        return dateTime.isBeforeNow();
    }

    /**
     * 日期加秒数
     *
     * @param date
     * @param seconds
     * @return
     */
    public static String plusSeconds (String date, Integer seconds) {
        return dateToText(plusSeconds(textToLongDate(date), seconds));
    }

    /**
     * 日期加秒数
     *
     * @param date
     * @param seconds
     * @return
     */
    public static Date plusSeconds (Date date, Integer seconds) {
        return plusOrMinusSeconds(date, seconds, 0);
    }

    /**
     * 日期减秒数
     *
     * @param date
     * @param seconds
     * @return
     */
    public static Date minusSeconds (Date date, Integer seconds) {
        return plusOrMinusSeconds(date, seconds, 1);
    }

    /**
     * 加减秒数
     *
     * @param date
     * @param seconds
     * @param type    0:加天数 1:减天数
     * @return
     */
    private static Date plusOrMinusSeconds (Date date, Integer seconds, Integer type) {
        if (null == date) return null;
        seconds = null == seconds ? 0 : seconds;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusSeconds(seconds);
        } else {
            dateTime = dateTime.minusSeconds(seconds);
        }

        return dateTime.toDate();
    }


    /**
     * 日期加天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date plusDays (Date date, Integer days) {
        return plusOrMinusDays(date, days, 0);
    }

    /**
     * 日期减天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date minusDays (Date date, Integer days) {
        return plusOrMinusDays(date, days, 1);
    }

    /**
     * 加减天数
     *
     * @param date
     * @param days
     * @param type 0:加天数 1:减天数
     * @return
     */
    private static Date plusOrMinusDays (Date date, Integer days, Integer type) {
        if (null == date) return null;
        days = null == days ? 0 : days;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusDays(days);
        } else {
            dateTime = dateTime.minusDays(days);
        }

        return dateTime.toDate();
    }

    /**
     * 日期加分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date plusMinutes (Date date, Integer minutes) {
        return plusOrMinusMinutes(date, minutes, 0);
    }

    /**
     * 日期减分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date minusMinutes (Date date, Integer minutes) {
        return plusOrMinusMinutes(date, minutes, 1);
    }

    /**
     * 加减分钟
     *
     * @param date
     * @param minutes
     * @param type    0:加分钟 1:减分钟
     * @return
     */
    private static Date plusOrMinusMinutes (Date date, Integer minutes, Integer type) {
        if (null == date) return null;
        minutes = null == minutes ? 0 : minutes;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusMinutes(minutes);
        } else {
            dateTime = dateTime.minusMinutes(minutes);
        }

        return dateTime.toDate();
    }

    /**
     * 日期加月份
     *
     * @param date
     * @param months
     * @return
     */
    public static Date plusMonths (Date date, Integer months) {
        return plusOrMinusMonths(date, months, 0);
    }

    /**
     * 日期减月份
     *
     * @param date
     * @param months
     * @return
     */
    public static Date minusMonths (Date date, Integer months) {
        return plusOrMinusMonths(date, months, 1);
    }

    /**
     * 加减月份
     *
     * @param date
     * @param months
     * @param type   0:加月份 1:减月份
     * @return
     */
    private static Date plusOrMinusMonths (Date date, Integer months, Integer type) {
        if (null == date) return null;
        months = null == months ? 0 : months;

        DateTime dateTime = new DateTime(date);
        if (type == 0) {
            dateTime = dateTime.plusMonths(months);
        } else {
            dateTime = dateTime.minusMonths(months);
        }

        return dateTime.toDate();
    }


    /**
     * 获取指定日期当月的第一天
     * dateStr，format 格式应该一致
     *
     * @param dateStr 指定的时间，如 2018-8-02 00:00:00
     * @return
     */
    public static String getFirstDayOfGivenMonth (String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.MONTH, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return sdf.format(calendar.getTime());
        }catch (ParseException e) {
            log.info(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取指定日期下个月的第一天
     * dateStr，format 格式应该一致
     *
     * @param dateStr 指定的时间，如 2018-8-02 00:00:00
     * @return
     */
    public static String getFirstDayOfNextMonth (String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return sdf.format(calendar.getTime());
        }catch (ParseException e) {
            log.info(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解析cron表达式
     *
     * @param cron
     * @param begin 开始时间
     * @param end   结束时间
     * @return
     */
    public static List<Date> getCronToDate (String cron, Date begin, Date end) {
        if (! CronSequenceGenerator.isValidExpression(cron)) {
            return null;
        }
        List<Date> dateList = new ArrayList<>();
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        while (true) {
            Date nextTimePoint = cronSequenceGenerator.next(begin);
            if (nextTimePoint.after(end)) {
                break;
            } else {
                dateList.add(nextTimePoint);
                begin = nextTimePoint;
            }
        }
        return dateList;
    }

    /**
     * 解析时间表达式
     *
     * @param cycleTime
     * @param begin     开始时间
     * @param end       结束时间
     * @return
     */
    public static List<Date> getCycleTime (Integer cycleTime, Date begin, Date end) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(begin);
        while (true) {
            Date nextTimePoint = plusMinutes(begin, cycleTime);
            if (nextTimePoint.after(end)) {
                break;
            } else {
                dateList.add(nextTimePoint);
                begin = nextTimePoint;
            }
        }
        return dateList;
    }


    /**
     * 获取当前系统时间戳
     * @return
     */
    public static String getCurrentTimeStamp(){
        return String.valueOf(System.currentTimeMillis());
    }
}
