package com.lastwarmth.listviewdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyModel> data = new ArrayList<>();
    private Context mContext;
    private int screenWidth;
    private int screenHeight;
    private LinearLayout contentView;
    LinearLayout.LayoutParams lp;

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            contentView.setLayoutParams(lp);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initData();
        final MyAdapter myAdapter = new MyAdapter(data, this);
        ListView myListView = (ListView) findViewById(R.id.my_list);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                int width1 = view.getWidth();
                int measuredWidth1 = view.getMeasuredWidth();
                Log.i("width", "width1=" + width1 + "   measuredWidth1=" + measuredWidth1);
                Toast.makeText(mContext, ((MyModel) myAdapter.getItem(position)).getGroupName(), Toast.LENGTH_SHORT).show();
//                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0f, -100f);
//                animator.setDuration(1000);
//                animator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        int width2 = view.getWidth();
//                        int measuredWidth2 = view.getMeasuredWidth();
//                        Log.i("width", "width2=" + width2 + "   measuredWidth1=" + measuredWidth2);
//
//                    }
//                });
//                animator.start();
//                contentView = (LinearLayout) view.findViewById(R.id.content);
//                lp = (LinearLayout.LayoutParams) contentView.getLayoutParams();
//                lp.width = width1;
////                new MyUpdateTask().execute();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        int left = 0;
//                        while (left > -200) {
//                            left -= 10;
//                            lp.leftMargin = left;
//                            myHandler.sendEmptyMessage(0);
//                            try {
//                                Thread.sleep(20);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }).start();
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        Log.i("width", "screenWidth=" + screenWidth);
    }

    private void initData() {
        MyModel model1 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg", "1", "111");
        MyModel model2 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg", "2", "222");
        MyModel model3 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg", "3", "333");
        MyModel model4 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg", "4", "444");
        MyModel model5 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg", "5", "555");
        MyModel model6 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg", "6", "666");
        MyModel model7 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg", "7", "777");
        MyModel model8 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg", "8", "888");
        MyModel model9 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg", "9", "999");
        MyModel model10 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg", "10", "101010");
        MyModel model11 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg", "11", "111111");
        MyModel model12 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg", "12", "121212");
        MyModel model13 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg", "13", "131313");
        MyModel model14 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg", "14", "141414");
        MyModel model15 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg", "15", "151515");
        MyModel model16 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg", "16", "161616");
        MyModel model17 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg", "17", "171717");
        MyModel model18 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg", "18", "181818");
        MyModel model19 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760683_3691.jpg", "19", "191919");
        MyModel model20 = new MyModel("http://img.my.csdn.net/uploads/201508/05/1438760683_7315.jpg", "20", "202020");
        data.add(model1);
        data.add(model2);
        data.add(model3);
        data.add(model4);
        data.add(model5);
        data.add(model6);
        data.add(model7);
        data.add(model8);
        data.add(model9);
        data.add(model10);
        data.add(model11);
        data.add(model12);
        data.add(model13);
        data.add(model14);
        data.add(model15);
        data.add(model16);
        data.add(model17);
        data.add(model18);
        data.add(model19);
        data.add(model20);
    }

    private class MyUpdateTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            int leftMargin = 0;
            while (leftMargin > -200) {
                leftMargin = leftMargin - 10;
                publishProgress(leftMargin);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            lp.leftMargin = values[0];
            contentView.setLayoutParams(lp);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            lp.leftMargin = -200;
            contentView.setLayoutParams(lp);
        }
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
