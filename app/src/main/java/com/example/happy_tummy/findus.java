package com.example.happy_tummy;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.happy_tummy.databinding.ActivityFindusBinding;

import static com.example.happy_tummy.R.id.map;

public class findus extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityFindusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFindusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
        mMap = googleMap;
        float zoomLevel = 10f;

        // Add a marker in Sydney and move the camera

        LatLng vashi = new LatLng(19.0745,72.9978 );
        mMap.addMarker(new MarkerOptions().position(vashi).title("Navi Mumbai| Maharashtra").icon(BitmapDescriptorFactory.fromBitmap(resizeBitmap(R.drawable.foodmarker,72,64))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vashi,zoomLevel));

        LatLng koperkhairne = new LatLng(19.1045, 73.0033);
        mMap.addMarker(new MarkerOptions().position(koperkhairne).title("Navi Mumbai| Maharashtra").icon(BitmapDescriptorFactory.fromBitmap(resizeBitmap(R.drawable.foodmarker,72,64))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koperkhairne,zoomLevel));

        LatLng nerul = new LatLng(19.0338,73.0196 );
        mMap.addMarker(new MarkerOptions().position(nerul).title("Navi Mumbai| Maharashtra").icon(BitmapDescriptorFactory.fromBitmap(resizeBitmap(R.drawable.foodmarker,72,64))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nerul,zoomLevel));


    }
    public Bitmap resizeBitmap(int drawableName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(String.valueOf(drawableName), "drawable", getPackageName()));
        return Bitmap.createScaledBitmap(imageBitmap, width, height, false);
    }
}