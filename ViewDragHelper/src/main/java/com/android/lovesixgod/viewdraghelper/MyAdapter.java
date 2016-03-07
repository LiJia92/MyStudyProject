package com.android.lovesixgod.viewdraghelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

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
    public View getView(final int position, View contentView, ViewGroup parent) {
        ViewHolder holder;
        if (contentView == null) {
            holder = new ViewHolder();
            contentView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            holder.imageView = (ImageView) contentView.findViewById(R.id.profile_image);
            holder.groupName = (TextView) contentView.findViewById(R.id.group_name);
            holder.content = (TextView) contentView.findViewById(R.id.qq_content);
            holder.toTop = (TextView) contentView.findViewById(R.id.to_top);
            holder.hadRead = (TextView) contentView.findViewById(R.id.had_read);
            holder.delete = (TextView) contentView.findViewById(R.id.delete);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }
        MyModel myModel = (MyModel) getItem(position);
        holder.groupName.setText(myModel.getGroupName());
        holder.content.setText(myModel.getContent());
        Picasso.with(mContext)
                .load(myModel.getImageUrl())
                .placeholder(R.drawable.lb_zjtx)
                .transform(new CircleTransform())
                .into(holder.imageView);
        return contentView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView groupName;
        TextView content;
        TextView toTop;
        TextView hadRead;
        TextView delete;
    }
}
