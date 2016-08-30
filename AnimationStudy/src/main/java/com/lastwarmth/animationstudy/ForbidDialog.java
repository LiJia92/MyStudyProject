package com.lastwarmth.animationstudy;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kebo on 2016/4/7.
 */
public class ForbidDialog extends Activity {

    private ViewHolder holder = new ViewHolder();
    private ViewGroup.LayoutParams layoutParams;
    private int width;


    class ViewHolder {
        public ImageView close;
        public ImageView icon;
        public TextView nickname;
        public Button forbid;
        public TextView sign;
        public LinearLayout follow;
        public LinearLayout scaleLayout;
        public LinearLayout album;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_forbid);
    }


    @Override
    protected void onStart() {
        super.onStart();
        initHolder();
    }

    private void initHolder() {
        holder.icon = (ImageView) findViewById(R.id.icon_imageview);
        holder.follow = (LinearLayout) findViewById(R.id.fans_profile_follow_tab);
        holder.scaleLayout = (LinearLayout) findViewById(R.id.fans_profile_scale_layout);
        holder.album = (LinearLayout) findViewById(R.id.fans_profile_album_tab);

//        holder.close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutParams = holder.scaleLayout.getLayoutParams();
                if (width == 0) {
                    width = layoutParams.width;
                }
                Log.e("TAG", "start width:" + width);
                ValueAnimator objectAnimator = ValueAnimator.ofInt(width, 0);
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        layoutParams.width = (int) animation.getAnimatedValue();
                        layoutParams.height = (int) animation.getAnimatedValue();
                        holder.scaleLayout.setLayoutParams(layoutParams);
                    }
                });
                AnimatorSet set = new AnimatorSet();
                set.setInterpolator(new LinearInterpolator());
                set.setDuration(400);
                set.play(objectAnimator);
                set.start();
            }
        });

        holder.album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator objectAnimator = ValueAnimator.ofInt(0, width);
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        layoutParams.width = (int) animation.getAnimatedValue();
                        layoutParams.height = (int) animation.getAnimatedValue();
                        holder.scaleLayout.setLayoutParams(layoutParams);
                    }
                });
                AnimatorSet set = new AnimatorSet();
                set.setInterpolator(new LinearInterpolator());
                set.setDuration(400);
                set.play(objectAnimator);
                set.start();
            }
        });
    }
}
