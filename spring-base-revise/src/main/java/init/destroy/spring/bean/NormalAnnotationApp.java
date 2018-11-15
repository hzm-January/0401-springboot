package init.destroy.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: init.destroy.spring.bean
 * Author: houzm
 * Date: Created in 2018/9/3 12:16
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class NormalAnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NormalAnnotationConfiguration.class);
        NormalAnnotaionBean bean = applicationContext.getBean(NormalAnnotaionBean.class);
        applicationContext.close();
    }
}
