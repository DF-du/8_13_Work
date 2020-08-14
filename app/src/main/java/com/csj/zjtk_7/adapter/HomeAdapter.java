package com.csj.zjtk_7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.csj.zjtk_7.R;
import com.csj.zjtk_7.bean.JavaBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<JavaBean.ResultsBean> list;

    public HomeAdapter(Context context, ArrayList<JavaBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
            return new ViewHolder1(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
            return new ViewHolder2(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_tre, parent, false);
            return new ViewHolder3(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        JavaBean.ResultsBean resultsBean = list.get(position);
        if (itemViewType == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(resultsBean.getUrl_1()).into(viewHolder1.mOneImg);
            viewHolder1.mOneTitle.setText(resultsBean.getTitle());
        } else if (itemViewType == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            Glide.with(context).load(resultsBean.getUrl_1()).into(viewHolder2.mTwo1Img);
            Glide.with(context).load(resultsBean.getUrl_2()).into(viewHolder2.mTwo2Img);
            Glide.with(context).load(resultsBean.getUrl_3()).into(viewHolder2.mTwo3Img);
            viewHolder2.mTwoTitle.setText(resultsBean.getTitle());
        } else {
            ViewHolder3 viewHolder3 = (ViewHolder3) holder;
            Glide.with(context).load(resultsBean.getUrl_1()).into(viewHolder3.mTre1Img);
            Glide.with(context).load(resultsBean.getUrl_1()).into(viewHolder3.mTre2Img);
            viewHolder3.mTreTitle.setText(resultsBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView mOneImg;
        TextView mOneTitle;

        public ViewHolder1(View itemView) {
            super(itemView);
            mOneImg = (ImageView) itemView.findViewById(R.id.img_one);
            mOneTitle = (TextView) itemView.findViewById(R.id.title_one);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTwoTitle;
        ImageView mTwo1Img;
        ImageView mTwo2Img;
        ImageView mTwo3Img;

        public ViewHolder2(View itemView) {
            super(itemView);
            mTwoTitle = (TextView) itemView.findViewById(R.id.title_two);
            mTwo1Img = (ImageView) itemView.findViewById(R.id.img_two1);
            mTwo2Img = (ImageView) itemView.findViewById(R.id.img_two2);
            mTwo3Img = (ImageView) itemView.findViewById(R.id.img_two3);
        }
    }

    private class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView mTreTitle;
        ImageView mTre1Img;
        ImageView mTre2Img;

        public ViewHolder3(View itemView) {
            super(itemView);
            mTreTitle = (TextView) itemView.findViewById(R.id.title_tre);
            mTre1Img = (ImageView) itemView.findViewById(R.id.img_tre1);
            mTre2Img = (ImageView) itemView.findViewById(R.id.img_tre2);
        }
    }
}
