package com.lastwarmth.listviewstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2015/11/9.
 */
public class ImageAdapter3 extends ArrayAdapter<String> {

    private String[] mUrls;
    private Context mContext;

    public ImageAdapter3(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        mUrls = objects;
        mContext = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        } else {
            view = convertView;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        String url = mUrls[position];
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.lb_zjtx)
                .crossFade()
                .into(imageView);
        return view;
    }
}
