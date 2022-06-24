package com.codetron.circularrecyclerview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.widget.TextView
import androidx.core.view.get
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView

class NameItemDecoration(private val result: (String) -> Unit) : RecyclerView.ItemDecoration() {

    private val rect by lazy { RectF() }
    private val paint by lazy {
        Paint().apply {
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 50F
            color = Color.BLUE
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        if (parent.scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            val view = parent.findChildViewUnder(parent.width / 2F, parent.height.toFloat())
            result((view as? TextView)?.text.toString())
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        if (parent.size <= 1) return

        val child = parent[parent.size / 2]
        val childWidth = child.width - child.paddingLeft/2
        val childHeight = child.height - child.paddingTop/2
        val centerX = parent.width / 2
        val centerY = parent.height / 2

        rect.apply {
            left = centerX - (childWidth / 2f)
            right = centerX + (childWidth / 2F)
            top = centerY - (childHeight / 2F)
            bottom = centerY + (childHeight / 2F)
        }

        c.drawRect(rect, paint)
    }

}