package com.baochau.dmt.mapexample.model.list_map;

import java.util.List;
public class Poi {
    private List<Address>poi;

    public List<Address> getPoi() {
        return poi;
    }

    public void setPoi(List<Address> poi) {
        this.poi = poi;
    }

    public Poi(List<Address> poi) {
        this.poi = poi;
    }

    @Override
    public String toString() {
        return "Poi{" +
                "poi=" + poi +
                '}';
    }
}
