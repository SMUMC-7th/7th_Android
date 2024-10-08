package com.wash.smumc_7th_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wash.smumc_7th_android.com.wash.smumc_7th_android.FavoriteFragment
import com.wash.smumc_7th_android.com.wash.smumc_7th_android.SettingsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // happybttn에 클릭 리스너 추가
        findViewById<ImageView>(R.id.happybttn).setOnClickListener {
            // HappyActivity로 이동
            val intent = Intent(this, HappyActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bnv)

        // 첫 화면에 HomeFragment를 표시
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment())
            .commit()

        // BottomNavigationView 클릭 리스너 설정
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    // 홈 화면으로 이동
                    true
                }

                R.id.nav_search -> {
                    replaceFragment(SearchFragment())
                    // 검색 화면으로 이동
                    true
                }

                R.id.nav_heart -> {
                    replaceFragment(FavoriteFragment())
                    // 즐겨찾기 화면으로 이동
                    true
                }

                R.id.nav_settings -> {
                    replaceFragment(SettingsFragment())
                    // 설정 화면으로 이동
                    true
                }

                else -> false
            }
        }
    }

    // 프래그먼트를 교체하는 함수
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

        // 슬라이드 애니메이션 적용
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_in_right,  // 새 프래그먼트가 오른쪽에서 들어옴
            R.anim.slide_out_left,  // 기존 프래그먼트가 왼쪽으로 나감
            R.anim.slide_in_left,   // 뒤로가기 시 새 프래그먼트가 왼쪽에서 들어옴
            R.anim.slide_out_right  // 뒤로가기 시 기존 프래그먼트가 오른쪽으로 나감
        )

        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
