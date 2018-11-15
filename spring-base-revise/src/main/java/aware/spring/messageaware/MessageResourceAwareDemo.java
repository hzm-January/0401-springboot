package aware.spring.messageaware;

import java.util.Locale;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.MessageSource;
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
public class MessageResourceAwareDemo implements MessageSourceAware{

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
            this.messageSource = messageSource;
    }
    public void showName() {
        String message = messageSource.getMessage("user.name", new Object[]{}, Locale.US);
        System.out.println(message);

    }
}
