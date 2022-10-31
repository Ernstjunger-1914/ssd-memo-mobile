package com.ssd.mobile.android.memo.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class EmptySupportRecyclerView : RecyclerView {

    private var emptyView: View? = null

    private val emptyObserver: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            checkEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            checkEmpty()
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            checkEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            checkEmpty()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            checkEmpty()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            checkEmpty()
        }
    }

    constructor(context: Context) : this(context, null)

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(
        context,
        attrs,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setAdapter(adapter: Adapter<*>?) {
        this.adapter?.unregisterAdapterDataObserver(emptyObserver)
        super.setAdapter(adapter)
        this.adapter?.registerAdapterDataObserver(emptyObserver)

        checkEmpty()
    }

    fun setEmptyView(emptyView: View?) {
        this.emptyView = emptyView
    }

    private fun checkEmpty() {
        emptyView?.let { emptyView ->
            adapter?.let { adapter ->
                emptyView.isVisible = adapter.itemCount == 0
            }
        }
    }

}