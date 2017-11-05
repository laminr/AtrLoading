package biz.eventually.atr

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.annotation.StyleRes
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import biz.eventually.atr.runup.R

/**
 * Created by Thibault de Lambilly on 05/11/2017.
 */
class RunUpBckgDrawable : FrameLayout {

    private var animation: AnimatedVectorDrawableCompat? = null
    private lateinit var container: ImageView

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
        container = findViewById(R.id.bckg_atr)

        animation = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.props_rotation)
        container.setImageDrawable(animation)
    }

    fun start() {
        if (animation?.isRunning == false) {
            animation?.start()
        }
    }

    fun stop() {
        if (animation?.isRunning == true) {
            animation?.stop()
        }
    }

}