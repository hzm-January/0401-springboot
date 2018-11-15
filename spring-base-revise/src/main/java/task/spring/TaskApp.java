package task.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: task.spring
 * Author: houzm
 * Date: Created in 2018/9/4 12:18
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class TaskApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ShecduleTaskConfiguration.class);
        ScheduleTaskDemo bean = annotationConfigApplicationContext.getBean(ScheduleTaskDemo.class);
    }
}
