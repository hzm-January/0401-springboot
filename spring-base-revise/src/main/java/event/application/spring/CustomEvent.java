package event.application.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Package: event.application.spring
 * Author: houzm
 * Date: Created in 2018/9/3 13:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 自定义事件
 */
public class CustomEvent extends ApplicationEvent {

    private String message;
    private String userId;

    public CustomEvent(Object source, String msg, String userId) {
        super(source);
        this.message = msg;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
