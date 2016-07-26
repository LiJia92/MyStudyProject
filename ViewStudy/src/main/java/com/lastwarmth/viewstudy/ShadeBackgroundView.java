package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jaceli on 2016-07-22.
 */
public class ShadeBackgroundView extends View {

    private Paint mPaint;// 画笔
    private Context mContext;// 上下文环境引用
    private int left, top, right, bottom;//
    private static final int RECT_SIZE = 800;

    public ShadeBackgroundView(Context context) {
        super(context);
    }

    public ShadeBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRes(context);
        initPaint();
    }

    public ShadeBackgroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        // 实例化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        LinearGradient linearGradient = new LinearGradient(0, top, 0, bottom, 0x10000000, 0x00000000, Shader.TileMode.REPEAT);
        // 设置画笔遮罩滤镜
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        mPaint.setShader(linearGradient);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    /**
     * 初始化资源
     */
    private void initRes(Context context) {
        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
        left = context.getResources().getDisplayMetrics().widthPixels / 2 - RECT_SIZE / 2;
        top = context.getResources().getDisplayMetrics().heightPixels / 2 - RECT_SIZE / 2;
        right = context.getResources().getDisplayMetrics().widthPixels / 2 + RECT_SIZE / 2;
        bottom = context.getResources().getDisplayMetrics().heightPixels / 2 + RECT_SIZE / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
