package com.wdxxl.bio.fake;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FakeBioTimeServerHandlerExecutePool {
    private ExecutorService executor;

    public FakeBioTimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        // Runtime.getRuntime().availableProcessors()
        // 方法返回到Java虚拟机的可用的处理器数量。此值可能会改变在一个特定的虚拟机调用。
        // 应用程序可用处理器的数量是敏感的，因此偶尔查询该属性，并适当地调整自己的资源使用情况.
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
}
