package com.baochau.dmt.mapexample;

import com.baochau.dmt.mapexample.model.list_map.PoiManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://map.coccoc.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("map/search.json")
    Call<PoiManager> getMapByCategory(@Query("category") String category, @Query("borders") String borders);

    @GET("map/search.json")
    Call<PoiManager> getMapBySearch(@Query("query")String search,@Query("borders") String borders);

}
