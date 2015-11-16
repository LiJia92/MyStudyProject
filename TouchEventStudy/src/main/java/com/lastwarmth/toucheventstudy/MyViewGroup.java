package com.lastwarmth.toucheventstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/11/12.
 */
public class MyViewGroup extends LinearLayout {
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("MyViewGroup", "onInterceptTouchEvent");
//        return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("MyViewGroup", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MyViewGroup", "onTouchEvent");
//        return super.onTouchEvent(event);
        return true;
    }
}
