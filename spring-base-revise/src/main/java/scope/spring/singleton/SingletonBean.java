package scope.spring.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Package: scope.spring.singleton
 * Author: houzm
 * Date: Created in 2018/9/3 8:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 单例测试
 */
@Component
@Scope(value = "singleton")
public class SingletonBean {

}
