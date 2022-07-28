package kr.co.softcampus.sopt_assignment1.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import dagger.hilt.android.HiltAndroidApp

// 의존성 주입의 시작점 지정
// Application 생명주기를 따르며 컴파일 단계 시 DI에 필요한 구성요소들을 초기화하기 위함
@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
    }
}