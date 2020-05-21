package com.czl.business.api;

import com.czl.base.response.ApiResponse;
import com.czl.base.response.enums.ApiResponseEnum;
import com.czl.base.util.BeanCopyUtil;
import com.czl.base.util.DateUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-20
 * @创建时间: 15:28
 */
@Validated
@RestController
public class UserController {

    @GetMapping("user/login")
    public ApiResponse login () {
        System.out.println(BeanCopyUtil.copy(String.class, 1).getClass());
        System.out.println(DateUtil.dateToText());
        ApiResponseEnum fail = ApiResponseEnum.SUCCESS;
        return ApiResponse.respond(fail);
    }
}
