package conditional.spring.annotationbean;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * Package: conditional.spring
 * Author: houzm
 * Date: Created in 2018/9/4 17:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Service
@Conditional(value = LinuxConditionalDemo.class)
public class LinuxServiceImpl implements ConditionalCommonService{

    @Override
    public void show() {
        System.out.println("linux service impl ： ");
    }
}
