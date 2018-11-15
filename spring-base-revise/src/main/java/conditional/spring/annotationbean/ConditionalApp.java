package conditional.spring.annotationbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: conditional.spring
 * Author: houzm
 * Date: Created in 2018/9/4 17:06
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
public class ConditionalApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(ConfigurationConditional.class);
        ConditionalCommonService bean = an.getBean(ConditionalCommonService.class);
        System.out.println("系统名称："+an.getEnvironment().getProperty("os.name"));
        bean.show();
    }
}
