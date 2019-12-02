package com.lazyxu.animation.transitionsanimation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.transition.TransitionManager;

import com.lazyxu.animation.R;
import com.lazyxu.animation.databinding.ActivityRotateBinding;
import com.transitionseverywhere.Rotate;

/**
 * Created by Administrator on 2017/9/6.
 */

public class RotateActivity extends AppCompatActivity {
    private ActivityRotateBinding mDataBinding;
    private boolean mAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_rotate);
    }

    public void show(View view) {
        mAnimation = !mAnimation;
        TransitionManager.beginDelayedTransition(mDataBinding.transitionsContainer, new Rotate());
        mDataBinding.ivIcon.setRotation(mAnimation ? 135 : 0);
    }
}
