package houzm.game.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.game.springboot.config
 * Author: houzm
 * Date: Created in 2018/10/22 11:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： jsr mvc config
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "houzm.game.springboot")
public class JsrMvcConfig implements WebMvcConfigurer {
    /**
     * 对外暴露静态资源
     * 已测试：必须配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //1.对外暴露的访问路径 2.对外暴露的文件目录
        //暴露静态资源文件
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        //暴露swagger静态资源文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("favicon.ico").addResourceLocations("/favicon.ico");
    }
}
