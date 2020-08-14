package com.csj.zjtk_10.model;

import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;
import com.csj.zjtk_10.net.ApiService;
import com.csj.zjtk_10.net.NetCallBack;
import com.csj.zjtk_10.presenter.NetPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModel {
    public void getData(final NetCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<JavaBean>() {
                    @Override
                    public void onNext(JavaBean javaBean) {
                        callBack.onSuccess(javaBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getQt(final NetCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sQt)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getQt()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<QtBean>() {
                    @Override
                    public void onNext(QtBean qtBean) {
                        callBack.onQt(qtBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
