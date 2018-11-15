package el.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: el.spring
 * Author: houzm
 * Date: Created in 2018/9/3 9:29
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ElApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ELConfiguration.class);
        ELDemo el = applicationContext.getBean(ELDemo.class);
        el.show();
    }
}
