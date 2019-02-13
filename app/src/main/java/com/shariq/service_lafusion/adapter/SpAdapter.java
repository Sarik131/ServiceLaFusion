package com.shariq.service_lafusion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.GridAdapter;
import com.shariq.service_lafusion.R;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.MyHolder> {
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        MyHolder myholder = new MyHolder(layout);

        return new MyHolder(layout);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
  holder.textView.setText();
  holder.textView.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
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
