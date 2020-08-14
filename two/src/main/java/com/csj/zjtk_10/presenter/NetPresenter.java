package com.csj.zjtk_10.presenter;

import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;
import com.csj.zjtk_10.model.NetModel;
import com.csj.zjtk_10.net.NetCallBack;
import com.csj.zjtk_10.view.NetView;

import java.util.List;

public class NetPresenter implements NetCallBack {
    private final NetModel netModel;
    private NetView netView;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        netModel = new NetModel();
    }
    public void getData(){
        netModel.getData(this);
    }
    public void getQt(){
        netModel.getQt(this);
    }

    @Override
    public void onSuccess(List<JavaBean.DataBean> dataBeans) {
        netView.setData(dataBeans);
    }

    @Override
    public void onQt(List<QtBean.DataBean> dataBeans) {
        netView.setQt(dataBeans);
    }

    @Override
    public void onFail(String str) {
        netView.showToast(str);
    }
}
