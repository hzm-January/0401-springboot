package event.application.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: event.application.spring
 * Author: houzm
 * Date: Created in 2018/9/3 13:33
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
public class EventApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfiguration.class);
        CustomPulish bean = applicationContext.getBean(CustomPulish.class);
        bean.push();
        applicationContext.close();
    }

}
