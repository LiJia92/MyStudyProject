package com.lastwarmth.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Jaceli on 2016-05-25.
 */
public class StaticGiftView extends TextView {

    int current = 1;
    int num = 10;

    public StaticGiftView(Context context) {
        super(context);
    }

    public StaticGiftView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StaticGiftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setNum(int num) {
        this.num = num;
        startAnimation();
    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.gift_scale);
        startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                current++;
                if (current <= num) {
                    startAnimation(animation);
                    setText("X " + current);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
