package com.csj.zjtk_10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.zjtk_10.R;
import com.csj.zjtk_10.bean.JavaBean;
import com.csj.zjtk_10.bean.QtBean;

import java.util.ArrayList;

public class QtAdapter extends RecyclerView.Adapter<QtAdapter.ViewHolder> {
    Context context;
    ArrayList<JavaBean.DataBean> list;

    public QtAdapter(Context context, ArrayList<JavaBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JavaBean.DataBean dataBean = list.get(position);
        holder.mName.setText(dataBean.getName());
        holder.mTimer.setText(dataBean.getId() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTimer;
        TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTimer = (TextView) itemView.findViewById(R.id.timer);
            mName = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
