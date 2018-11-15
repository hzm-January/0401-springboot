package init.destroy.spring.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * Package: init.destroy.spring.jsr
 * Author: houzm
 * Date: Created in 2018/9/3 12:18
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class JsrBean {

    @PostConstruct
    public void init() {
        System.out.println("jsrbean init ...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsrbean destroy ...");
    }
}
