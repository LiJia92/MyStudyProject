package com.example.viewpageindicator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by miauser5 on 2015-12-15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] data;
    private Context mContext;

    public MyAdapter(Context context, String[] data) {
        mContext = context;
        this.data = data;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_age_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(data[position]);
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.length;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.my_text1);
            mTextView.setTag(this);
        }

        public TextView getTextView() {
            return mTextView;
        }
    }
}