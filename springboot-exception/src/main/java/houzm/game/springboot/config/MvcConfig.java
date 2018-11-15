package houzm.game.springboot.config;

import houzm.game.springboot.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.game.springboot.config
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 17:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public CustomInterceptor customInterceptor() {
        return new CustomInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor()).addPathPatterns("/api/**");
    }
}
