package com.baochau.dmt.mapexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baochau.dmt.mapexample.R;
import com.baochau.dmt.mapexample.model.list_map.Address;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultItemViewHolder> {
    List<Address> arrAddress;

    public ResultAdapter(List<Address> arrAddress) {
        this.arrAddress = arrAddress;
    }

    @NonNull
    @Override
    public ResultItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, null);
        return new ResultItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultItemViewHolder holder, int position) {
        Address item = arrAddress.get(position);
        if (item.getTitle() != null) {
            Picasso.get().load("https:"+item.getImg()).into(holder.logo);
            holder.name.setText(android.text.Html.fromHtml(item.getTitle()));
            holder.category.setText(item.getCategory());
            holder.address.setText(item.getAddress());
            holder.rating.setText(String.valueOf(item.getRating()));
        }
    }

    @Override
    public int getItemCount() {
        int size=0;
        for (Address address:arrAddress) {
            if (address.getTitle()!=null){
                size++;
            }
        }
        return size;
    }

    public class ResultItemViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView name, category, address, rating;

        public ResultItemViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            address = itemView.findViewById(R.id.address);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
