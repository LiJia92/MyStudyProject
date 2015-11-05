package com.lastwarmth.animationstudy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private final static int SPLASH_TO_HOME = 1000;

    @Bind(R.id.splash_view)
    ImageView splashView;
    private Context mContext = this;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.scale_in, 0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);
        mHandler.sendEmptyMessageDelayed(SPLASH_TO_HOME, SPLASH_DISPLAY_LENGHT);
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fadein);
        splashView.startAnimation(animation);
        Date now = new Date();
        Log.i("time", now.getTime() + "");
    }

}
