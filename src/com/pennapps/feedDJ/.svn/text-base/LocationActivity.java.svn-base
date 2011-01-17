package com.pennapps.feedDJ;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends Activity {

	private double latitude;
	private double longitude;
	private String zipCode;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LocationManager locationManager;
		String context = Context.LOCATION_SERVICE;
		locationManager = (LocationManager)getSystemService(context);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		String provider = locationManager.getBestProvider(criteria, true);
		
		Location location = locationManager.getLastKnownLocation(provider);
		updateWithNewLocation(location);
		
		locationManager.requestLocationUpdates(provider, 2000, 10, locationListener);
	}
		
	private final LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location){
			updateWithNewLocation(location);
		}
		
		public void onProviderDisabled(String provider){
			updateWithNewLocation(null);
		}
		public void onProviderEnabled(String provider){}
		public void onStatusChanged(String provider, int status, Bundle extras){}
		
	};

	private void updateWithNewLocation(Location location) {
		// TODO Auto-generated method stub
		String latLongString;
		TextView myLocationText;
		//myLocationText = (TextView)findViewById(R.id.myLocationText);
		
		String addressString = "No Address Found";
		
		if(location != null) {
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			Geocoder gc = new Geocoder(this, Locale.getDefault());
			try{
				List<Address> addresses = gc.getFromLocation(latitude, longitude, 1);
				StringBuilder sb = new StringBuilder();
				if (addresses.size() > 0 ){
					Address address = addresses.get(0);
					zipCode = address.getPostalCode();	
					
				}
			}catch(IOException e) {}
		}
	}
}
