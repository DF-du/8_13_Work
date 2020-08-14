package com.csj.zjtk_10.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.csj.zjtk_10.R;
import com.csj.zjtk_10.adapter.MainAdapter;
import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;
import com.csj.zjtk_10.presenter.NetPresenter;
import com.csj.zjtk_10.view.NetView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements NetView {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_home, null);
        initView(inflate);
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getQt();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTabLayout = (TabLayout) itemView.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) itemView.findViewById(R.id.viewPager);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void setData(List<JavaBean.DataBean> dataBeans) {

    }

    @Override
    public void setQt(List<QtBean.DataBean> dataBeans) {
        ArrayList<Fragment> list = new ArrayList<>();
        //TabLayout的组装
        for (
                QtBean.DataBean dataBean : dataBeans) {
            //mTab.setupWithViewPager(mView);
            mTabLayout.addTab(mTabLayout.newTab().setText(dataBean.getName()));

            //tab的个数和fragment的个数保持一致
            list.add(new QtFragment());
        }

        //viewpager fragment 结合
        //子类fragment管理器
//        ProjectAdapter adapter = new ProjectAdapter(getChildFragmentManager(), list);
////        mView.setAdapter(adapter);
        MainAdapter adapter = new MainAdapter(getChildFragmentManager(), list);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < dataBeans.size(); i++) {
            QtBean.DataBean dataBean = dataBeans.get(i);
            mTabLayout.getTabAt(i).setText(dataBean.getName());
        }
    }

    @Override
    public void showToast(String str) {

    }

}
