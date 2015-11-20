package com.lastwarmth.animationstudy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/11/5.
 */
public class MyPoint extends View {

    public static final float RADIUS = 50f;

    private PointF currentPoint;

    private Paint mPaint;

    public MyPoint(Context context) {
        super(context);
    }

    /**
     * 若要使自定义View能够在xml中定义属性，则必须至少重写(Context context, AttributeSet attrs)的构造方法
     * @param context
     * @param attrs
     */
    public MyPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new PointF(RADIUS, RADIUS);
            canvas.drawCircle(currentPoint.x, currentPoint.y, RADIUS, mPaint);
            startAnimation();
        } else {
            canvas.drawCircle(currentPoint.x, currentPoint.y, RADIUS, mPaint);
        }
    }

    private void startAnimation(){
        PointF startPoint = new PointF(RADIUS, RADIUS);
        PointF endPoint = new PointF(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointFEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PointF) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {

        });
        anim.setDuration(5000);
        anim.start();
    }
}
