package init.destroy.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Package: init.destroy.spring.bean
 * Author: houzm
 * Date: Created in 2018/9/3 12:13
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Configuration
@ComponentScan(value = "init.destroy.spring.bean")
public class NormalAnnotationConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public NormalAnnotaionBean normalAnnotaionBean() {
        return new NormalAnnotaionBean();
    }
}
