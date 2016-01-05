package com.lastwarmth.servicestudy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private MyService.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("TAG", "onServiceDisconnected() executed");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TAG", "onServiceConnected() executed");
            myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button start = (Button) findViewById(R.id.start);
        Button bind = (Button) findViewById(R.id.bind);
        start.setOnClickListener(this);
        bind.setOnClickListener(this);
        Button stop = (Button) findViewById(R.id.stop);
        Button unbind = (Button) findViewById(R.id.unbind);
        stop.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "SecondActivity onDestroy");
    }
}
