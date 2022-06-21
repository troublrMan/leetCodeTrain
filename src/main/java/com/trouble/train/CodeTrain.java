package com.trouble.train;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
public class CodeTrain {

    public static void main(String[] args) {
        SpringApplication.run(CodeTrain.class, args);
    }


//    @Bean
//    public Validator validator() {
//        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
//                .configure()
//                // 快速失败模式
//                .failFast(true)
//                .buildValidatorFactory();
//        return validatorFactory.getValidator();
//    }



}
