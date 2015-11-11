package com.lastwarmth.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends BaseAdapter {

    private List<MyModel> data;
    private Context mContext;

    public MyAdapter(List<MyModel> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (data != null) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = (CircleImageView) view.findViewById(R.id.profile_image);
            holder.groupName = (TextView) view.findViewById(R.id.group_name);
            holder.content = (TextView) view.findViewById(R.id.qq_content);
            holder.delete = (TextView) view.findViewById(R.id.delete);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        MyModel myModel = (MyModel) getItem(position);
        holder.groupName.setText(myModel.getGroupName());
        holder.content.setText(myModel.getContent());
        Glide.with(mContext)
                .load(myModel.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.lb_zjtx)
                .crossFade()
                .into(holder.imageView);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    private static class ViewHolder {
        CircleImageView imageView;
        TextView groupName;
        TextView content;
        TextView delete;
    }
}
