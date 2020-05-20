package com.czl.business.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-20
 * @创建时间: 15:28
 */
@RestController
public class UserController {

    @GetMapping("user/login")
    public String login  ( ){
        return "success";
    }
}
