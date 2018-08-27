//BookList
//Project for Mobile Software Development
//Tavi Nolan
//c15406532

package com.example.pc.booklist;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

//Class that allows user to search map fro libraries in area
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //Declarations
    private GoogleMap gmap;
    //LocationManager used for finding current location of user
    LocationManager locationManager;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //Allows map to be added to screen
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //When map has loaded, handles map setup
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        gmap = googleMap;

        //Checks permissions for getting location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        //Enable getting location
        gmap.setMyLocationEnabled(true);

        //Gets location LatLng
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        //Gets lat and long from user's location LatLng,
        //stores values for lat and long in separate variables
        double mylat = location.getLatitude();
        double mylong = location.getLongitude();

        //Sets down a marker to users current location
        //and moves camera to marker
        LatLng home = new LatLng(mylat, mylong);
        gmap.addMarker(new MarkerOptions().position(home).title("Home"));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(home));
    }


    //Method for searching map
    public void find(View v) throws IOException
    {
        //Sets string to be searched for in map to "library"
        String location = "Library";
        List<Address> addressList = null;

        //Sets boundaries of the screen, so that when the user
        //searches locations, it only searches the parts
        // of the map visible on the screen
        LatLng bottomLeft = gmap.getProjection().getVisibleRegion().nearLeft;
        LatLng topRight = gmap.getProjection().getVisibleRegion().farRight;

        //geocoder for turning libraries into LatLngs
        Geocoder loc = new Geocoder(this);
        try
        {
            //gets library address result from search, stores in address list
            addressList = loc.getFromLocationName(location, 1, bottomLeft.latitude, bottomLeft.longitude, topRight.latitude, topRight.longitude);
        }
        catch(IOException e)
        {
            //Toast to inform user of error
            Toast.makeText(MapsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        //getting address of library from address list
        assert addressList != null;
        Address address = addressList.get(0);
        //getting lat and long of address of library
        LatLng latlng = new LatLng(address.getLatitude(), address.getLongitude());

        //Setting down marker, and moving camera to location of library
        gmap.addMarker(new MarkerOptions().position(latlng).title("Library"));
        gmap.animateCamera(CameraUpdateFactory.newLatLng(latlng));
    }
}
