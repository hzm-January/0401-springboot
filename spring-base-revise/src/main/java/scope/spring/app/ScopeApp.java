package scope.spring.app;

import scope.spring.configuration.ScopeConfiguration;
import scope.spring.http.HttpDemo;
import scope.spring.prototype.PrototypeDemo;
import scope.spring.singleton.SingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: scope.spring.app
 * Author: houzm
 * Date: Created in 2018/9/3 9:10
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
public class ScopeApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
        SingletonBean singletonBean = (SingletonBean) applicationContext.getBean("singletonBean");
        SingletonBean singletonBean2 = (SingletonBean) applicationContext.getBean("singletonBean");
        System.out.println("singleton : " + (singletonBean==singletonBean2));

        PrototypeDemo prototypeDemo = (PrototypeDemo) applicationContext.getBean("prototypeDemo");
        PrototypeDemo prototypeDemo2 = (PrototypeDemo) applicationContext.getBean("prototypeDemo");
        System.out.println("prototype : " + (prototypeDemo==prototypeDemo2));

        //TODO:测试session和http

    }
}
