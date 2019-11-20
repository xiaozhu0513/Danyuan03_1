package com.example.xiaozhu.danyuan03_1.presenter;


import com.example.xiaozhu.danyuan03_1.Bean;
import com.example.xiaozhu.danyuan03_1.model.MainModel;
import com.example.xiaozhu.danyuan03_1.net.ResultCallBask;
import com.example.xiaozhu.danyuan03_1.view.MainView;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public class MainPresenter {
    private final MainModel mainModel;
    private MainView view;

    public MainPresenter(MainView view) {
        mainModel = new MainModel();
        this.view = view;
    }

    public void getData() {
        mainModel.getData(new ResultCallBask<Bean>() {
            @Override
            public void succeed(Bean bean) {
                if(bean!=null && view!=null){
                    view.setData(bean);
                }
            }

            @Override
            public void loser(String str) {
                view.showToast(str);
            }
        });
    }
}
