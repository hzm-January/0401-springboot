package scope.spring.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Package: scope.spring.prototype
 * Author: houzm
 * Date: Created in 2018/9/3 9:04
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
@Scope(value = "prototype")
public class PrototypeDemo {
}
