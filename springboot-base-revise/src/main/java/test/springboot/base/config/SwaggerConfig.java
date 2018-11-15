package test.springboot.base.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: test.springboot.base.config
 * Author: houzm
 * Date: Created in 2018/9/29 13:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： swagger2配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("test.springboot.base")
    private String swaggerBasicPackage;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerBasicPackage)).paths(PathSelectors.any()).build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title("Spring MVC Demo")
                .termsOfServiceUrl("https://www.baidu.com")
                .description("Spring Boot My Demo")
                .contact(new Contact("hzm", "https://www.baidu.com", "houzm@pssyun.com"))
                .version("1.0").build();
    }
}
