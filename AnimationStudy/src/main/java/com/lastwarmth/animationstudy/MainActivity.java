package com.lastwarmth.animationstudy;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tv_show)
    TextView view;
    @Bind(R.id.start_view)
    Button startBtn;
    @Bind(R.id.stop_btn)
    Button stopBtn;
    @Bind(R.id.start_property)
    Button startProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Date now = new Date();
        Log.i("time", now.getTime() + "");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        view.setOnClickListener(this);
        startProperty.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.start_view:
//                AlphaAnimation alpha = new AlphaAnimation(1.0f, 0f);
//                alpha.setDuration(2000);
//                view.startAnimation(alpha);
//                RotateAnimation rotate = new RotateAnimation(0f, 180f);
//                rotate.setDuration(2000);
//                view.startAnimation(rotate);
//                ScaleAnimation scale = new ScaleAnimation(0f, 2f, 0, 2f);
//                scale.setDuration(2000);
//                view.startAnimation(scale);
//                TranslateAnimation translate = new TranslateAnimation(0f, 200f, 0f, 200f);
//                translate.setDuration(2000);
//                view.startAnimation(translate);
//                AnimationSet set = new AnimationSet(true);
//                AlphaAnimation alpha = new AlphaAnimation(1.0f, 0f);
//                RotateAnimation rotate = new RotateAnimation(0f, 360f);
//                ScaleAnimation scale = new ScaleAnimation(0f, 2f, 0, 2f);
//                TranslateAnimation translate = new TranslateAnimation(-200f, 200f, -200f, 200f);
//                set.addAnimation(alpha);
//                set.addAnimation(scale);
//                set.addAnimation(translate);
//                rotate.setRepeatCount(Animation.INFINITE);
//                rotate.setRepeatMode(Animation.RESTART);
//                alpha.setRepeatCount(Animation.INFINITE);
//                alpha.setRepeatMode(Animation.REVERSE);
//                set.setDuration(5000);
//                set.addAnimation(rotate);
//                set.addAnimation(alpha);
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_animation);
                animation.setInterpolator(new LinearInterpolator());
                view.startAnimation(animation);
                break;
            case R.id.start_property:
//                ValueAnimator anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
//                anim.setDuration(300);
//                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float currentValue = (float) animation.getAnimatedValue();
//                        Log.i("TAG", "cuurent value is " + currentValue);
//                    }
//                });
//                anim.start();
//                ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f, 0f);
//                animator1.setDuration(3000);
//                animator1.start();
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", -500f, 0f);
//                ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
//                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
//                AnimatorSet animSet = new AnimatorSet();
//                animSet.play(rotate).with(fadeInOut).after(moveIn);
//                animSet.setDuration(1000);
//                animSet.addListener(new AnimatorListenerAdapter() {
//
//                });
//                animSet.start();
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.view_animator);
                animator.setTarget(view);
                animator.start();

                break;
            case R.id.stop_btn:
                view.clearAnimation();
                break;
            case R.id.tv_show:
                Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
        }
    }
}
