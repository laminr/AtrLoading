package biz.eventually.atr

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.annotation.StyleRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import biz.eventually.atr.enum.MotionDelay
import com.richpath.RichPath
import com.richpath.RichPathView
import com.richpathanimator.AnimationBuilder
import com.richpathanimator.RichPathAnimator

/**
 * Created by Thibault de Lambilly on 05/11/2017.
 */
class RunUpBckgRichPath : FrameLayout {

    private var props: AnimationBuilder? = null
    private var propRight: RichPath? = null
    private var propLeft: RichPath? = null

    lateinit var svg: RichPathView

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet) : super(context, attrs, 0) {
        initView(context)
    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet, @AttrRes defStyleAttr: Int) : super(context, attrs, defStyleAttr, 0) {
        initView(context)
    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet, @AttrRes defStyleAttr: Int, @StyleRes defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context)
    }

    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.atr_background, this, true)

        svg = findViewById(R.id.svg)
        propRight = svg.findRichPathByName("prop-right")
        propLeft = svg.findRichPathByName("prop-left")

    }

    fun start(speed: MotionDelay = MotionDelay.NORMAL) {
        stop()
        initAnimator(speed)
        props?.start()
    }

    fun stop() {
        props = null
    }

    private fun initAnimator(speed: MotionDelay = MotionDelay.NORMAL) {
        props = RichPathAnimator.animate(propRight)
                .interpolator(LinearInterpolator())
                .rotation(0F, 360F)
                .duration(speed.time)
                .repeatCount(-1)
                .andAnimate(propLeft)
                .interpolator(LinearInterpolator())
                .rotation(0F, -360F)
                .duration(speed.time)
                .repeatCount(-1)
    }

}