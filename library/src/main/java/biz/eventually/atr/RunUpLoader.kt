package biz.eventually.atr

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.richpath.RichPath
import com.richpath.RichPathView
import com.richpathanimator.RichPathAnimator


/**
 * Created by Thibault de Lambilly on 04/11/2017.
 */
class RunUpLoader(context: Context) : Dialog(context, R.style.alert_dialog) {

    private lateinit var svg: RichPathView
    private var propRight: RichPath? = null
    private var propLeft: RichPath? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atr_layout)

        svg = findViewById(R.id.svg)

        propRight = svg.findRichPathByName("prop-right")
        propLeft = svg.findRichPathByName("prop-left")
    }

    override fun show() {
        super.show()
        init()
    }

    fun start() {
        show()
    }

    fun stop() {
        super.dismiss()
    }

    private fun init() {
        val duration: Long = 2000
        RichPathAnimator.animate(propRight)
                .interpolator(LinearInterpolator())
                .rotation(0F, 360F)
                .duration(duration)
                .repeatCount(-1)

                .andAnimate(propLeft)
                .interpolator(LinearInterpolator())
                .rotation(0F, -360F)
                .duration(duration)
                .repeatCount(-1)
                .start()
    }
}