package com.baochau.dmt.mapexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baochau.dmt.mapexample.ApiService;
import com.baochau.dmt.mapexample.GetResult;
import com.baochau.dmt.mapexample.R;
import com.baochau.dmt.mapexample.fragment.FragmentMap;
import com.baochau.dmt.mapexample.fragment.FragmentResult;
import com.baochau.dmt.mapexample.model.category.ItemCategory;
import com.baochau.dmt.mapexample.model.list_map.Address;
import com.baochau.dmt.mapexample.model.list_map.PoiManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryItemViewHolder> {
    Context context;
    FragmentMap fragmentMap;
    Call<PoiManager> mCall;
    ArrayList<ItemCategory> category;
    GetResult getResult;

    public CategoryAdapter(Context context, ArrayList<ItemCategory> category, FragmentMap map,GetResult getResult) {
        this.context = context;
        this.category = category;
        this.fragmentMap = map;
        this.getResult=getResult;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        ItemCategory item = category.get(position);
        holder.icon.setBackground(context.getDrawable(item.getIcon()));
        holder.content.setText(item.getContent());
        int pos = position + 1;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (pos) {
                    case 1:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(1), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 2:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(2), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 3:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(3), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 4:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(4), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 5:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(5), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 6:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(6), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 7:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(7), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 8:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(8), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 9:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(9), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 10:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(10), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 11:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(11), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 12:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(12), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 13:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(13), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                    case 14:
                        mCall = ApiService.apiService.getMapByCategory(String.valueOf(14), "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
                        break;
                }
                fragmentMap.getMapByCategory(mCall);
                view.getRootView().findViewById(R.id.layoutMenu).setVisibility(View.GONE);

                getResult.getResult("Kết quả tìm kiếm cho "+item.getContent());
                view.getRootView().findViewById(R.id.layoutResult).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public static class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        public TextView icon;
        public TextView content;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_item);
            content = itemView.findViewById(R.id.content_item);
        }
    }
}
