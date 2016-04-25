package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * 仪表盘
 * Created by Jaceli on 2016-04-25.
 */
public class DashboardView extends View {

    private Paint mPanit;
    private RectF rectF;
    private Shader mShader;

    private int targetDegree;
    private int currentDegree;
    private int currentNum;
    private int targetNum;

    public DashboardView(Context context) {
        super(context);
        init();
    }

    public DashboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DashboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPanit = new Paint();
        rectF = new RectF();
        mShader = new RadialGradient(0, 0, (1080 - 300) / 2, 0xffde5669, 0xffe79950, Shader.TileMode.MIRROR);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            currentDegree += 5;
            currentNum += currentDegree / 1000f * 259;
            if (currentDegree < targetDegree) {
                handler.sendEmptyMessageDelayed(0, 5);
            } else {
                currentDegree = targetDegree;
                currentNum = targetNum;
            }
            invalidate();
        }
    };

    public void setNum(int num) {
        targetNum = num;
        targetDegree = (int) (targetNum / 1000f * 259);
        handler.sendEmptyMessageDelayed(0, 400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPanit.reset();
        mPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPanit.setColor(Color.GRAY);
        mPanit.setStrokeWidth(40);
        mPanit.setStyle(Paint.Style.STROKE);
        mPanit.setStrokeCap(Paint.Cap.ROUND);
        rectF.top = getMeasuredHeight() / 2 - getMeasuredWidth() / 4;
        rectF.left = getMeasuredWidth() / 4;
        rectF.right = getWidth() / 4 * 3;
        rectF.bottom = getMeasuredHeight() / 2 + getMeasuredWidth() / 4;
        canvas.drawArc(rectF, 140, 260, false, mPanit);

        mPanit.reset();
        mPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPanit.setColor(Color.GRAY);
        mPanit.setStrokeWidth(3);
        canvas.drawLine(getMeasuredWidth() / 2, rectF.top + 40, getMeasuredWidth() / 2, rectF.top + 60, mPanit);
        for (int i = 0; i < 26; i++) {
            int degrees = (int) (10 * (i + 1) * Math.pow(-1, i));
            canvas.rotate(degrees, getWidth() / 2, getHeight() / 2);
            canvas.drawLine(getMeasuredWidth() / 2, rectF.top + 40, getMeasuredWidth() / 2, rectF.top + 60, mPanit);
        }
        canvas.rotate(130, getWidth() / 2, getHeight() / 2);

        mPanit.reset();
        mPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPanit.setColor(Color.DKGRAY);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, 80, mPanit);

        mPanit.reset();
        mPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPanit.setShader(mShader);
        mPanit.setStyle(Paint.Style.STROKE);
        mPanit.setStrokeWidth(40);
        mPanit.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, 140, currentDegree, false, mPanit);

        mPanit.reset();
        mPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPanit.setColor(Color.parseColor("#ffde5669"));
        mPanit.setTextSize(70);
        canvas.drawText(String.valueOf(currentNum), getMeasuredWidth() / 2 - 55, getMeasuredHeight() / 2 + 25, mPanit);
    }
}
