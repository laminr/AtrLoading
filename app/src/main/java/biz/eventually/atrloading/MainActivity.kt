package biz.eventually.atrloading

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import biz.eventually.atr.MotionDelay
import biz.eventually.atr.RunUpBckgRichPath
import biz.eventually.atr.RunUpLoader


class MainActivity : AppCompatActivity() {

    private val speeds = listOf(MotionDelay.BY_THE_WIND, MotionDelay.SLOW, MotionDelay.NORMAL, MotionDelay.QUICK)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickDialog(view: View) {
        val atr = RunUpLoader(this)
        atr.show()
    }

    fun onClickSvg(view: View) {
        val atr = findViewById<RunUpBckgRichPath>(R.id.runup)
        atr.start(speeds[index])
        if (index++ >= speeds.size) index = 0

    }
}
