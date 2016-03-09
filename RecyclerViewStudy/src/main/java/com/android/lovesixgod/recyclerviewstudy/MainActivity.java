package com.android.lovesixgod.recyclerviewstudy;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> data;
    private MyRecyclerAdapter adapter;

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
                adapter.addData(1);
            }
        });

        initData();
        adapter = new MyRecyclerAdapter(this, data);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.VERTICAL));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }

    protected void initData() {
        data = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            data.add("" + (char) i);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

        private List<Integer> heights;
        private Context context;
        private List<String> data;

        public MyRecyclerAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;

            heights = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                heights.add((int) (150 + Math.random() * 200));
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            params.height = heights.get(position);
            holder.itemView.setLayoutParams(params);
            holder.numText.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView numText;

            public MyViewHolder(View itemView) {
                super(itemView);
                numText = (TextView) itemView.findViewById(R.id.id_num);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show();
                    }
                });

                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(context, "onLongClick", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        }

        public void addData(int position) {
            data.add(position, "Insert One");
            notifyItemInserted(position);
        }

        public void removeData(int position) {
            data.remove(position);
            notifyItemRemoved(position);
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
            adapter.removeData(1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
