package com.csj.zjtk_7.view;

import com.csj.zjtk_7.bean.JavaBean;

import java.util.List;

public interface NetView {
    void onSuccess(List<JavaBean.ResultsBean> resultsBeans);

    void onFail(String str);
}
