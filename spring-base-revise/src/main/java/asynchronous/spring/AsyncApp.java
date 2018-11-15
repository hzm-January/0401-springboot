package asynchronous.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: asynchronous.spring
 * Author: houzm
 * Date: Created in 2018/9/4 13:00
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class AsyncApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(ConfigurationAsync.class);
        UseAsync bean = an.getBean(UseAsync.class);
//        bean.showUseAsync();
        bean.showUseAsyncReturn();
        an.close();
    }
}
