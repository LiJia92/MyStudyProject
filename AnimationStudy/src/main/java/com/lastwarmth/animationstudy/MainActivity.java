package com.lastwarmth.animationstudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tv_show)
    TextView view;
    @Bind(R.id.start_btn)
    Button startBtn;
    @Bind(R.id.stop_btn)
    Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
            case R.id.start_btn:
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
//                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.view_animator);
//                animator.setTarget(view);
//                animator.start();
                break;
            case R.id.stop_btn:
                view.clearAnimation();
                break;
            case R.id.tv_show:
                Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
        }
    }
}
