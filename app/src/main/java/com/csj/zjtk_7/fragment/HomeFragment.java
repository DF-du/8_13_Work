package com.csj.zjtk_7.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.zjtk_7.R;
import com.csj.zjtk_7.adapter.HomeAdapter;
import com.csj.zjtk_7.bean.JavaBean;
import com.csj.zjtk_7.presenter.NetPresenter;
import com.csj.zjtk_7.view.NetView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements NetView {
    private RecyclerView mRecycler;
    private ArrayList<JavaBean.ResultsBean> list;
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_home, null);
        initView(inflate);
        new NetPresenter(this).getData();
        setHasOptionsMenu(true);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(getActivity(), list);
        mRecycler.setAdapter(homeAdapter);
    }

    @Override
    public void onSuccess(List<JavaBean.ResultsBean> resultsBeans) {
        list.addAll(resultsBeans);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.options, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                pop();
                break;
            case R.id.item2:
                pop();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void pop() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null, false);
        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
    }
}
