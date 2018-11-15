package asynchronous.spring;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * Package: asynchronous.spring
 * Author: houzm
 * Date: Created in 2018/9/4 12:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class AsynDemo {

    @Async
    public void showAsync(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===================");
        System.out.println("show async "+i + "---" + Thread.currentThread().getName());
        System.out.println("===================");
    }

    @Async
    public Future<String> showAsyncHasReturn(int i) {
        return new AsyncResult<String>("show async "+i + "---" + Thread.currentThread().getName());
    }

}
