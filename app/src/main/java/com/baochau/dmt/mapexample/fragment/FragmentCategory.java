package com.baochau.dmt.mapexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baochau.dmt.mapexample.GetResult;
import com.baochau.dmt.mapexample.adapter.CategoryAdapter;
import com.baochau.dmt.mapexample.model.category.ItemCategory;
import com.baochau.dmt.mapexample.R;
import com.baochau.dmt.mapexample.model.list_map.Address;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategory extends BaseFragment {
    Context context;
    FragmentMap fragmentMap;
    FrameLayout layout;
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    GetResult getResult;

    public FragmentCategory(Context context, FragmentMap fmMap,GetResult getResult) {
        this.context = context;
        this.fragmentMap = fmMap;
        this.getResult=getResult;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

        ArrayList<ItemCategory> category = new ArrayList<>();
        category.add(new ItemCategory(R.drawable.ic_restaurant, "Nhà hàng"));
        category.add(new ItemCategory(R.drawable.ic_cafe, "Café"));
        category.add(new ItemCategory(R.drawable.ic_entertainment, "Giải trí"));
        category.add(new ItemCategory(R.drawable.ic_bank, "ATM & Ngân hàng"));
        category.add(new ItemCategory(R.drawable.ic_petro, "Trạm xăng"));
        category.add(new ItemCategory(R.drawable.ic_hospital, "Dịch vụ y tế"));
        category.add(new ItemCategory(R.drawable.ic_hotel, "Khách sạn & Du lịch"));
        category.add(new ItemCategory(R.drawable.ic_beauty, "Làm đẹp & Spa"));
        category.add(new ItemCategory(R.drawable.ic_market, "Cửa hàng & Siêu thị"));
        category.add(new ItemCategory(R.drawable.ic_service, "Các công ty dịch vụ"));
        category.add(new ItemCategory(R.drawable.ic_scenic, "Thắng cảnh"));
        category.add(new ItemCategory(R.drawable.ic_education, getString(R.string.education)));
        category.add(new ItemCategory(R.drawable.ic_bar, getString(R.string.bar)));
        category.add(new ItemCategory(R.drawable.ic_sport, "Thể dục & Thể thao"));
        adapter = new CategoryAdapter(context, category, fragmentMap,getResult);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        recyclerView.setAdapter(adapter);
    }

    private void init(View view) {
        layout = getActivity().findViewById(R.id.layoutMenu);
        recyclerView = view.findViewById(R.id.category);
    }

}
