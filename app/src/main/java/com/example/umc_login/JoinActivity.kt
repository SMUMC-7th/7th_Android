package com.example.umc_login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.umc_login.databinding.ActivityJoinBinding
import com.example.umc_login.remote.JoinRequest
import kotlinx.coroutines.launch

class JoinActivity : AppCompatActivity() {
    private val binding: ActivityJoinBinding by lazy {
        ActivityJoinBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        btnJoin.setOnClickListener {
            lifecycleScope.launch {
                try {
                    var joinResult = RetrofitClient.datasource.postJoin(
                        JoinRequest(
                            name = etName.text.toString(),
                            email = etId.text.toString(),
                            password = etPw.text.toString()
                        )
                    )
                        Log.d("result", "$joinResult")
                        finish()
                } catch (e: Exception) {
                    Log.e("error", e.toString())
                }
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

}
