package com.yeoungbaek.halla_graduation.nevFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yeoungbaek.halla_graduation.R

class MyStoreFragement : Fragment(){

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : MyStoreFragement {
            return MyStoreFragement()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MyStoreFragement - onCreate() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "MyStoreFragement - onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "MyStoreFragement - onCreate() called")

        return inflater.inflate(R.layout.frag_mystore, container, false)
    }

}