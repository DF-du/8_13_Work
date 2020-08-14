package com.csj.zjtk_10.net;

import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;

import java.util.List;

public interface NetCallBack {
    void onSuccess(List<JavaBean.DataBean> dataBeans);

    void onQt(List<QtBean.DataBean> dataBeans);

    void onFail(String str);
}
