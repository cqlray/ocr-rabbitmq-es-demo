package com.jwt.ocrrabbitmqesdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class})
@EnableSwagger2
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(new HashSet<>(
                        Arrays.asList(
                                "application/xml",
                                "application/json")))
                .alternateTypeRules(newRule(
                        LocalDate.class,
                        String.class))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jwt.ocrrabbitmqesdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ocr、rabbitmq、elasticsearch测试接口")
                .contact(new Contact("", "", ""))
                .version("1.0")
                .license("")
                .licenseUrl("")
                .description("ocr、rabbitmq、elasticsearch测试接口描述")
                .build();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor).
//                addPathPatterns("/**")
//                .excludePathPatterns("/webjars/**","/swagger-resources/**","/error**","/swagger-ui.html");
//    }
}