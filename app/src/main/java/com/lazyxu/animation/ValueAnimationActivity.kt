package com.lazyxu.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lazyxu.animation.databinding.ActivityValueanimationBinding

/**
 * Created by Administrator on 2017/9/4.
 */

class ValueAnimationActivity : AppCompatActivity() {
    private var mDataBinding: ActivityValueanimationBinding? = null


    private val valueAnimationClick = View.OnClickListener { v ->
        when (v.id) {
            R.id.btn_printlog -> {
                /**
                 * ValueAnimator有它的构造函数，但是官方文档不建议我们直接使用它，因为在内部实现的时候才会用到它。
                 * 之所以不需要用到它，是因为API给我们封装了一系列的的方法来获取实例对象。
                 */
                /**
                 * ValueAnimator有它的构造函数，但是官方文档不建议我们直接使用它，因为在内部实现的时候才会用到它。
                 * 之所以不需要用到它，是因为API给我们封装了一系列的的方法来获取实例对象。
                 */
                val alphaAnimator = ValueAnimator.ofInt(60, 700)
                alphaAnimator.duration = 1500
                alphaAnimator.start()
                alphaAnimator.interpolator = BounceInterpolator()
                alphaAnimator.addUpdateListener { animation ->
                    Log.i("ValueAnimator", "ValueAnimator值变化" + animation.animatedValue)
//                    mDataBinding!!.ivValueanimationShow.scaleX = animation.animatedValue as Float
//                    mDataBinding!!.btnPrintlog.text = animation.animatedValue.toString() + ""

                    val value = animation.animatedValue as Int
                    val layout = mDataBinding!!.ivValueanimationShow.layoutParams
                    layout.width = value
                    layout.height = value
                    mDataBinding!!.ivValueanimationShow.layoutParams = layout
                }
                alphaAnimator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        Toast.makeText(this@ValueAnimationActivity, "ValueAnimator动画结束", Toast.LENGTH_SHORT).show()

                    }
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_valueanimation)
        mDataBinding!!.btnPrintlog.setOnClickListener(valueAnimationClick)
        resources.getString(R.string.advanced_chains)
    }
}


