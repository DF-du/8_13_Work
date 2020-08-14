package com.csj.zjtk_7.net;

import com.csj.zjtk_7.bean.JavaBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {
//    https://gitee.com/ccyy2019/server/raw/master/workbook
    String sUrl = "https://gitee.com/";
    @GET("ccyy2019/server/raw/master/workbook")
    Flowable<JavaBean> getData();
}
