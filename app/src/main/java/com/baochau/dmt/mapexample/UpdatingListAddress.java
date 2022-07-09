package com.baochau.dmt.mapexample;

import com.baochau.dmt.mapexample.model.list_map.Address;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;
public interface UpdatingListAddress {
    void updateListAddress(List<Address> arr, GoogleMap googleMap);
}

