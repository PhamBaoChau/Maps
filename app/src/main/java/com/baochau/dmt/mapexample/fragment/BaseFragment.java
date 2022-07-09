package com.baochau.dmt.mapexample.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.baochau.dmt.mapexample.model.list_map.Address;

import java.util.List;

public class BaseFragment extends Fragment {
    public List<Address> arrAddress;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("################ FRAGMENT ##########################");
        System.out.println("Fragment name: " + " " + this.getClass().getName() + "");
        System.out.println("######################################################");
    }
}
