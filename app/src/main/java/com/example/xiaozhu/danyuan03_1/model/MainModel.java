package com.example.xiaozhu.danyuan03_1.model;



import com.example.xiaozhu.danyuan03_1.Bean;
import com.example.xiaozhu.danyuan03_1.net.ApiSercive;
import com.example.xiaozhu.danyuan03_1.net.ResultCallBask;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public class MainModel {

    public void getData(final ResultCallBask<Bean> callBask) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiSercive.mainUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiSercive.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        callBask.succeed(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBask.loser(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
