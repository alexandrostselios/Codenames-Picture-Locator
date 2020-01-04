package com.example.alexa.voicerecognitionandrecording;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap map;

    private  int pressed=0;

    private double defaultLatitude = 37.98381;
    private double defaultLongitude = 23.727539;
    private double latitude;
    private double longitude;

    private String event;

    CircleOptions mCircleOptions;
    Circle mCircle;

    LatLng before = null;

    private MarkerOptions options = new MarkerOptions();
    private Map<LatLng,String> markers = new HashMap<LatLng,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        latitude = Double.parseDouble(bundle.getString("latitude").toString());
        longitude = Double.parseDouble(bundle.getString("longitude").toString());
        event = bundle.getString("event").toString();
        System.out.println("Event: "+event);
        setData(latitude,longitude,event);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(defaultLatitude, defaultLongitude)) );
        map.animateCamera( CameraUpdateFactory.zoomTo( 6.0f ) );
        createMarker();
    }

    private void setData(double latitude, double longitude,String event){
        markers.put(new LatLng(39.61795, 20.838551),"atuxima");
        markers.put(new LatLng(40.52437,22.202420),"seismos");
        markers.put(new LatLng(latitude,longitude),event);
    }

    private void createMarker(){
        Iterator iter = markers.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            options.position((LatLng) entry.getKey());
            options.title(entry.getValue().toString());
            map.addMarker(options);
        }
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker arg0) {
                LatLng point = arg0.getPosition();
                if(pressed==0){
                    pressed=1;
                    before=point;
                    showCircle(point);
                }else{
                    mCircle.remove();
                    if(before.latitude!=point.latitude && before.longitude!= point.longitude){
                        pressed=1;
                        before=point;
                        showCircle(point);
                    }else{
                        pressed=0;
                    }
                }
                return true;
            }
        });
    }

    private void showCircle(LatLng point){
        CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(point)
            .zoom(17)
            .build();
        mCircleOptions= new CircleOptions()
            .center(new LatLng(point.latitude,point.longitude))
            .radius(280000)
            .strokeColor(Color.argb(80,255,0,0))
            .fillColor(Color.argb(80,255,0,0));
        mCircle=map.addCircle(mCircleOptions);
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}