package base.spring.app;

import base.spring.config.UserConfiguration;
import base.spring.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Package: base.spring.app
 * Author: houzm
 * Date: Created in 2018/9/2 20:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class UserApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);
        UserController userController = (UserController) context.getBean("userController");
        userController.query("12");
    }
}
