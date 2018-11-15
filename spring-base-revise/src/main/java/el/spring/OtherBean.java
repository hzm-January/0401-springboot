package el.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Package: el.spring
 * Author: houzm
 * Date: Created in 2018/9/3 9:44
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class OtherBean {
    @Value("黑旋风李逵")
    public String otherName;
}
