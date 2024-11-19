package com.example.umc_login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }
}