package com.example.xiaozhu.danyuan03_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xiaozhu.danyuan03_1.adapters.MainRvAdapter;
import com.example.xiaozhu.danyuan03_1.adapters.MainVpAdapter;
import com.example.xiaozhu.danyuan03_1.adapters.UtilAdapter;
import com.example.xiaozhu.danyuan03_1.presenter.MainPresenter;
import com.example.xiaozhu.danyuan03_1.view.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private ArrayList<Bean.ResultsBean> vpLists;
    private ArrayList<Bean.ResultsBean> rvLists;
    private MainRvAdapter rvAdapter;
    private MainVpAdapter vpAdapter;
    private MainPresenter mainPresenter;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        initView();
        initViewPage();
        initRecyclerView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initViewPage() {
        vpLists = new ArrayList<>();
        initData();
        vpAdapter = new MainVpAdapter(this, vpLists);
        mViewPager.setAdapter(vpAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mRecyclerView.smoothScrollToPosition(position);
                i = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initRecyclerView() {
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.HORIZONTAL));
        rvLists = new ArrayList<>();
        initData();
        rvAdapter = new MainRvAdapter(this, rvLists);
        mRecyclerView.setAdapter(rvAdapter);

        rvAdapter.OnItemClickLintener(new UtilAdapter.OnItemClickLintener() {
            @Override
            public void onItemClickLintener(View v, int a) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("rvLists",rvLists);
                intent.putExtra("position",a);
                startActivity(intent);
            }
        });


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int position = manager.findFirstVisibleItemPosition();
                mViewPager.setCurrentItem(position);
            }
        });

    }

    private void initData() {
        mainPresenter.getData();
    }

    @Override
    public void setData(final Bean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                vpLists.addAll(bean.getResults());
                rvLists.addAll(bean.getResults());
                vpAdapter.notifyDataSetChanged();
                rvAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showToast(String str) {

    }
}
