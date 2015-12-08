package com.lastwarmth.viewstudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    private DeleteListView myListView;
//
//    private MyAdapter adapter;
//
//    private List<String> contentList = new ArrayList<>();

    private MyRefreshView refresh;

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
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                AnimatorSet set = new AnimatorSet();
//                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0.5f, 1f);
//                ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0, 1.2f, 1f);
//                ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 1.2f, 1f);
//                ObjectAnimator translateX = ObjectAnimator.ofFloat(imageView, "translationX", 0, 500);
//                ObjectAnimator translateY = ObjectAnimator.ofFloat(imageView, "translationY", 0, -500);
//                ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0, 1080);
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator);
//                animator.setInterpolator(new OvershootInterpolator());
//                animator.setDuration(200);
//                animator.setTarget(imageView);
//                animator.start();
            }
        });

//        RelativeLayout parent = (RelativeLayout) findViewById(R.id.parent);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View button = inflater.inflate(R.layout.button_layout, parent, false);
//        parent.addView(button);
//        Log.i("TAG", button.getWidth() + "---------" + button.getMeasuredWidth());

//        initList();
//        myListView = (DeleteListView) findViewById(R.id.my_list_view);
//        myListView.setOnDeleteListener(new DeleteListView.OnDeleteListener() {
//            @Override
//            public void onDelete(int index) {
//                contentList.remove(index);
//                adapter.notifyDataSetChanged();
//            }
//        });
//        adapter = new MyAdapter(this, 0, contentList);
//        myListView.setAdapter(adapter);
    }

//    private void initList() {
//        contentList.add("Content Item 1");
//        contentList.add("Content Item 2");
//        contentList.add("Content Item 3");
//        contentList.add("Content Item 4");
//        contentList.add("Content Item 5");
//        contentList.add("Content Item 6");
//        contentList.add("Content Item 7");
//        contentList.add("Content Item 8");
//        contentList.add("Content Item 9");
//        contentList.add("Content Item 10");
//        contentList.add("Content Item 11");
//        contentList.add("Content Item 12");
//        contentList.add("Content Item 13");
//        contentList.add("Content Item 14");
//        contentList.add("Content Item 15");
//        contentList.add("Content Item 16");
//        contentList.add("Content Item 17");
//        contentList.add("Content Item 18");
//        contentList.add("Content Item 19");
//        contentList.add("Content Item 20");
//    }

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
            refresh.stopAnimation();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
