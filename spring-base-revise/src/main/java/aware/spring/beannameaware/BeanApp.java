package aware.spring.beannameaware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: aware.spring.beannameaware
 * Author: houzm
 * Date: Created in 2018/9/4 9:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class BeanApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigurationOfBean.class);
        BeanNameAwareDemo bean = annotationConfigApplicationContext.getBean(BeanNameAwareDemo.class);
        bean.showName();
        annotationConfigApplicationContext.close();
    }
}
