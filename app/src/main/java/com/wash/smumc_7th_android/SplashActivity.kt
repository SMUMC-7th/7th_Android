package com.wash.smumc_7th_android

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wash.smumc_7th_android.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        playLottieAnimation()
    }

    private fun playLottieAnimation() = with(binding.lottieSplash){
        // Lottie 애니메이션 리스너 추가
        addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                // 애니메이션 시작 시 필요한 동작
            }

            override fun onAnimationEnd(animation: Animator) {
                // 애니메이션이 끝나면 화면 전환
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish() // 스플래시 액티비티 종료
            }

            override fun onAnimationCancel(animation: Animator) {
                // 애니메이션 취소 시 처리
            }

            override fun onAnimationRepeat(animation: Animator) {
                // 애니메이션 반복 시 처리
            }
        })

        // Lottie 애니메이션 실행
        playAnimation()
    }
}
