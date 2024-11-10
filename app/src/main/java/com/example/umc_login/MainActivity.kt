package com.example.umc_login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.umc_login.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initView()
    }

    private fun initView() = with(binding) {
        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val loginresult = RetrofitClient.datasource.postLogin(
                        email = etId.text.toString(),
                        password = etPw.text.toString()
                    )

                    loginresult.result?.accessToken?.let {
                        val testResult = RetrofitClient.datasource.getJwtTest(token = it)

                        Log.d("result", "$loginresult, $testResult")
                    }
                } catch (e: Exception){
                    Log.e("error", e.toString())
                }
            }
        }

        btnJoin.setOnClickListener {
            val intent = Intent(this@MainActivity, JoinActivity::class.java)
            startActivity(intent)
        }
    }


}