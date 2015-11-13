package com.lastwarmth.listviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/13.
 */
public class MyTest extends TextView {

    public MyTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i("MyTest", "MyTest");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("MyTest", "onLayout");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("MyTest", "onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("MyTest", "onDraw");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i("MyTest", "onFinishInflate");
    }
}
