package com.shariq.service_lafusion;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.model.Category;

import java.util.ArrayList;
import java.util.List;

/*public class GridAdapter extends RecyclerView.Adapter<GridAdapter.Myholder> implements Filterable {
    private ArrayList<Category> splist=new ArrayList<>();
    ArrayList<Category> splistfull=new ArrayList<>();
    Context context;
    String[] values;
    int[] images;

    public GridAdapter(Context context, String[] values, int[] images,ArrayList<Category> splist) {
        this.context = context;
        this.values = values;
        this.images = images;
        this.splist = splist;
    }



    class Myholder extends RecyclerView.ViewHolder {

        public Myholder(View itemView) {
            super(itemView);


        }
    }


    private int[] photos = {
            R.drawable.carpenter_pic,
            R.drawable.painter_pic,
            R.drawable.cleaning_pic,
            R.drawable.appliances_pic,
            R.drawable.electricain_pic,
            R.drawable.pakers_pic,
            R.drawable.photographer_pic,
            R.drawable.eventmanagement_pic,
            R.drawable.fitnesstrainer_pic,
            R.drawable.pestcontroller_pic,
            R.drawable.parlour_pic,
            R.drawable.gardener_pic,
            R.drawable.astrologer_pic,
            R.drawable.plumber_pic
    };


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        Myholder myholder = new Myholder(layout);

        return new Myholder(layout);
    }

 /*  @Override
    public void onBindViewHolder(Myholder holder, final int position) {

        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(values[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryDetail.class);

                String name = values[position];
                intent.putExtra("Carpenter", name);


                int image = photos[position];
                intent.putExtra("pics", image);




            }
        });
    } */

    @Override
    public int getItemCount() {
        return values.length;
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
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
*/
}
