package com.lastwarmth.asyncmessagestudy;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2015/11/24.
 */
public class MyCallable implements Callable<Boolean> {

    private Boolean result = false;

    @Override
    public Boolean call() throws Exception {
        int i = 10;
        while (i >= 0) {
            Log.d("MyCallable", "Thread is working...");
            Thread.sleep(1000);
            i--;
        }
        if (i == -1) {
            result = true;
            Log.d("MyCallable", "current thread:" + Thread.currentThread());
        }
        return result;
    }
}
