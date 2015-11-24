package com.lastwarmth.asyncmessagestudy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private Handler handler1;

    private class MyHandler extends Handler {

        private WeakReference<TextView> textView;

        MyHandler(TextView textView) {
            this.textView = new WeakReference<>(textView);
        }

        @Override
        public void handleMessage(Message msg) {
            TextView text = textView.get();
            if (text != null) {
                text.setText("Hello2!!!");
            }
        }
    }

    private MyHandler handler2;
    private TextView hello;
    private FutureTask<Boolean> myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hello = (TextView) findViewById(R.id.hello);
        handler1 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                hello.setText("hello1!!!");
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                handler2 = new MyHandler(hello);
                Looper.loop();
            }
        }).start();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                handler1.sendEmptyMessage(1000);
//                handler2.sendEmptyMessage(1000);
                Callable<Boolean> myCall = new MyCallable();
                myTask = new FutureTask<>(myCall);
                new Thread(myTask).start();
            }
        });
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
            try {
                Boolean result = myTask.get();
                Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
