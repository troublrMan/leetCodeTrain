package com.trouble.train.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author troubleMan
 * @description test类
 * @Date 2021/12/9 00:02
 * @Version 1.0
 **/
@Data
public class ParamVerifyRequest implements Serializable {


    @NotEmpty(message = "userName is not empty!")
    private String userName;


    @NotBlank(message = "phone is not empty!")
    private String phone;


}
