package init.destroy.spring.jsr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: init.destroy.spring.jsr
 * Author: houzm
 * Date: Created in 2018/9/3 12:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class JsrApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JsrConfiguration.class);
        JsrBean bean = annotationConfigApplicationContext.getBean(JsrBean.class);
        annotationConfigApplicationContext.close();
    }
}
