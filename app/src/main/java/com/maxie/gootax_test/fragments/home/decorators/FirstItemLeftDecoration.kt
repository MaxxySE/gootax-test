package com.maxie.gootax_test.fragments.home.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FirstAndLastItemDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if (position == 0) {
            outRect.left = margin
        }

        if (position == itemCount - 1) {
            outRect.right = margin
        }
    }
}