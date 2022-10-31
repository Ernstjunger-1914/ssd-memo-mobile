package com.ssd.mobile.android.memo.ui.main.splash

import android.os.Bundle
import com.ssd.mobile.android.memo.R
import com.ssd.mobile.android.memo.base.BaseCompatActivity
import com.ssd.mobile.android.memo.databinding.ActivitySplashBinding
import com.ssd.mobile.android.memo.utils.ActivityUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseCompatActivity<ActivitySplashBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1초 후, 실행하기 위해 시작을 임의로 지정
        CoroutineScope(Dispatchers.Main).launch {
            delay(DELAY_TIME)

            ActivityUtils.getInstance().startMainActivity(this@SplashActivity)
            finish()
        }
    }

    companion object {
        const val TAG: String = "SplashActivity"

        const val DELAY_TIME: Long = 1000L
    }

}