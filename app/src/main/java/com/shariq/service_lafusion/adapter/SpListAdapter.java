package com.shariq.service_lafusion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.R;
import com.shariq.service_lafusion.model.SpList;

import java.util.ArrayList;
import java.util.List;

public class SpListAdapter extends RecyclerView.Adapter<SpListAdapter.MyHolder> {
    List<SpList> mData;
    private LayoutInflater mInflater;

    //private ItemClickListener mClickListener;
    public SpListAdapter(Context context,  ArrayList<SpList> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public SpListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_sp_list, parent, false);
        return new SpListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SpListViewHolder holder, int position) {
        SpList spList = mData.get(holder.getAdapterPosition());
        holder.spName.setText(spList.getName());



        }
        //holder.
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SpListViewHolder {
    }

public class SpListViewHolder extends RecyclerView.ViewHolder {

        TextView spName;
        TextView experience;

        public SpListViewHolder(View itemView) {
            super(itemView);

            spName=(TextView)itemView.findViewById(R.id.tvSpName);
            experience=(TextView)itemView.findViewById(R.id.tvSpExp);

        }
    }
}