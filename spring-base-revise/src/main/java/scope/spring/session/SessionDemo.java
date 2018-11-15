package scope.spring.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Package: scope.spring
 * Author: houzm
 * Date: Created in 2018/9/3 9:04
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： scope session
 *
 *  web项目中每个http session 新建一个bean
 *
 */
@Component
@Scope(value = "session")
public class SessionDemo {
}
