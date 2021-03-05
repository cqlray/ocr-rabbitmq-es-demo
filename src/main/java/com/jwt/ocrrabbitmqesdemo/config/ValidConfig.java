package com.jwt.ocrrabbitmqesdemo.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidConfig {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        // 设置validator模式为快速失败返回
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                // 设置validator模式为快速失败（只要有一个校验不通过就不立即返回错误）
                .failFast(true)
//                .addProperty( "hibernate.validator.fail_fast", "true" ) // 和上一个方法等同
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
