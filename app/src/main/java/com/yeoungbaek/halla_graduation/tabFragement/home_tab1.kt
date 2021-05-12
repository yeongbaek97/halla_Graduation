package com.yeoungbaek.halla_graduation.tabFragement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeoungbaek.halla_graduation.MapsActivity
import com.yeoungbaek.halla_graduation.findstore.CafeActivity
import com.yeoungbaek.halla_graduation.R
import com.yeoungbaek.halla_graduation.findstore.RestaurangActivity
import com.yeoungbaek.halla_graduation.findstore.SojuActivity
import kotlinx.android.synthetic.main.fragment_home_tab1.*

class home_tab1 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



         ic_Restaurang.setOnClickListener {
             activity?.let{
                 val intent = Intent(context, MapsActivity::class.java)
                 startActivity(intent)
             }
         }

         ic_soju.setOnClickListener {
             activity?.let{
                 val intent = Intent(context, SojuActivity::class.java)
                 startActivity(intent)
             }
         }

         ic_cafe.setOnClickListener {
             activity?.let{
                 val intent = Intent(context, CafeActivity::class.java)
                 startActivity(intent)
             }
         }






    }
}