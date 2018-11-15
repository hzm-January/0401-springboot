package aware.spring.messageaware;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Package: aware.spring.beannameaware
 * Author: houzm
 * Date: Created in 2018/9/4 9:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Configuration
@ComponentScan(value = "aware.spring.messageaware")
//@PropertySource(value = {"messages_en_US.properties", "messages_zh_CN.properties"})
public class ConfigurationBean {



    @Bean
    public MessageSource messageResource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
//        resourceBundleMessageSource.setBasename("messages");
        resourceBundleMessageSource.setBasenames("messages");
        resourceBundleMessageSource.setDefaultEncoding("utf-8");
        resourceBundleMessageSource.setCacheSeconds(15);
        resourceBundleMessageSource.setFallbackToSystemLocale(true);
        resourceBundleMessageSource.setAlwaysUseMessageFormat(true);
        return resourceBundleMessageSource;
    }
}
