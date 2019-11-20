package com.example.xiaozhu.danyuan03_1.net;


import com.example.xiaozhu.danyuan03_1.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public interface ApiSercive {
    String mainUrl = "http://gank.io/api/";
    @GET("data/福利/20/1")
    Observable<Bean> getData();
}
