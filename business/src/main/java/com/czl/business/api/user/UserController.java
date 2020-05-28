package com.czl.business.api.user;

import com.czl.base.response.ApiResponse;
import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @GetMapping ( "/user/login" )
    public ApiResponse<ApiBaseEnum> login () {
        ApiBaseEnum apiBaseEnum = userService.insert();
        return ApiResponse.respond(apiBaseEnum);
    }
}
