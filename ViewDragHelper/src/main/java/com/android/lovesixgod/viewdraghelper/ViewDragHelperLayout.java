package com.android.lovesixgod.viewdraghelper;

import android.content.Context;
import android.graphics.Point;
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

    private Point originPos = new Point();

    private View first;
    private View second;
    private View third;

    public ViewDragHelperLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                // 设置为false，表示View不能被捕获，也就不能移动了，可以根据传入的child来返回响应的true or false
//                return true;
                return child == first || child == second;
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
                int rightBound = getWidth() - child.getWidth() - getPaddingRight();

                return Math.min(Math.max(left, leftBound), rightBound);
//                return left;
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
                int bottomBound = getHeight() - child.getHeight() - getPaddingBottom();

                return Math.min(Math.max(top, topBound), bottomBound);
//                return top;
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                if (releasedChild == second) {
                    viewDragHelper.settleCapturedViewAt(originPos.x, originPos.y);
                    invalidate();
                }
            }

            /**
             * 从边界开始拖拽
             *
             * @param edgeFlags
             * @param pointerId
             */
            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                viewDragHelper.captureChildView(third, pointerId);
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                return getMeasuredWidth() - child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return getMeasuredHeight() - child.getMeasuredHeight();
            }
        });

        viewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_RIGHT); // 设置边界检查
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        originPos.x = second.getLeft();
        originPos.y = second.getTop();
    }

    /**
     * 结合onViewReleased使用，是View在拖动结束后，回到初始位置
     */
    @Override
    public void computeScroll() {
        if (viewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        first = getChildAt(0);
        second = getChildAt(1);
        third = getChildAt(2);
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
