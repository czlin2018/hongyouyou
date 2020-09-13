package com.czl.privileges.service;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.privileges.dto.UserInsertDto;
import com.czl.privileges.vo.UserInterfacePathVO;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:37
 */
public interface UserService {

    /**
     * 新增用户
     * @param userInsertDto
     * @return
     */
    ApiBaseEnum insert( UserInsertDto userInsertDto);

    /**
     * 根据用户id获得接口权限
     * @param userId
     * @return
     */
    List<String> getInterfacePathByUserId ( Long userId );
}
