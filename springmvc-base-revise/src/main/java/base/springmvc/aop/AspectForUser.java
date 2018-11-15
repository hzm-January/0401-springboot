package base.springmvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Package: base.springmvc.aop
 * Author: houzm
 * Date: Created in 2018/9/17 10:51
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： aspect for user
 */
@Component
@Aspect
public class AspectForUser {

    private Logger logger = LoggerFactory.getLogger(AspectForUser.class);

    @Pointcut(value = "base.springmvc.aop.PointcutsForUser.pointCut()")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void before() {
        logger.debug("======= before user operation =======");
    }

    @After(value = "pointCut()")
    public void after() {
        logger.debug("======= after user operation =======");
    }
}
