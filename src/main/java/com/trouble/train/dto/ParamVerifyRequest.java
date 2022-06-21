package com.trouble.train.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author troubleMan
 * @description test类
 * @Date 2021/12/9 00:02
 * @Version 1.0
 **/
@Data
public class ParamVerifyRequest implements Serializable {


    @NotNull
    @Size(min = 2, max = 10)
    private String userName;


    @NotBlank(message = "phone is not empty!")
    private String phone;


}
