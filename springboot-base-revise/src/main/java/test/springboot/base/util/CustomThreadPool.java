package test.springboot.base.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: test.springboot.base.util
 * Author: houzm
 * Date: Created in 2018/9/29 13:57
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 自定义单例线程池类
 * 拒绝策略为：丢弃任务并抛出异常
 */
public final class CustomThreadPool extends ThreadPoolExecutor {

    private Logger logger = LoggerFactory.getLogger(CustomThreadPool.class);

    private static volatile CustomThreadPool instance;
    private final AtomicLong totalTask = new AtomicLong(0);
    private final AtomicLong totalTime = new AtomicLong(0);
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public static CustomThreadPool getInstance() {
        CustomThreadPool customThreadPoolPre = instance;
        if (customThreadPoolPre == null) {
            synchronized (CustomThreadPool.class) {
                if (customThreadPoolPre == null) {
                    customThreadPoolPre = instance = new CustomThreadPool(Runtime.getRuntime().availableProcessors()+1,
                            400, 20, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(500),
                            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return customThreadPoolPre;
    }
//    @Override
//    protected void beforeExecute(Thread t, Runnable r) {
//        logger.info("THREAD POOL EXECUTE START");
//        startTime.set(System.nanoTime());
//        super.beforeExecute(t, r);
//    }
//
//    @Override
//    protected void afterExecute(Runnable r, Throwable t) {
//        logger.info("THREAD POOL EXECUTE END");
//        Long startTimeLong = startTime.get();
//        long totalTimeOfTheTask = System.nanoTime() - startTimeLong;
//        totalTime.addAndGet(totalTimeOfTheTask);
//        totalTask.incrementAndGet();
//        startTime.remove();
////        super.afterExecute(r, t);
//        String lineSeparator = System.lineSeparator();
//        StringBuffer info = new StringBuffer(100);
//        info.append(lineSeparator+"===================================================="+lineSeparator);
//        info.append("totalTime: "+ totalTime +"-----totalTask: "+ totalTask +lineSeparator);
//        info.append("totalTime/totalTask ："+ totalTime.doubleValue()/ totalTask.doubleValue()+lineSeparator);
//        info.append("核心线程数："+instance.getCorePoolSize()+lineSeparator);
//        info.append("活动线程数："+instance.getActiveCount()+lineSeparator);
//        info.append("排队线程数："+instance.getQueue().size()+lineSeparator);
//        info.append("线程数峰值："+instance.getLargestPoolSize()+lineSeparator);
//        info.append("设置的最大线程数："+instance.getMaximumPoolSize()+lineSeparator);
//        info.append("线程池中线程数："+instance.getPoolSize()+lineSeparator);
//        info.append("任务总数："+instance.getTaskCount()+lineSeparator);
//        info.append("任务完成数："+instance.getCompletedTaskCount()+lineSeparator);
//        info.append("===================================================="+lineSeparator);
//        logger.info(info.toString());
//    }

    @Override
    protected void terminated() {
//        super.terminated();
        String lineSeparator = System.lineSeparator();
        StringBuffer info = new StringBuffer(100);
        info.append(lineSeparator+"===================================================="+lineSeparator);
        info.append("totalTime: "+ totalTime +"-----totalTask: "+ totalTask +lineSeparator);
        info.append("totalTime/totalTask ："+ totalTime.doubleValue()/ totalTask.doubleValue()+lineSeparator);
        info.append("核心线程数："+instance.getCorePoolSize()+lineSeparator);
        info.append("活动线程数："+instance.getActiveCount()+lineSeparator);
        info.append("线程数峰值："+instance.getLargestPoolSize()+lineSeparator);
        info.append("设置的最大线程数："+instance.getMaximumPoolSize()+lineSeparator);
        info.append("线程池中线程数："+instance.getPoolSize()+lineSeparator);
        info.append("任务总数："+instance.getTaskCount()+lineSeparator);
        info.append("任务完成数："+instance.getCompletedTaskCount()+lineSeparator);
        info.append("===================================================="+lineSeparator);
        logger.info(info.toString());
    }
}
