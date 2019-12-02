package com.lazyxu.animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.lazyxu.animation.databinding.ActivityFrameanimationBinding

/**
 * 帧动画
 */
class FrameAnimationctivity : AppCompatActivity() {
    private var mDataBinding: ActivityFrameanimationBinding? = null
    private var animationDrawable: AnimationDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_frameanimation)
        //        animationDrawable = (AnimationDrawable) mDataBinding.ivAnimation.getBackground();//设置background
        animationDrawable = mDataBinding!!.ivAnimation.drawable as AnimationDrawable//设置src
        animationDrawable!!.start()
        mDataBinding!!.btnStart.setOnClickListener {
            if (animationDrawable != null && !animationDrawable!!.isRunning) {
                animationDrawable!!.start()
            }
        }
        mDataBinding!!.btnStop.setOnClickListener {
            if (animationDrawable != null && animationDrawable!!.isRunning) {
                animationDrawable!!.stop()
            }
        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //	不要在onCreate()调start()，因AnimationDrawable还没完全跟Window关联，
        // 想要界面显示时就开始动画，可在  onWindowFocusChanged()调start()。
        //		if (!animationDrawable.isRunning()) {
        //			animationDrawable.start();
        //		}}
    }

    override fun onDestroy() {
        super.onDestroy()
        if (null != animationDrawable) {
            animationDrawable!!.stop()
        }
    }

}

