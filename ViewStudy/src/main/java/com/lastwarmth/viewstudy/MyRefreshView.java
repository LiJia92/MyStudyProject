package com.lastwarmth.viewstudy;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Administrator on 2015/11/23.
 */
public class MyRefreshView extends View {

    private Paint mPaint;
    private Context mContext;
    private int radius;
    private RectF mOval;
    private int angle = 0;
    private ValueAnimator changeAngle;
    private ObjectAnimator animator;

    public MyRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dip2px(2));
        radius = dip2px(50);
        mOval = new RectF(2, 2, radius * 2, radius * 2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (changeAngle == null) {
            canvas.drawArc(mOval, -90, angle, false, mPaint);
            startAnimation();
        } else {
            canvas.drawArc(mOval, -90, angle, false, mPaint);
        }
    }

    public int dip2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mContext.getResources().getDisplayMetrics());
    }

//    public int getAngle() {
//        return angle;
//    }

//    public void setAngle(int angle) {
//        this.angle = angle;
//        invalidate();
//    }

    public void startAnimation() {
        changeAngle = new ValueAnimator().ofInt(0,360);
        changeAngle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                angle = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        changeAngle.setDuration(1000);
        changeAngle.setInterpolator(new LinearInterpolator());
//        changeAngle.setRepeatMode(ValueAnimator.RESTART);
//        changeAngle.setRepeatCount(ValueAnimator.INFINITE);
        changeAngle.start();

//        animator = new ObjectAnimator().ofInt(this, "angle", -90, 270);
//        animator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                angle = (int) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
//        animator.setDuration(1000);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.setRepeatMode(ObjectAnimator.RESTART);
//        animator.setRepeatCount(ObjectAnimator.INFINITE);
//        animator.start();
    }

    public void stopAnimation() {
        if (changeAngle.isRunning()) {
            changeAngle.cancel();
        }
    }
}
