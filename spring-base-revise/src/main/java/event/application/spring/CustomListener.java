package event.application.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Package: event.application.spring
 * Author: houzm
 * Date: Created in 2018/9/3 13:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        String message = event.getMessage();
        String userId = event.getUserId();
        System.out.println(message + "  :  "+userId);
    }
}
