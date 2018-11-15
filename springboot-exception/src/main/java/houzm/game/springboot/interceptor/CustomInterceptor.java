package houzm.game.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Package: houzm.game.springboot.interceptor
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 17:57
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： CustomInterceptor
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        boolean contains = requestURI.contains("/error");//为了测试
        if (contains) {
            throw new IllegalStateException("服务错误，稍后重试");
        }
        return true;
    }
}
