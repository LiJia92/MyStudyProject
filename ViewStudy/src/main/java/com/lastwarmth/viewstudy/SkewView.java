package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
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
        Path path = new Path();                     // 创建Path

        // 错切
//        RectF rect = new RectF(0, 0, 200, 200);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect, mPaint);
//
//        canvas.skew(-1, 0);                       // 水平错切 <- 45度
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect, mPaint);

//      // setLastPoint
//        path.lineTo(200, 200);                      // lineTo
//
//        path.setLastPoint(200,100);                 // setLastPoint
//
//        path.lineTo(200,0);                         // lineTo
//
//        canvas.drawPath(path, mPaint);              // 绘制Path

        // close
//        path.lineTo(200, 200);                      // lineTo
//
//        path.moveTo(200,100);                       // moveTo
//
//        path.lineTo(200,0);                         // lineTo
//
//        path.close();
//
//        canvas.drawPath(path, mPaint);              // 绘制Path

        // Direction CCW逆时针 CW顺时针
//        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);
//
//        path.setLastPoint(-300, 300);                // <-- 重置最后一个点的位置
//
//        canvas.drawPath(path, mPaint);

        canvas.scale(1, -1);
        path.lineTo(100, 100);

        RectF oval = new RectF(0, 0, 300, 300);

//        path.addArc(oval, 0, 270);
        path.arcTo(oval, 0, 270, true);             // <-- 和上面一句作用等价

        canvas.drawPath(path, mPaint);
    }
}
