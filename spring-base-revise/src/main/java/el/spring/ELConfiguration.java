package el.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Package: el.spring
 * Author: houzm
 * Date: Created in 2018/9/3 9:31
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： el configuration
 */
@ComponentScan(value = "el.spring")
@Configuration
@PropertySource(value = "db.properties")
public class ELConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
