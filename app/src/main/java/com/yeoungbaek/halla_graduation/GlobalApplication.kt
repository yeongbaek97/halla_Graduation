package com.yeoungbaek.halla_graduation

import android.app.Application
import com.kakao.sdk.common.KakaoSdk


class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "e63be3ea32a5509a2d0e9baa11821345")
    }
}