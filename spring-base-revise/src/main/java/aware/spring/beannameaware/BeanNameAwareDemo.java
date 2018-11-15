package aware.spring.beannameaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Package: autowire.spring
 * Author: houzm
 * Date: Created in 2018/9/4 8:55
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Component
public class BeanNameAwareDemo implements BeanNameAware{

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println(name);
    }

}
