package com.shariq.service_lafusion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import com.shariq.service_lafusion.CategoryDetail;
import com.shariq.service_lafusion.R;
import com.shariq.service_lafusion.model.Category;
import com.shariq.service_lafusion.model.SpDetail;
import com.shariq.service_lafusion.model.SpList;

import java.util.ArrayList;
import java.util.List;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.MyHolder>  {
    private ArrayList<SpDetail> splist=new ArrayList<>();
    String name[];
    int experience[];

    private Filter exampleFilter;


    public SpAdapter(ArrayList<SpDetail> splist) {
        this.splist = splist;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        MyHolder myholder = new MyHolder(layout);

        return new MyHolder(layout);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

//        CategoryDetail cd=new CategoryDetail();
//        ArrayList<Category> data=cd.getList(position);
//
//        Category detail=data.get(0);
//        holder.textView.setText(detail.getName());
        SpDetail spDetail=splist.get(position);
        holder.textView.setText(spDetail.getName());
        holder.textView.setText(spDetail.getExperience());

    }

    @Override
    public int getItemCount() {
        return splist.size();
    }






    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivGridlayout);
            textView = itemView.findViewById(R.id.tvGridlayout);
        }
    }
}
