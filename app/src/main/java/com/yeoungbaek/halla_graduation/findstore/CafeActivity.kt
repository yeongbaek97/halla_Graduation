package com.yeoungbaek.halla_graduation.findstore

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yeoungbaek.halla_graduation.R
import kotlinx.android.synthetic.main.activity_cafe.*

class CafeActivity : AppCompatActivity(), OnMapReadyCallback {



    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.mapType = GoogleMap.MAP_TYPE_NORMAL

        // Add a marker in Sydney and move the camera
        val SEOUL = LatLng(37.56, 126.97)
        map.addMarker(MarkerOptions()
            .position(SEOUL)
            .title("서울")
            .snippet("한국의 수도"))

        val cameraPosition = CameraPosition.Builder()
            .target(SEOUL) // Sets the center of the map to Mountain View
            .zoom(17f)            // Sets the zoom
            .bearing(90f)         // Sets the orientation of the camera to east
            .tilt(30f)            // Sets the tilt of the camera to 30 degrees
            .build()
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

    }
}