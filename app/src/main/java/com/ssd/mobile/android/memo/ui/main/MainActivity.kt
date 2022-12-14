package com.ssd.mobile.android.memo.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssd.mobile.android.memo.R
import com.ssd.mobile.android.memo.base.BaseCompatActivity
import com.ssd.mobile.android.memo.databinding.ActivityMainBinding
import com.ssd.mobile.android.memo.ui.view.HeaderCallback
import com.ssd.mobile.android.memo.utils.ActivityUtils

class MainActivity : BaseCompatActivity<ActivityMainBinding>(), HeaderCallback {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setEmptyView(binding.emptyView)

        binding.headerView.headerCallback = this
    }

    override fun onBackEvent() {
        TODO("뒤로가기 버튼 비활성화하기")
    }

    override fun onNextEvent() {
        ActivityUtils.getInstance().startMemoWriteActivity(this@MainActivity)
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}