package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jaceli on 2016-09-21.
 */
public class SkewView extends View {

    // 画笔
    private Paint mPaint = new Paint();

    private int mWidth, mHeight;

    public SkewView(Context context) {
        super(context);
    }

    public SkewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(0, 0, 200, 200);   // 矩形区域

        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);

        canvas.skew(-1, 0);                       // 水平错切 <- 45度

        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }
}
