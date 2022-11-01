package com.ssd.mobile.android.memo.ui.main.memo

import android.os.Bundle
import com.ssd.mobile.android.memo.R
import com.ssd.mobile.android.memo.base.BaseCompatActivity
import com.ssd.mobile.android.memo.databinding.ActivityMemoWriteBinding
import com.ssd.mobile.android.memo.ui.view.HeaderCallback

class MemoWriteActivity : BaseCompatActivity<ActivityMemoWriteBinding>(), HeaderCallback {

    override fun getLayoutId(): Int = R.layout.activity_memo_write

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.headerView.headerCallback = this
    }

    override fun onBackEvent() {
        moveTaskToBack(true)
        finish()
    }

    override fun onNextEvent() {
        TODO("메모 저장 기능 구현 필요")
    }

}