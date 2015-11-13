package com.lastwarmth.toucheventstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Administrator on 2015/11/12.
 */
public class MyButton extends Button {

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = this.isClickable();
        int action = event.getAction();
        Log.i("MyButton", "onTouchEvent " + event.getAction() + "---" + flag);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                super.onTouchEvent(event);
                return true;
            case MotionEvent.ACTION_MOVE:
                return false;
            case MotionEvent.ACTION_UP:
                super.onTouchEvent(event);
                return false;
            default:
                return true;
        }
    }
}
