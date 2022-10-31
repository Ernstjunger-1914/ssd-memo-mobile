package com.ssd.mobile.android.memo.utils

import android.app.Activity
import android.content.Intent
import com.ssd.mobile.android.memo.ui.main.MainActivity

class ActivityUtils {

    fun startMainActivity(activity: Activity) {
        Intent(activity, MainActivity::class.java).let {
            activity.startActivity(it)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ActivityUtils? = null

        @JvmStatic
        fun getInstance(): ActivityUtils = INSTANCE ?: synchronized(this) {
            INSTANCE ?: ActivityUtils().also {
                INSTANCE = it
            }
        }
    }

}