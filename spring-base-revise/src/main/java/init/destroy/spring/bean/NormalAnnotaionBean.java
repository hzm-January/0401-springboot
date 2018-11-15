package init.destroy.spring.bean;

/**
 * Package: init.destroy.spring.bean
 * Author: houzm
 * Date: Created in 2018/9/3 12:10
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： @Bean(init= , destroy= )
 */
public class NormalAnnotaionBean {

    public void init() {
        System.out.println("normal annotation bean init...");
    }

    public void destroy() {
        System.out.println("normal annotation bean destroy...");
    }
}
