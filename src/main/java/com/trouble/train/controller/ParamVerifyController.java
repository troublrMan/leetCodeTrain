package com.trouble.train.controller;

import com.google.common.collect.Lists;
import com.trouble.train.dto.ParamVerifyRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public String paramVerify(@RequestBody @Valid ParamVerifyRequest paramVerifyRequest) {
        List<String> arrys = Lists.newArrayList();
        List<String> a = new ArrayList<>();
        return "success message" + paramVerifyRequest.getPhone();
    }
}
