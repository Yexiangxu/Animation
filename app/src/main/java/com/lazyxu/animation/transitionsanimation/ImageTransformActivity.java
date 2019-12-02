package com.lazyxu.animation.transitionsanimation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.lazyxu.animation.R;
import com.lazyxu.animation.databinding.ActivityImagetransformBinding;

/**
 * Created by Administrator on 2017/9/6.
 */

public class ImageTransformActivity extends AppCompatActivity {
    private ActivityImagetransformBinding mDataBinding;
    private boolean mAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_imagetransform);
    }

    public void show(View view) {
        mAnimation = !mAnimation;
        TransitionManager.beginDelayedTransition(mDataBinding.transitionsContainer, new TransitionSet()
                .addTransition(new ChangeBounds())
                .addTransition(new ChangeImageTransform()));
        ViewGroup.LayoutParams params = mDataBinding.image.getLayoutParams();
        params.height = mAnimation ? ViewGroup.LayoutParams.MATCH_PARENT : dp2px(150);
        mDataBinding.image.setLayoutParams(params);
    }

    public int dp2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
