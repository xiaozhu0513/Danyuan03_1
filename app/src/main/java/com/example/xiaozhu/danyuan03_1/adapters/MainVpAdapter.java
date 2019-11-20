package com.example.xiaozhu.danyuan03_1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiaozhu.danyuan03_1.Bean;
import com.example.xiaozhu.danyuan03_1.Main2Activity;
import com.example.xiaozhu.danyuan03_1.MainActivity;
import com.example.xiaozhu.danyuan03_1.R;

import java.util.ArrayList;

/**
 * Created by xiaozhu on 2019/11/20.
 */

public class MainVpAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Bean.ResultsBean> lists;

    public MainVpAdapter(Context context, ArrayList<Bean.ResultsBean> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.vp_img_layout, null);
        ImageView img = view.findViewById(R.id.img);
        Glide.with(context).load(lists.get(position).getUrl()).into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
