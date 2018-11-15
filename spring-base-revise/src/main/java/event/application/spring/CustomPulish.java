package event.application.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Package: event.application.spring
 * Author: houzm
 * Date: Created in 2018/9/3 13:29
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class CustomPulish {
    @Autowired
    private ApplicationContext applicationContext;

    public void push() {
        applicationContext.publishEvent(new CustomEvent(this, "用户注册成功： ", "1213"));
    }
}
