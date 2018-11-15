package profile.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Package: profile.spring
 * Author: houzm
 * Date: Created in 2018/9/3 12:34
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@ComponentScan(value = "profile.spring")
@Configuration
public class ProfileConfiguration {

    @Bean
    @Profile(value = "dev")
    public SayHelloDemo devSayHelloDemo() {
        return new SayHelloDemo("dev");
    }

    @Bean
    @Profile(value = "pro")
    public SayHelloDemo proSayHelloDemo() {
        return new SayHelloDemo("pro");
    }
}
