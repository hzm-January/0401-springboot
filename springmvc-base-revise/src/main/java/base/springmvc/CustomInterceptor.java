package base.springmvc;

import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Package: base.springmvc
 * Author: houzm
 * Date: Created in 2018/9/6 9:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：自定义过滤器
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DateTime startTime = DateTime.now();
        logger.debug(">>> START TIME >>> {}", startTime.toString("yyyy-MM-dd HH:mm:ss SSS"));
        request.setAttribute("STARTTIME", startTime.getMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        DateTime dateTimeOfEnd = new DateTime(endTime);
        logger.debug(">>> END TIME >>> {}", dateTimeOfEnd.toString("yyyy-MM-dd HH:mm:ss SSS"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        DateTime endTime = new DateTime();

        Long excutionTime = endTime.getMillis() -(Long)request.getAttribute("STARTTIME");
        logger.debug(">>> FINISH TIME >>> {}", TimeUnit.SECONDS.toSeconds(excutionTime));
        request.setAttribute("EXCUTIONTIME", excutionTime);
        request.removeAttribute("STARTTIME");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
