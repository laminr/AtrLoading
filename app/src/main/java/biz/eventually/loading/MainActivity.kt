package biz.eventually.loading

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import biz.eventually.atr.enum.MotionDelay
import biz.eventually.atr.RunUpBckgRichPath
import biz.eventually.atr.RunUpLoader
import android.os.CountDownTimer
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    private val speeds = listOf(MotionDelay.BY_THE_WIND, MotionDelay.SLOW, MotionDelay.NORMAL, MotionDelay.QUICK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val atr = findViewById<RunUpBckgRichPath>(R.id.runup)
        val rdo = findViewById<RadioGroup>(R.id.rdoGroup)
        val dialog = findViewById<Button>(R.id.dialog)

        dialog.setOnClickListener {
            val atrLoader = RunUpLoader(this)
            atrLoader.start()

            object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() { atrLoader.stop() }
            }.start()
        }

        rdo.setOnCheckedChangeListener { group, checkedId ->
            val theOne = group.findViewById<RadioButton>(checkedId)
            val which =  theOne.tag.toString().toInt()
            if (which == 0) {
                atr.stop()
            }else {
                atr.start(speeds[which-1])
            }
        }
    }

}
