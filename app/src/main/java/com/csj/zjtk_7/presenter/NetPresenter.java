package com.csj.zjtk_7.presenter;

import com.csj.zjtk_7.bean.JavaBean;
import com.csj.zjtk_7.model.NetModel;
import com.csj.zjtk_7.net.NetCallBack;
import com.csj.zjtk_7.view.NetView;

import java.util.List;

public class NetPresenter implements NetCallBack {
    private final NetModel netModel;
    private NetView netView;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        netModel = new NetModel();
    }

    public void getData() {
        netModel.getData(this);
    }

    @Override
    public void onSuccess(List<JavaBean.ResultsBean> resultsBeans) {
        netView.onSuccess(resultsBeans);
    }

    @Override
    public void onFail(String str) {
        netView.onFail(str);
    }
}
