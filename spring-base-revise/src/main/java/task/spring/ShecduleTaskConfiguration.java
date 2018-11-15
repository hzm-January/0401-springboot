package task.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Package: task.spring
 * Author: houzm
 * Date: Created in 2018/9/4 12:17
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@EnableScheduling
@Configuration
@ComponentScan(value = "task.spring")
public class ShecduleTaskConfiguration {

}
