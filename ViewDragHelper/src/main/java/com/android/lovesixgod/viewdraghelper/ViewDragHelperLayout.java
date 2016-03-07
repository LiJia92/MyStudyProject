package com.android.lovesixgod.viewdraghelper;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Lijia on 2016-03-07.
 */
public class ViewDragHelperLayout extends LinearLayout {

    private ViewDragHelper viewDragHelper;

    public ViewDragHelperLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                // 设置为false，表示View不能被捕获，也就不能移动了，可以根据传入的child来返回响应的true or false
                return true;
            }

            /**
             * 这个方法必须复写，因为默认的是0，随便拖拽一下就到了最左边
             *
             * @param child
             * @param left
             * @param dx
             * @return
             */
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                // paddingLeft <= 横向移动的位置 <= getWidth - dragView.getWidth - paddingRight
                int leftBound = getPaddingLeft();
                int rightBound = getWidth() - viewDragHelper.getCapturedView().getWidth() - getPaddingRight();

                return Math.min(Math.max(left, leftBound), rightBound);
            }

            /**
             * 这个方法必须复写，因为默认的是0，随便拖拽一下就到了最上边
             *
             * @param child
             * @param top
             * @param dy
             * @return
             */
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                // paddingTop <= 纵向移动的位置 <= getHeight - dragView.getHeight - paddingBottom
                int topBound = getPaddingTop();
                int bottomBound = getHeight() - viewDragHelper.getCapturedView().getHeight() - getPaddingBottom();

                return Math.min(Math.max(top, topBound), bottomBound);
            }
        });


    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true; // 返回true，将事件交给ViewDragHelper处理
    }
}
