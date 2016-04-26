package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Jaceli on 2016-04-26.
 */
public class CustomArcSeekBar extends View {

    private Paint paint;
    private int measuredWidth;
    private int measuredHeight;
    private int top;
    private int right;
    private int bottom;
    private int left;

    private RectF rectF;
    private boolean isMeasured;

    public CustomArcSeekBar(Context context) {
        super(context);
        init();
    }

    public CustomArcSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomArcSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        if (changed && !isMeasured) {
//            ViewTreeObserver vto = getViewTreeObserver();
//            vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//                public boolean onPreDraw() {
//                    getViewTreeObserver().removeOnPreDrawListener(this);
//                    measuredWidth = getMeasuredWidth();
//                    measuredHeight = getMeasuredHeight() - 5;
//                    return true;
//                }
//            });
//            isMeasured = true;
//        }
        this.measuredHeight = bottom - top;
        this.measuredWidth = right - left;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    private void init() {
        paint = new Paint();
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("TAG", "width:" + measuredWidth + " height:" + measuredHeight);
        super.onDraw(canvas);
        int a = right - left;
        int b = bottom - top;
        int x = b / 2 + a * a / (8 * b);
        rectF.left = a / 2 - x - 30;
        rectF.right = a / 2 + x + 30;
        rectF.top = 5;
        rectF.bottom = 2 * x + 5 + 60;
        float s = (float) (Math.asin(a / 2f / x) * 180 / Math.PI);
        Log.e("TAG", "left:" + rectF.left + " right:" + rectF.right + " top:" + rectF.top + " bottom:" + rectF.bottom);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, 270 - s, 2 * s, false, paint);
    }
}
