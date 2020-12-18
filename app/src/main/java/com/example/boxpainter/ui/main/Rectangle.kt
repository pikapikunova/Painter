package com.example.boxpainter.ui.main

import android.graphics.PointF
import kotlin.math.max
import kotlin.math.min

class Rectangle(private val startPoint: PointF) {
    private var currPoint: PointF = startPoint

    fun setCurrentPoint(currPoint: PointF)
    {
        this.currPoint = currPoint

    }
    val left: Float
        get() = min(currPoint.x, startPoint.x)
    val right: Float
        get() = max(currPoint.x, startPoint.x)
    val top: Float
        get() = min(currPoint.y, startPoint.y)
    val bottom: Float
        get() = max(currPoint.y, startPoint.y)

    fun retPoint(): List<Float>
    {
       val list =  mutableListOf<Float>()
        list.add(left)
        list.add(right)
        list.add(top)
        list.add(bottom)

        return list
    }

}