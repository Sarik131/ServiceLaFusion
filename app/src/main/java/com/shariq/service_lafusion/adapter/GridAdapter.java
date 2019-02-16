package com.shariq.service_lafusion.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.CategoryDetail;
import com.shariq.service_lafusion.Cust_Registration;
import com.shariq.service_lafusion.Homepage;
import com.shariq.service_lafusion.R;
import com.shariq.service_lafusion.SpregisterrActivity;
import com.shariq.service_lafusion.model.Category;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.Myholder>implements Filterable {
    ArrayList<Category> splist;
    ArrayList<Category>splistfull;
    Context context;

    public GridAdapter(ArrayList<Category> splist) {
        this.splist = splist;
        splistfull=splist;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
       return  new Myholder(layout);
    }

    @Override
    public void onBindViewHolder(Myholder holder, final int position) {
       final Category category=splist.get(position);

       holder.textView.setText(category.getName());
       holder.imageView.setImageResource(category.getId());
       holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent();
               intent.putExtra("name",category.getName());

               Homepage homepage=new Homepage();
               homepage.method(v);
           }
       });

    }

    @Override
    public int getItemCount() {
        return splist.size();
    }


    public Filter getFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Category> list = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                list.addAll(splistfull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Category item : splistfull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        list.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            splist.clear();
            splist.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return getFilter;
    }


    public class Myholder extends RecyclerView.ViewHolder {
ImageView imageView;
TextView textView;

        public Myholder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.ivGridlayout);
            textView=(TextView) itemView.findViewById(R.id.tvGridlayout);
        }
    }
}
