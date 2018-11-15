package houzm.game.springboot.config;

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
 * Package: houzm.game.springboot.config
 * Author: houzm
 * Date: Created in 2018/10/23 10:01
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： Swagger Config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value(value = "houzm.game.springboot")
    private String swaggerBasicPackage;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerBasicPackage)).paths(PathSelectors.any()).build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title("Spring MVC Demo")
                .termsOfServiceUrl("https://www.baidu.com")
                .description("Spring Boot & JSR303 My Demo")
                .contact(new Contact("hzm", "https://www.baidu.com", "hzm_dream@163.com"))
                .version("1.0").build();
    }
}
