package com.lastwarmth.okhttpstudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        enqueue();
    }

    public void execute() throws Exception {
        Request request = new Request.Builder()
                .url("http://218.18.114.97:7007/batian/service/getCourseTypeList.json")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            Log.i("TAG", response.code() + "");
            Log.i("TAG", response.body().string());
        }
    }

    private void enqueue() {
        Request request = new Request.Builder()
                .url("http://218.18.114.97:7007/batian/service/getUserByToken.json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                //NOT UI Thread
                if (response.isSuccessful()) {
                    Log.i("TAG", response.code() + "");
                    Log.i("TAG", response.body().string());
                }
            }
        });

        RequestBody formBody = new FormEncodingBuilder()
                .add("currentPage", "1")
                .add("pageCount", "20")
                .add("priceAsc", "'true'")
                .build();

        Request request1 = new Request.Builder()
                .url("http://10.10.25.132:8080/batian/agrNewsServlet")
                .post(formBody)
                .build();

        client.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.i("TAG", response.code() + "");
                    Log.i("TAG", response.body().string());
                }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
