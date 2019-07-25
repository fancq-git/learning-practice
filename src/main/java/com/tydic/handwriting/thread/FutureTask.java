package com.tydic.handwriting.thread;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

/**
 * 手写模拟FutureTask
 * @author fancq
 * @date 2019/7/16 0:09
 */
public class FutureTask<V> implements Runnable, Future<V> {
    private Callable callable;

    private V result;

    public FutureTask(Callable callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            result = (V) callable.call();
            synchronized (this) {
                this.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        if (result != null)
            return result;
        synchronized (this) {
            this.wait();
        }
        return result;
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (result != null)
            return result;
        unit.sleep(timeout);
        return null;
    }
}
