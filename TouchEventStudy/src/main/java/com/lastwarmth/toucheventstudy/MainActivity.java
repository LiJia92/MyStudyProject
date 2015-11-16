package com.lastwarmth.toucheventstudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

//        MyTextView myTextView = (MyTextView) findViewById(R.id.text);
//        myTextView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                Log.i("MyTextView", "onTouch " + event.getAction());
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        return true;
//                    case MotionEvent.ACTION_MOVE:
//                        return false;
//                    case MotionEvent.ACTION_UP:
//                        return false;
//                    default:
//                        return true;
//                }
//            }
//        });
//
//        MyButton myButton = (MyButton) findViewById(R.id.my_button);
//        myButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                Log.i("MyButton", "onTouch " + event.getAction());
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        return false;
//                    case MotionEvent.ACTION_MOVE:
//                        return false;
//                    case MotionEvent.ACTION_UP:
//                        return false;
//                    default:
//                        return true;
//                }
//            }
//        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("MainActivity", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MainActivity", "onTouchEvent");
        return super.onTouchEvent(event);
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
}
