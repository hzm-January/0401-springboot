package conditional.spring.configbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Package: conditional.spring
 * Author: houzm
 * Date: Created in 2018/9/4 17:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Configuration
@ComponentScan(value = "conditional.spring")
public class ConfigurationConditional {
    @Bean
    @Conditional(value = WindowsConditionalDemo.class)
    public ConditionalCommonService getLinuxService() {
        return new WindowsServiceImpl();
    }

    @Bean
    @Conditional(value = LinuxConditionalDemo.class)
    public ConditionalCommonService getWindowsService() {
        return new LinuxServiceImpl();
    }
}
