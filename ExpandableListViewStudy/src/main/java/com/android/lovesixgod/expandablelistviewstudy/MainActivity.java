package com.android.lovesixgod.expandablelistviewstudy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView list = null;
    List<String> parent = null;
    Map<String, List<String>> map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        list = (ExpandableListView) findViewById(R.id.expandable_list);
        list.setAdapter(new MyAdapter());
    }

    // 初始化数据
    public void initData() {
        parent = new ArrayList<>();
        parent.add("parent1");
        parent.add("parent2");
        parent.add("parent3");
        parent.add("parent4");
        parent.add("parent5");
        parent.add("parent6");

        map = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        list1.add("child1-1");
        list1.add("child1-2");
        list1.add("child1-3");
        map.put("parent1", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("child2-1");
        list2.add("child2-2");
        list2.add("child2-3");
        map.put("parent2", list2);

        List<String> list3 = new ArrayList<>();
        list3.add("child3-1");
        list3.add("child3-2");
        list3.add("child3-3");
        map.put("parent3", list3);

        List<String> list4 = new ArrayList<>();
        list4.add("child4-1");
        list4.add("child4-2");
        list4.add("child4-3");
        map.put("parent4", list4);

        List<String> list5 = new ArrayList<>();
        list5.add("child5-1");
        list5.add("child5-2");
        list5.add("child5-3");
        map.put("parent5", list5);

        List<String> list6 = new ArrayList<>();
        list6.add("child6-1");
        list6.add("child6-2");
        list6.add("child6-3");
        map.put("parent6", list6);

    }

    class MyAdapter extends BaseExpandableListAdapter {

        //得到子item需要关联的数据
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            String key = parent.get(groupPosition);
            return (map.get(key).get(childPosition));
        }

        //得到子item的ID
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //设置子item的组件
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            String key = MainActivity.this.parent.get(groupPosition);
            String info = map.get(key).get(childPosition);
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_children, parent, false);
            }
            TextView tv = (TextView) convertView
                    .findViewById(R.id.child);
            tv.setText(info);
            return convertView;
        }

        //获取当前父item下的子item的个数
        @Override
        public int getChildrenCount(int groupPosition) {
            String key = parent.get(groupPosition);
            return map.get(key).size();
        }

        //获取当前父item的数据
        @Override
        public Object getGroup(int groupPosition) {
            return parent.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return parent.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        //设置父item组件
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_parent, parent, false);
            }
            TextView tv = (TextView) convertView
                    .findViewById(R.id.parent);
            tv.setText(MainActivity.this.parent.get(groupPosition));
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }
}
