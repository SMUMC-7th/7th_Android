package com.example.umc_login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.umc_login.databinding.ActivityMainBinding
import com.example.umc_login.remote.LoginRequest
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e("error", "로그인 실패 $error")
        } else if (token != null) {
            Log.e("result", "로그인 성공 ${token.accessToken}, ${token.refreshToken}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var keyHash = Utility.getKeyHash(this)
        Log.d("hash", keyHash.toString())
        initView()
    }

    private fun initView() = with(binding) {
        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val loginresult = RetrofitClient.datasource.postLogin(
                        LoginRequest(
                            email = etId.text.toString(),
                            password = etPw.text.toString()
                        )
                    )

                    loginresult.result?.accessToken?.let {
                        val testResult = RetrofitClient.datasource.getJwtTest(token = "Bearer $it")

                        Log.d("result", "$loginresult, $testResult")
                    }
                } catch (e: Exception) {
                    Log.e("error", e.toString())
                }
            }
        }

        btnJoin.setOnClickListener {
            val intent = Intent(this@MainActivity, JoinActivity::class.java)
            startActivity(intent)
        }

        btnKakao.setOnClickListener {
            kakaoLogin()
        }
    }


    private fun kakaoLogin() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            // 카카오톡 로그인
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                // 로그인 실패 부분
                if (error != null) {
                    Log.e("error", "로그인 실패 $error")
                    // 사용자가 취소
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }
                    // 다른 오류
                    else {
                        UserApiClient.instance.loginWithKakaoAccount(
                            this,
                            callback = mCallback
                        ) // 카카오 이메일 로그인
                    }
                }
                // 로그인 성공 부분
                else if (token != null) {
                    Log.e("result", "로그인 성공 ${token.accessToken}, ${token.refreshToken}")
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback) // 카카오 이메일 로그인
        }
    }

}