package com.example.xiaozhu.danyuan03_1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiaozhu.danyuan03_1.Bean;
import com.example.xiaozhu.danyuan03_1.R;


import java.util.ArrayList;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public class MainRvAdapter extends UtilAdapter {

    private Context context;
    private ArrayList<Bean.ResultsBean> lists;

    public MainRvAdapter(Context context, ArrayList<Bean.ResultsBean> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Bean.ResultsBean resultsBean = lists.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(resultsBean.getUrl()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickLintener!=null){
                    onItemClickLintener.onItemClickLintener(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
