package com.csj.zjtk_10.view;

import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;

import java.util.List;

public interface NetView {
    void setData(List<JavaBean.DataBean> dataBeans);

    void setQt(List<QtBean.DataBean> dataBeans);

    void showToast(String str);
}
