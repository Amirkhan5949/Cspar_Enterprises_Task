package com.amir.csparenterprises.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amir.csparenterprises.R;
import com.amir.csparenterprises.model.LocationItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MapActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        List<LocationItem> list = new Gson().fromJson(getIntent().getStringExtra("location"), new TypeToken<List<LocationItem>>(){}.getType());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(googleMap -> {


            for (LocationItem locationItem : list) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(Double.parseDouble(locationItem.getLat()), Double.parseDouble(locationItem.getLongg())))
                        .title("Location : (lat "+locationItem.getLat()+", long "+ locationItem.getLongg()+")"));
            }

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937,78.9629), 1));


        });




    }
}