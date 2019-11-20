package com.example.xiaozhu.danyuan03_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaozhu.danyuan03_1.adapters.MainVpAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ArrayList<Bean.ResultsBean> lists;
    private MainVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        Intent intent = getIntent();
        lists = (ArrayList<Bean.ResultsBean>) intent.getSerializableExtra("rvLists");
        int position = intent.getIntExtra("position", 0);
        adapter = new MainVpAdapter(this,lists);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(position);
    }
}
