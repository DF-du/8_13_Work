package com.csj.zjtk_7.net;

import com.csj.zjtk_7.bean.JavaBean;

import java.util.List;

public interface NetCallBack {
    void onSuccess(List<JavaBean.ResultsBean> resultsBeans);

    void onFail(String str);
}
