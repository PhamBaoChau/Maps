package com.baochau.dmt.mapexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baochau.dmt.mapexample.R;
import com.baochau.dmt.mapexample.adapter.ResultAdapter;
import com.baochau.dmt.mapexample.model.list_map.Address;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class FragmentResult extends BaseFragment {
    RecyclerView recyclerView;
    TextView textView;
    ResultAdapter adapter;
    Context context;

    public FragmentResult(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.title);
        recyclerView = view.findViewById(R.id.rvResult);
        arrAddress = new ArrayList<>();
        adapter = new ResultAdapter(this.arrAddress);
//        LinearLayoutManager layout = new LinearLayoutManager(context);
//        layout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void updateArrAddress(List<Address> addresses) {
        this.arrAddress.clear();
        this.arrAddress.addAll(addresses);
        adapter.notifyDataSetChanged();
    }

    public void goneResult(GoogleMap googleMap){
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                recyclerView.setVisibility(View.GONE);
            }
        });
    }

    public void setResult(String content){
        this.recyclerView.setVisibility(View.VISIBLE);
        this.textView.setText(content);
    }
}
