package com.yeoungbaek.halla_graduation

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
    val PERM_FLAG = 99

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if (isPermitted()){
            startProcess()
        } else {
            ActivityCompat.requestPermissions(this, permissions, PERM_FLAG)
        }

    }

    fun isPermitted() : Boolean{
        for(perm in permissions){
            if (ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED)
                return false
        }

        return true
    }

    fun startProcess(){
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }



    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


        setUpdateLocationListener()

    }

    // 현재 내 위치 가져오기
    lateinit var fusedLocationClient:FusedLocationProviderClient
    lateinit var locationCallback:LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListener() {
        val locationRequest = LocationRequest.create()
        locationRequest.run{
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }

        locationCallback = object : LocationCallback () {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let{
                    for((i, location) in it.locations.withIndex()){
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)
                    }
                }

            }
        }

        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
    }

    fun setLastLocation(location : Location) {
        val myLocation = LatLng(location.latitude, location.longitude)
        val marker = MarkerOptions()
            .position(myLocation)
            .title("me")
        val cameraOption = CameraPosition.Builder()
            .target(myLocation)
            .zoom(15.0f)
            .build()
        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.clear()
        mMap.addMarker(marker)
        mMap.moveCamera(camera)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            PERM_FLAG ->{
                var check = true
                for(grant in grantResults){
                    if(grant != PERMISSION_GRANTED) {
                        check = false
                        break
                    }
                }
                if(check){
                    startProcess()
                } else{
                    Toast.makeText(this, "권한 승인이 필요합니다.", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}