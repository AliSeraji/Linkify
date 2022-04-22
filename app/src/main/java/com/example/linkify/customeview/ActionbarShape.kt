package com.example.linkify.customeview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import com.example.linkify.R

class ActionbarShape(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var upperPaint:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bottomPaint:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var middlePaint:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var upperShapeColor:Int
    private var middleShapeColor:Int
    private var bottomShapeColor:Int
    init{

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ActionbarShape,
            0, 0).apply {
            try {
                upperShapeColor = getInt(R.styleable.ActionbarShape_upperShapeColor, R.style.guest_action_bar_shape)
                middleShapeColor = getInt(R.styleable.ActionbarShape_middleShapeColor, R.style.guest_action_bar_shape)
                bottomShapeColor = getInt(R.styleable.ActionbarShape_bottomShapeColor, R.style.guest_action_bar_shape)

            } finally {
                recycle()
            }
        }
        upperPaint.isAntiAlias= true
        middlePaint.isAntiAlias = true
        upperPaint.isAntiAlias = true
        upperPaint.alpha = 3
        middlePaint.alpha = 2
        bottomPaint.alpha = 1
        upperPaint.color = upperShapeColor
        middlePaint.color = middleShapeColor
        bottomPaint.color = bottomShapeColor
        this.rotationX = -180f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width:Float = context.resources.displayMetrics.widthPixels.toFloat()
        val height:Float = context.resources.displayMetrics.heightPixels.toFloat()
        val upperHalfCircle = RectF(-width/1.5f,height/1.3f,width+(width/1.5f),1.95f*height)
        val middleHalfCircle = RectF(-width/1.5f,height/1.4f,width+(width/1.5f),1.95f*height)
        val bottomHalfCircle = RectF(-width/1.5f,height/1.5f,width+(width/1.5f),1.95f*height)
        canvas!!.drawArc(bottomHalfCircle,180f,180f,false,bottomPaint)
        canvas!!.drawArc(middleHalfCircle,180f,180f,false,middlePaint)
        canvas!!.drawArc(upperHalfCircle,180f,180f,false,upperPaint)

    }
}