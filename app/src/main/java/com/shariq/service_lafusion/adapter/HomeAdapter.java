package com.shariq.service_lafusion.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.HomeActivity;
import com.shariq.service_lafusion.QueryScreenActivity;
import com.shariq.service_lafusion.R;
import com.shariq.service_lafusion.model.Category;

import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    //private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    List<Category> mData;
   // private Intent intent= new Intent(this, QueryScreenActivity.class);;

    // data is passed into the constructor
    public HomeAdapter(Context context, ArrayList<Category> data, ItemClickListener itemClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mClickListener = itemClickListener;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_home_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = mData.get(holder.getAdapterPosition());
        holder.myTextView.setText(category.getName());
        holder.mImageView.setImageResource(category.getImageId());

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView mImageView;


        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvType);
            mImageView = itemView.findViewById(R.id.ivType);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            mClickListener.onItemClick(getAdapterPosition());

            //startActivity(intent);
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
