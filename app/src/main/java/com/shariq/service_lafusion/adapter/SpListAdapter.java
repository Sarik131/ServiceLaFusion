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

public class SpListAdapter extends RecyclerView.Adapter<SpListAdapter.SpListViewHolder> {
    List<SpList> mData;
    private LayoutInflater mInflater;

    //private ItemClickListener mClickListener;
    public SpListAdapter(Context context,  ArrayList<SpList> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public SpListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_sp_list_item, parent, false);
        return new SpListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SpListViewHolder holder, int position) {
        SpList spList = mData.get(holder.getAdapterPosition());
        holder.spName.setText(spList.getName());
        holder.spPhoto.setImageResource(spList.getImageId());
        switch (spList.getImageId()) {
            case 1:
                holder.ivStar1.setImageResource(R.drawable.star_on);
                holder.ivStar2.setImageResource(R.drawable.star_off);
                holder.ivStar3.setImageResource(R.drawable.star_off);
                holder.ivStar4.setImageResource(R.drawable.star_off);
                holder.ivStar5.setImageResource(R.drawable.star_off);
            case 2:
                holder.ivStar1.setImageResource(R.drawable.star_on);
                holder.ivStar2.setImageResource(R.drawable.star_on);
                holder.ivStar3.setImageResource(R.drawable.star_off);
                holder.ivStar4.setImageResource(R.drawable.star_off);
                holder.ivStar5.setImageResource(R.drawable.star_off);

            case 3:
                holder.ivStar1.setImageResource(R.drawable.star_on);
                holder.ivStar2.setImageResource(R.drawable.star_on);
                holder.ivStar3.setImageResource(R.drawable.star_on);
                holder.ivStar4.setImageResource(R.drawable.star_off);
                holder.ivStar5.setImageResource(R.drawable.star_off);

            case 4:
                holder.ivStar1.setImageResource(R.drawable.star_on);
                holder.ivStar2.setImageResource(R.drawable.star_on);
                holder.ivStar3.setImageResource(R.drawable.star_on);
                holder.ivStar4.setImageResource(R.drawable.star_on);
                holder.ivStar5.setImageResource(R.drawable.star_off);

            case 5:
                holder.ivStar1.setImageResource(R.drawable.star_on);
                holder.ivStar2.setImageResource(R.drawable.star_on);
                holder.ivStar3.setImageResource(R.drawable.star_on);
                holder.ivStar4.setImageResource(R.drawable.star_on);
                holder.ivStar5.setImageResource(R.drawable.star_on);
        }
        //holder.
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SpListViewHolder extends RecyclerView.ViewHolder {
        ImageView spPhoto;
        TextView spName;
        ImageView ivStar1;
        ImageView ivStar2;
        ImageView ivStar3;
        ImageView ivStar4;
        ImageView ivStar5;
        public SpListViewHolder(View itemView) {
            super(itemView);
            spPhoto = (ImageView) itemView.findViewById(R.id.ivSpList);
            spName = (TextView) itemView.findViewById(R.id.tvSpList);

            ivStar1 = (ImageView) itemView.findViewById(R.id.ivStar1);
            ivStar2 = (ImageView) itemView.findViewById(R.id.ivStar2);
            ivStar3 = (ImageView) itemView.findViewById(R.id.ivStar3);
            ivStar4 = (ImageView) itemView.findViewById(R.id.ivStar4);
            ivStar5 = (ImageView) itemView.findViewById(R.id.ivStar5);
        }
    }
}