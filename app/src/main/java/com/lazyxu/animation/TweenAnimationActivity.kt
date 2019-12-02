package com.lazyxu.animation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.lazyxu.animation.databinding.ActivityTweenanimationBinding

/**
 * Created by Administrator on 2017/5/17.
 */

class TweenAnimationActivity : AppCompatActivity() {
    private var mDataBinding: ActivityTweenanimationBinding? = null

    private val tweenanimationClick = View.OnClickListener { v ->
        when (v.id) {
            R.id.btn_alphat -> {
                //============================xml中设置=====================================
                //					Animation alphaAnimation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.tweenanimation_alphat);
                //					mDataBinding.ivTweenanimation.startAnimation(alphaAnimation);
                //============================代码设置（二选一）=====================================
                val alphaAnimation = AlphaAnimation(1.0f, 0.1f)
                alphaAnimation.duration = 4000
                alphaAnimation.fillAfter = true //fillAfter = true表示停留,否则还原到初始
                alphaAnimation.repeatCount = 2//无限次 Animation.INFINITE
                alphaAnimation.repeatMode = Animation.REVERSE
                mDataBinding!!.ivTweenanimation.startAnimation(alphaAnimation)
                //=================================================================
                alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {
                        Toast.makeText(this@TweenAnimationActivity, "动画开始", Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationEnd(animation: Animation) {
                        Toast.makeText(this@TweenAnimationActivity, "动画结束", Toast.LENGTH_SHORT).show()
                        mDataBinding!!.ivTweenanimation.visibility=View.GONE
                        mDataBinding!!.ivTweenanimation.clearAnimation()

                    }

                    override fun onAnimationRepeat(animation: Animation) {
                        Toast.makeText(this@TweenAnimationActivity, "动画重复", Toast.LENGTH_SHORT).show()
                    }
                })
            }
            R.id.btn_scale -> {
                //xml中设置
                //					Animation scaleAnimation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.tweenanimation_scale);
                //					mDataBinding.ivTweenanimation.startAnimation(scaleAnimation);
                //					 代码设置（二选一）
                val scaleAnimation = ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                scaleAnimation.duration = 800
                scaleAnimation.repeatMode = Animation.REVERSE
                scaleAnimation.repeatCount = Animation.INFINITE//无限次
                mDataBinding!!.ivTweenanimation.startAnimation(scaleAnimation)
            }
            R.id.btn_translate -> {
                //xml中设置
                val translateAnimation = AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.tweenanimation_translate)
                mDataBinding!!.ivTweenanimation.startAnimation(translateAnimation)
            }
            R.id.btn_rotate -> {
                //xml中设置
                val rotateAnimation = AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.tweenanimation_rotate)
                mDataBinding!!.ivTweenanimation.startAnimation(rotateAnimation)
            }
            R.id.btn_combine//组合动画
            -> {
                //xml中设置
                //					Animation combineAnimation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.tweenanimation_combine);
                //					mDataBinding.ivTweenanimation.startAnimation(combineAnimation);
                // 代码设置（二选一）
                val combine_alphaAnimation = AlphaAnimation(0.1f, 1.0f)
                combine_alphaAnimation.duration = 1000
                val combine_scaleAnimation = ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                combine_scaleAnimation.startOffset = 1000
                combine_scaleAnimation.duration = 1000
                val combine_translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f)
                combine_scaleAnimation.startOffset = 2000
                combine_translateAnimation.duration = 1000
                val combine_rotateAnimation = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f)
                combine_scaleAnimation.startOffset = 3000
                combine_rotateAnimation.duration = 1000
                combine_rotateAnimation.repeatCount = 1
                val animationSet = AnimationSet(true)
                animationSet.addAnimation(combine_alphaAnimation)
                animationSet.addAnimation(combine_scaleAnimation)
                animationSet.addAnimation(combine_translateAnimation)
                animationSet.addAnimation(combine_rotateAnimation)
                animationSet.fillAfter = true
                mDataBinding!!.ivTweenanimation.startAnimation(animationSet)
            }
        }// 代码设置（二选一）
        //					TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1,
        //							Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);
        //					translateAnimation.setDuration(800);
        //					translateAnimation.setRepeatMode(Animation.REVERSE);
        //					translateAnimation.setRepeatCount(Animation.INFINITE);
        //					mDataBinding.ivTweenanimation.startAnimation(translateAnimation);
        // 代码设置（二选一）
        //					RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 1f,
        //							Animation.RELATIVE_TO_SELF, 1f);
        //					rotateAnimation.setDuration(800);
        //					rotateAnimation.setRepeatMode(Animation.RESTART);
        //					rotateAnimation.setRepeatCount(Animation.INFINITE);
        //					mDataBinding.ivTweenanimation.startAnimation(rotateAnimation);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_tweenanimation)
        mDataBinding!!.btnAlphat.setOnClickListener(tweenanimationClick)
        mDataBinding!!.btnScale.setOnClickListener(tweenanimationClick)
        mDataBinding!!.btnTranslate.setOnClickListener(tweenanimationClick)
        mDataBinding!!.btnRotate.setOnClickListener(tweenanimationClick)
        mDataBinding!!.btnCombine.setOnClickListener(tweenanimationClick)
        mDataBinding!!.ivTweenanimation.setOnClickListener { Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show() }
    }


}
