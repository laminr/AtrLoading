package biz.eventually.atr.enum

/**
 * Created by Thibault de Lambilly on 05/11/2017.
 */
enum class MotionDelay(val time: Long) {
    BY_THE_WIND(10000),
    SLOW(5000),
    NORMAL(1000),
    QUICK(500)
}