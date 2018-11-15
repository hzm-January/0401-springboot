package scope.spring.http;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Package: scope.spring.http
 * Author: houzm
 * Date: Created in 2018/9/3 9:06
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
@Scope(value = "http")
public class HttpDemo {
}
