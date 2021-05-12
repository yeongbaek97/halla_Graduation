package com.yeoungbaek.halla_graduation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeoungbaek.halla_graduation.nevFragment.HomeFragement
import com.yeoungbaek.halla_graduation.nevFragment.InfoFragement
import com.yeoungbaek.halla_graduation.nevFragment.MyStoreFragement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragement: HomeFragement
    private lateinit var infoFragement: InfoFragement
    private lateinit var myStoreFragement: MyStoreFragement

    companion object{
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")



        bottom_nev.setOnNavigationItemSelectedListener (onBottomNavItemSelectedListener)

        homeFragement = HomeFragement.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_frame, homeFragement).commit()

    }

    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{

        when(it.itemId){
            R.id.menu_home ->{
                Log.d(TAG, "MainActivity - 홈버튼")
                homeFragement = HomeFragement.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragement).commit()
            }
            R.id.menu_2 ->{
                Log.d(TAG, "MainActivity - 2버튼")
                myStoreFragement = MyStoreFragement.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame,myStoreFragement).commit()
            }
            R.id.menu_3 ->{
                Log.d(TAG, "MainActivity - 3버튼")
                infoFragement = InfoFragement.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, infoFragement).commit()
            }
        }
        true
    }
}