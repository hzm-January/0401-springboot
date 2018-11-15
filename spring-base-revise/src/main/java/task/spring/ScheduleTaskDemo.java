package task.spring;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Package: task.spring
 * Author: houzm
 * Date: Created in 2018/9/4 12:11
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： schedule task
 */
@Component
public class ScheduleTaskDemo {

    @Scheduled(cron = "0 * * * * ?")
    public void show(){
        System.out.println(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(DateTime.now()));
    }
}
