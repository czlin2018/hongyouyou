package com.czl.privileges.service;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.privileges.dto.UserInsertDto;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:37
 */
public interface UserService {

    ApiBaseEnum insert( UserInsertDto userInsertDto);

}
