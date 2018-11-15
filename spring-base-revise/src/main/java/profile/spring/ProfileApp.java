package profile.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: profile.spring
 * Author: houzm
 * Date: Created in 2018/9/3 12:37
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ProfileApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("pro");
        applicationContext.register(ProfileConfiguration.class);
        applicationContext.refresh();
        SayHelloDemo bean = applicationContext.getBean(SayHelloDemo.class);
        bean.show();
        applicationContext.close();
    }
}
