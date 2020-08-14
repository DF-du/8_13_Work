package com.csj.zjtk_10.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.zjtk_10.R;
import com.csj.zjtk_10.adapter.QtAdapter;
import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;
import com.csj.zjtk_10.presenter.NetPresenter;
import com.csj.zjtk_10.view.NetView;

import java.util.ArrayList;
import java.util.List;

public class QtFragment extends Fragment implements NetView {
    private RecyclerView mRecycler;
    private ArrayList<JavaBean.DataBean> list;
    private QtAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_qt, null);
        initView(inflate);
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),1));
        list = new ArrayList<>();
        adapter = new QtAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void setData(List<JavaBean.DataBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setQt(List<QtBean.DataBean> dataBeans) {

    }

    @Override
    public void showToast(String str) {

    }
}
