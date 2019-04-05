package com.shariq.service_lafusion.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shariq.service_lafusion.QueryStatusActivity;
import com.shariq.service_lafusion.R;
import com.shariq.service_lafusion.model.DummySpData;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderAdapter extends RecyclerView.Adapter<ServiceProviderAdapter.MyViewHolder> {
    private ArrayList<DummySpData> dataList=new ArrayList<>();
    private Context context;

    public ServiceProviderAdapter(ArrayList<DummySpData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("Msg","In OnCreate of Adapter");
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sprequest_list, parent, false);
        return new   MyViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DummySpData dummySpData = dataList.get(holder.getAdapterPosition());
        Log.d("Data","Dummydata :"+ dummySpData);
        if(dummySpData !=null)
        {
            holder.txtAlert.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.VISIBLE);

        }else
        {
            Log.d("in onbind","dummy is null");
        }
        holder.txtTitle.setText(dummySpData.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, QueryStatusActivity.class);
                context.startActivity(intent);
            }
        });
        }

    @Override
    public int getItemCount() {
      return   dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle,txtAlert;
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtTitle=(TextView)itemView.findViewById(R.id.txtTitlele);
//            txtAlert =(TextView)itemView.findViewById(R.id.txtAlert);
//            linearLayout =(LinearLayout)itemView.findViewById(R.id.spLinearLayout);
       }
    }
}
