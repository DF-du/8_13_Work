package com.csj.zjtk_7;

import com.csj.zjtk_7.net.ApiService;

public class HttpUtil {
    private static volatile HttpUtil sHttpUtil;
    public HttpUtil(){
        initRetrofit();
    }
    volatile ApiService apiService;
    private void initRetrofit() {

    }
}
