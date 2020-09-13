package com.czl.privileges.controller;

import com.czl.base.idprodect.SnowFlakeId;
import com.czl.base.response.ApiResponse;
import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.privileges.dto.UserInsertDto;
import com.czl.privileges.service.UserService;
import com.czl.privileges.vo.UserInterfacePathVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2020-09-13
 * @创建时间: 17:12
 */
@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param userInsertDto
     * @return
     */
    @PostMapping( "/insert" )
    public ApiResponse addUser ( @RequestBody UserInsertDto userInsertDto) {
        ApiBaseEnum apiBaseEnum = userService.insert ( userInsertDto );
        return ApiResponse.respond(apiBaseEnum);
    }

    /**
     * 根据用户id获得接口权限
     * @param userId
     * @return
     */
    @GetMapping( "/userId/getInterfacePath" )
    public ApiResponse<List<String>> getInterfacePathByUserId ( Long userId) {
        List<String> result= userService.getInterfacePathByUserId ( userId );
        return ApiResponse.respond(result);
    }




}
