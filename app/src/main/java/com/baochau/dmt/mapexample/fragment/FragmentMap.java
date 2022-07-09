package com.baochau.dmt.mapexample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.baochau.dmt.mapexample.GetResult;
import com.baochau.dmt.mapexample.R;
import com.baochau.dmt.mapexample.UpdatingListAddress;
import com.baochau.dmt.mapexample.model.list_map.Address;
import com.baochau.dmt.mapexample.model.list_map.PoiManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMap extends BaseFragment {
    SupportMapFragment map;
    UpdatingListAddress updatingAddress;
    GetResult getResult;

    public FragmentMap(UpdatingListAddress updatingAddress, GetResult getResult) {
        this.updatingAddress = updatingAddress;
        this.getResult=getResult;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
    }

    public void getMapByCategory(Call<PoiManager> mCall) {
        mCall.enqueue(new Callback<PoiManager>() {
            @Override
            public void onResponse(Call<PoiManager> call, @NonNull Response<PoiManager> response) {
                arrAddress = response.body().getResult().getPoi();
                map.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        googleMap.clear();
                        addMarker(googleMap);
                        updatingAddress.updateListAddress(arrAddress,googleMap);
                    }
                });
            }

            @Override
            public void onFailure(Call<PoiManager> call, Throwable t) {
                arrAddress.clear();
                getResult.getResult("Không tìm thấy kết quả tìm kiếm");
            }
        });
    }

    private void addMarker(GoogleMap googleMap){
        for (Address address : arrAddress) {
            if (address.getTitle() != null) {
                LatLng latLng = new LatLng(address.getGps().getLatitude(), address.getGps().getLongitude());
                Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng));
                marker.setTag(address);
                googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                    @Nullable
                    @Override
                    public View getInfoContents(@NonNull Marker marker) {
                        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_info_content, null);
                        TextView title = view.findViewById(R.id.title);
                        TextView detail=view.findViewById(R.id.address);
                        ImageView icon = view.findViewById(R.id.icon);
                        Address address1= (Address) marker.getTag();
                        title.setText(address1.getTitle());
                        detail.setText(address1.getAddress());
//                                        Target target=new PicassoMarker(icon);
//                                        Picasso.get().load("https:"+address.getImg()).into(target);
                        Picasso.get().load("https:"+address1.getImg()).into(icon);
                        return view;
                    }
                    @Nullable
                    @Override
                    public View getInfoWindow(@NonNull Marker marker) {
                        return null;
                    }
                });
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
            }
        }
    }
}
