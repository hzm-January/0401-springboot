package test.springboot.base.service;

import test.springboot.base.util.CustomThreadPool;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Package: test.springboot.base.service
 * Author: houzm
 * Date: Created in 2018/9/29 13:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 事务测试类
 */
@Service(value = "tansactionServiceBatch")
public class DemoTransactionServiceBatchImpl implements DemoTransactionServiceBatch {

    @Resource(name = "demoTransactionService")
    private DemoTransactionService demoTransactionService;

    @Override
    @Transactional
    public List<String> queryBatch(){
        long start = System.nanoTime();
        LinkedBlockingQueue<Future<String>> batchFuture = new LinkedBlockingQueue<>(500);
        CopyOnWriteArrayList<String> resultList = new CopyOnWriteArrayList<>();
        //1. 获取线程池
        CustomThreadPool executors = CustomThreadPool.getInstance();
        //1.1 栅栏
        CountDownLatch downLatch = new CountDownLatch(1002);
        //2. 生产
        IntStream.rangeClosed(0,1000).forEach(key->{
            Future<String> single = executors.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("key-----"+key);
                    String singleResult = demoTransactionService.querySingle(key);
                    return singleResult;
                }
            });
            try {
//                batchFuture.offer(single, 10, TimeUnit.MILLISECONDS);
                batchFuture.put(single); //阻塞当前线程，不再往下执行消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("剩余downLatch: "+ downLatch.getCount());
                downLatch.countDown();
            }
        });
        while (downLatch.getCount()==1000) {
            try {
                System.out.println("Zzzzz睡觉觉zzzzZ");
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2. 消费
        executors.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Future future = batchFuture.poll(100, TimeUnit.MILLISECONDS);
                        if (future == null) {
                            break;
                        }
                        String singleResult = null;
                        try {
                            singleResult = String.valueOf(future.get());
                            System.out.println(singleResult);
                            resultList.add(singleResult);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
                downLatch.countDown();
            }
        });
        try {
            boolean await = downLatch.await(10, TimeUnit.SECONDS);
            System.out.println("downLatch.getCount():"+downLatch.getCount());
            System.out.println("resultList.size()>>>>>>>"+resultList.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("return ==================");
        System.out.println("耗时："+(TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()-start)));
        return resultList;
    }
}
