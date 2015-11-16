package com.lastwarmth.toucheventstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/12.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("MyTextView", "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MyTextView", "onTouchEvent");
//        int action = event.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                return false;
//            case MotionEvent.ACTION_UP:
//                return false;
//            default:
//                return true;
//        }
        return super.onTouchEvent(event);
    }

}
