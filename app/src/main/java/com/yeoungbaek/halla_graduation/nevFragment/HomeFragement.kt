package com.yeoungbaek.halla_graduation.nevFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yeoungbaek.halla_graduation.R
import com.yeoungbaek.halla_graduation.adapter.ViewPagerAdapters
import kotlinx.android.synthetic.main.frag_home.*


class HomeFragement : Fragment(){

    private lateinit var Tabs:TabLayout
    private lateinit var ViewPager2: ViewPager2
    private lateinit var pagerAdapters: ViewPagerAdapters




    companion object{
        const val TAG : String = "로그"

        fun newInstance() : HomeFragement {
            return HomeFragement()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomFragment - onCreate() called")

    }

    //tab 아이디찾는곳
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Tabs = view.findViewById(R.id.home_tablayout)
        ViewPager2 = view.findViewById(R.id.home_viewPager)
        pagerAdapters = ViewPagerAdapters(childFragmentManager,lifecycle)

        home_viewPager.adapter=pagerAdapters

        TabLayoutMediator(home_tablayout,home_viewPager){tab,position ->
            when(position){
                0->{
                    tab.text="근처 가게"
                }
                1->{
                    tab.text="자리 찾기"
                }
            }
        }.attach()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomFragment - onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "HomFragment - onCreate() called")


        return inflater.inflate(R.layout.frag_home, container, false)


    }





}