package com.example.xiaozhu.danyuan03_1.net;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public interface ResultCallBask<T> {
    void succeed(T bean);
    void loser(String str);
}
