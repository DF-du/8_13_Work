package com.csj.zjtk_10.net;

import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {
//    https://www.wanandroid.com/tree/json
//    https://www.wanandroid.com/project/tree/json qt

    String sUrl = "https://www.wanandroid.com/";

    @GET("tree/json")
    Flowable<JavaBean> getData();

    String sQt = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Flowable<QtBean> getQt();
}
