package base.springmvc.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Package: base.springmvc.aop
 * Author: houzm
 * Date: Created in 2018/9/17 16:33
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class PointcutsForUser {
    @Pointcut(value = "execution(public * base.springmvc.aop.UserService.*(..))")
    public void pointCut() {}
}
