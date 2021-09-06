package com.trouble.spring.spring001;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author troubleMan
 * @description bootdemo
 * @Date 2021/6/6 5:21 下午
 * @Version 1.0
 **/
@RestController
public class BootDemo {

    @GetMapping("/say/hello")
    public String saySomeThing(){
        return "胖子弹";
    }
}
