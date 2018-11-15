package scope.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Package: scope.spring.configuration
 * Author: houzm
 * Date: Created in 2018/9/3 9:09
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： scope configuration
 */
@Configuration
@ComponentScan(value = "scope.spring")
public class ScopeConfiguration {
}
