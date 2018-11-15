package base.springmvc.configuration;

import base.springmvc.CustomInterceptor;
import base.springmvc.converter.CustomHttpMessageConverter;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: base.springmvc
 * Author: houzm
 * Date: Created in 2018/9/5 9:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */

@Configuration
@EnableWebMvc
@ComponentScan(value = "base.springmvc")
@EnableAspectJAutoProxy
public class BaseConfiguration implements WebMvcConfigurer {

    /*@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".html");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }*/
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

    /**
     * 自定义过滤器注册
     * @return
     */
    @Bean
    public CustomInterceptor customInterceptor() {
        return new CustomInterceptor();
    }

    /**
     * 添加自定义过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor())
                .addPathPatterns("/api/**")  //测试api/**失败
                .excludePathPatterns("/age/**")
                .excludePathPatterns("/hzm/**");
    }

    /**
     * 上传文件解析器
     * MultipartResolver 用于处理文件上传，当收到请求时 DispatcherServlet 的 checkMultipart() 方法
     * 会调用 MultipartResolver的 isMultipart() 方法判断请求中是否包含文件。如果请求数据中包含文件，
     * 则调用 MultipartResolver的 resolveMultipart() 方法对请求的数据进行解析，然后将文件数据解析成 MultipartFile
     * 并封装在 MultipartHttpServletRequest (继承了 HttpServletRequest) 对象中，最后传递给 Controller
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(1000000);
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        return commonsMultipartResolver;
    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customHttpMessageConverter());
    }

    @Bean
    public CustomHttpMessageConverter customHttpMessageConverter() {
        return new CustomHttpMessageConverter();
    }

}
