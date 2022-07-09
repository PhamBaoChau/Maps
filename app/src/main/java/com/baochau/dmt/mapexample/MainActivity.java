package com.baochau.dmt.mapexample;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.baochau.dmt.mapexample.fragment.FragmentCategory;
import com.baochau.dmt.mapexample.fragment.FragmentMap;
import com.baochau.dmt.mapexample.fragment.FragmentResult;
import com.baochau.dmt.mapexample.model.list_map.Address;
import com.baochau.dmt.mapexample.model.list_map.PoiManager;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements UpdatingListAddress, GetResult, TextView.OnEditorActionListener, View.OnClickListener {
    FragmentTransaction fragmentManager;
    List<Address> arrAddress;
    FragmentCategory fmCategory;
    FragmentMap fmMap;
    FragmentResult fmResult;
    ImageButton spnCategory, btnSearch;
    FrameLayout category, result;
    EditText edtSearch;


    void init() {
        spnCategory = findViewById(R.id.spnCategory);
        category = findViewById(R.id.layoutMenu);
        result = findViewById(R.id.layoutResult);
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);
    }

    void initAction() {
        btnSearch.setOnClickListener(this);

        spnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category.setVisibility(View.VISIBLE);
                fmResult.getView().findViewById(R.id.rvResult).setVisibility(View.GONE);

            }
        });

        edtSearch.setOnEditorActionListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initAction();


        fmMap = new FragmentMap(this,this);
        fragmentManager = getSupportFragmentManager().beginTransaction().replace(R.id.layoutMap, fmMap);
        fragmentManager.commit();

        fmCategory = new FragmentCategory(this, fmMap, this);
        fragmentManager = getSupportFragmentManager().beginTransaction().replace(R.id.layoutMenu, fmCategory);
        fragmentManager.commit();

        fmResult = new FragmentResult(this);
        fragmentManager = getSupportFragmentManager().beginTransaction().replace(R.id.layoutResult, fmResult);
        fragmentManager.commit();
    }

    @Override
    public void updateListAddress(List<Address> arr, GoogleMap googleMap) {
        this.fmResult.updateArrAddress(arr);
        this.fmResult.goneResult(googleMap);
    }

    @Override
    public void getResult(String content) {
        this.fmResult.setResult(content);
    }

    void getApiSearch(EditText edtSearch) {
        String text = edtSearch.getText().toString().trim();
        Call<PoiManager> managerCall = ApiService.apiService.getMapBySearch(text, "20.980062702696852%2C105.61227794560544%2C21.033907439503594%2C106.0771369543945");
        fmMap.getMapByCategory(managerCall);
        getResult("Kết quả tìm kiếm cho " + text);
        result.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        if (!edtSearch.getText().toString().isEmpty()) {
            getApiSearch(edtSearch);
            View focus = this.getCurrentFocus();
            if (focus != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(focus.getWindowToken(), 0);
            }
        }
        edtSearch.clearFocus();
        category.setVisibility(View.GONE);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        edtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == true) {
                    result.setVisibility(View.GONE);
                }
            }
        });

        if (i == EditorInfo.IME_ACTION_DONE) {
            if (!edtSearch.getText().toString().isEmpty()) {
                getApiSearch(edtSearch);
            }
            edtSearch.clearFocus();
        }
        return false;
    }
}