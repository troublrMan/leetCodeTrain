package com.trouble.train.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author troubleMan
 * @description 参数验证controller
 * @Date 2021/12/9 00:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
public class ParamVerifyController {

    @PostMapping("/param/verify")
    public String paramVerify(){

    }
}
