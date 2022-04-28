package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.diyetisproje.databinding.ActivityDiy1MapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class diy1_map extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.diyetisproje.databinding.ActivityDiy1MapBinding binding = ActivityDiy1MapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        String data = intent.getStringExtra("Key"); //alınan veri String'e çevirilerek aynı tipli data değişkenine atanıyor.
        if(data.equals("key"))
        {
            LatLng bakirkoy = new LatLng(39.9834950977921, 32.58606848019489);
            googleMap.addMarker(new MarkerOptions().position(bakirkoy).title("Sincan Devlet Hastanesi"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bakirkoy, 14), 2000, null);
        }else if(data.equals("mey"))
        {
            LatLng bakirkoy = new LatLng(40.994169007029654, 28.865857650870442);
            googleMap.addMarker(new MarkerOptions().position(bakirkoy).title("Bakırköy Devlet Hastanesi"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bakirkoy, 14), 2000, null);
        }else if(data.equals("ney"))
        {
            LatLng bakirkoy = new LatLng(41.11746008226892, 29.09804197536769);
            googleMap.addMarker(new MarkerOptions().position(bakirkoy).title("Beykoz Devlet Hastanesi"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bakirkoy, 14), 2000, null);
        }else if(data.equals("jey"))
        {
            LatLng bakirkoy = new LatLng(40.98482223652537, 28.73138200611845);
            googleMap.addMarker(new MarkerOptions().position(bakirkoy).title("Avcılar Devlet Hastanesi"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bakirkoy, 14), 2000, null);
        }else if(data.equals("yey"))
        {
            LatLng bakirkoy = new LatLng(40.91620578227199, 29.17511766315072);
            googleMap.addMarker(new MarkerOptions().position(bakirkoy).title("Kartal Devlet Hastanesi"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bakirkoy, 14), 2000, null);
        }


    }
}