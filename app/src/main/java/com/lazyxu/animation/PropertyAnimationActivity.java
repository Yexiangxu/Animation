package com.lazyxu.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.lazyxu.animation.databinding.ActivityPropertyanimationBinding;

/**
 * Created by Administrator on 2017/5/18.
 */

public class PropertyAnimationActivity extends AppCompatActivity {
    private ActivityPropertyanimationBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_propertyanimation);
        mDataBinding.btnColorchange.setOnClickListener(propertyClick);
        mDataBinding.btnAlpha.setOnClickListener(propertyClick);
        mDataBinding.btnScale.setOnClickListener(propertyClick);
        mDataBinding.btnTranslate.setOnClickListener(propertyClick);
        mDataBinding.btnRotate.setOnClickListener(propertyClick);
        mDataBinding.btnCombine.setOnClickListener(propertyClick);
        mDataBinding.btnViewpropertyanimator.setOnClickListener(propertyClick);
        mDataBinding.btnValueanimator.setOnClickListener(propertyClick);
        mDataBinding.ivPropertyanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PropertyAnimationActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                mDataBinding.ivPropertyanimation.setVisibility(View.GONE);
            }
        });
    }

    private View.OnClickListener propertyClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_colorchange://>=21
                    ObjectAnimator.ofArgb(mDataBinding.btnColorchange, "backgroundColor", ContextCompat.getColor(PropertyAnimationActivity.this, R.color.colorAccent), ContextCompat.getColor(PropertyAnimationActivity.this, R.color.colorPrimary)).setDuration(3000).start();
                    break;
                case R.id.btn_alpha:
                    //========================xml设置属性动画================================
                    Animator animator = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.propertyanimation_alpha);
                    animator.setTarget(mDataBinding.ivPropertyanimation);
                    animator.start();
                    animator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            Toast.makeText(PropertyAnimationActivity.this, "onAnimationStart", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Toast.makeText(PropertyAnimationActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            Toast.makeText(PropertyAnimationActivity.this, "onAnimationCancel", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            Toast.makeText(PropertyAnimationActivity.this, "onAnimationRepeat", Toast.LENGTH_SHORT).show();
                        }
                    });

                    //=========================java代码动态设置属性动画===============================
//					ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "alpha", 1f, 0.5f, 1f);
//					objectAnimator.setDuration(1000);
//					objectAnimator.setStartDelay(1000);
//					objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//					objectAnimator.setRepeatCount(3);
//					objectAnimator.start();
                    break;
                case R.id.btn_scale:
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "scaleX", 1f, 2.0f);
                    objectAnimator1.setDuration(2000);
                    objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
                    objectAnimator1.start();
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "scaleY", 1f, 2.0f);
                    objectAnimator2.setDuration(2000);
                    objectAnimator2.setInterpolator(new OvershootInterpolator());
                    objectAnimator2.start();
                    break;
                case R.id.btn_translate:
                    Animator animatortranslate = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.propertyanimation_translate_x);
                    animatortranslate.setTarget(mDataBinding.ivPropertyanimation);
                    animatortranslate.setInterpolator(new AccelerateDecelerateInterpolator());
//					animatortranslate.setInterpolator(new EaseCubicInterpolator(.6f,.64f,.83f,.19f));
                    animatortranslate.start();
//					ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "translationX", 0, -300, 0).setDuration(1000).start();
//					ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "translationY", 0, -300, 0).setDuration(1000).start();
                    break;
                case R.id.btn_rotate:

					ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "rotation", mDataBinding.ivPropertyanimation.getRotation(), mDataBinding.ivPropertyanimation.getRotation() + 180).setDuration(1000).start();
//                    ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "rotationX", 180).setDuration(2000).start();
//					ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "rotationY", mDataBinding.ivPropertyanimation.getRotationY(), mDataBinding.ivPropertyanimation.getRotationY() + 180).setDuration(2000).start();
                    break;
                case R.id.btnCombine:
                    //========================xml设置属性动画================================
//                    AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.propertyanimation_combine);
//                    set.setTarget(mDataBinding.ivPropertyanimation);
//                    set.setDuration(2000);
//                    set.start();
                    propertyValuesHolder(mDataBinding.ivPropertyanimation);
                    //=========================java代码动态设置属性动画===============================
//					ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "alpha", 1f, 0f, 1f);
//					ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "scaleX", 1f, 0.5f, 1f);
//					ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "scaleY", 1f, 0.5f, 1f);
//					ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(mDataBinding.ivPropertyanimation, "translationX", 0f, 200f, 0f);
//					AnimatorSet set = new AnimatorSet();
//					set.play(scaleXAnimator).with(scaleYAnimator).after(alphaAnimator).before(translationXAnimator);
//					//都设置3s，也可以为每个单独设置
//					set.setDuration(3000);
//					set.setStartDelay(1000);
//					set.start();

//                    set.addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
//                            Toast.makeText(PropertyAnimationActivity.this, "动画结束", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    break;
                case R.id.btn_viewpropertyanimator:
                    mDataBinding.ivPropertyanimation.animate()
                            .scaleX(2f)
                            .scaleY(2f)
                            .alpha(0.5f)
                            .setDuration(2000)
                            .setStartDelay(2000)
                            .start();
                    break;
                case R.id.btn_valueanimator:
                    startActivity(new Intent(PropertyAnimationActivity.this, ValueAnimationActivity.class));
                    break;
            }
        }
    };

    /**
     * PropertyValuesHolder类可以先将动画属性和值暂时的存储起来,后一起执行，在有些时候可以使用替换掉AnimatorSet减少代码量
     * KeyFrame 主要帧：如果想要更精确控制整个动画过程的某个点或某个时段达到的值，可以通过自定义插值器或估值器来实现， 或Keyframe实现
     */
    private void propertyValuesHolder(View view) {
        Keyframe keyframe1 = Keyframe.ofFloat(1f, 0f);
        keyframe1.setInterpolator(new BounceInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(0f, 1f);
        keyframe2.setInterpolator(new LinearInterpolator());
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofKeyframe("alpha", keyframe1,keyframe2);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(1000).start();
    }
}
