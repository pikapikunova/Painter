package com.example.boxpainter.ui.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import java.text.AttributedCharacterIterator

class BoxDrawingView(context: Context, attribute: AttributeSet?): View(context, attribute) {
    constructor(context: Context) : this (context, null)

    val rectangles: MutableList<Rectangle> = mutableListOf()
    var currRectangle: Rectangle? = null

    private val paintRectangle: Paint
    private val paintBg: Paint




    init{
        paintRectangle = Paint()
        paintRectangle.color = 0x220000ff

        paintBg = Paint()
        paintBg.color = 0x51ff0000.toInt()

    }


    fun giveCurRect(): List<Rectangle>{
        return rectangles
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {it->
            val curr = PointF(it.x, it.y)
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    currRectangle = Rectangle(curr).also {
                        rectangles.add(it)
                    }
                }
                MotionEvent.ACTION_MOVE ->{
                    currRectangle?.apply {
                        setCurrentPoint(curr)
                        invalidate()
                    }
                }
                MotionEvent.ACTION_UP ->{
                    currRectangle = null
                }
                else -> {
                    currRectangle = null
                }
            }
        }
        return true
    }

    public override fun onDraw(canvas: Canvas?){
        super.onDraw(canvas)
        canvas?.let{ cnv->
            cnv.drawPaint(paintBg)
            rectangles.forEach{
                cnv.drawRect(it.left, it.top, it.right, it.bottom, paintRectangle)
            }
        }
    }


}