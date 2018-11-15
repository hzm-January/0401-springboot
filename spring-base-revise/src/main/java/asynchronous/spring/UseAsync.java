package asynchronous.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Package: asynchronous.spring
 * Author: houzm
 * Date: Created in 2018/9/4 12:58
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Component
public class UseAsync {

    @Autowired
    public AsynDemo asynDemo;

    /**
     * 无返回值的调用
     */
    public void showUseAsync() {
        System.out.println(">>>> show use async start >>>>");
        IntStream.rangeClosed(0,100).forEach(key->asynDemo.showAsync(key));
        System.out.println(">>>> show use async end >>>>");
    }

    public void showUseAsyncReturn() {
        System.out.println(">>>> show use async start >>>>");
        List<Future<String>> futureList = new ArrayList<>(120);
        IntStream.rangeClosed(0,100).forEach(key->futureList.add(asynDemo.showAsyncHasReturn(key)));
        futureList.stream().forEach(key-> {
            try {
                System.out.println(futureList.size()+"---->"+ key.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(">>>> show use async end >>>>");
    }

}
