package com.lazyxu.animation.transitionsanimation;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.lazyxu.animation.Constants;
import com.lazyxu.animation.R;
import com.lazyxu.animation.databinding.ActivityViewVisibleBinding;
import com.transitionseverywhere.*;
import com.transitionseverywhere.extra.Scale;

/**
 * Created by Administrator on 2017/9/1.
 */

public class ViewActivity extends AppCompatActivity {
	private ActivityViewVisibleBinding mDataBinding;
	private String type = "";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_visible);
		type = getIntent().getStringExtra(Constants.VIEW_KEY);
//		switch (type) {
//			case Constants.VIEW_VISIBLE:
//				mDataBinding.linearNormal.setGravity(Gravity.CENTER);
//				mDataBinding.linearAnimation.setGravity(Gravity.CENTER);
//				break;
//
//		}
		mDataBinding.btnNormal.setOnClickListener(viewClick);
		mDataBinding.btnAnimation.setOnClickListener(viewClick);
	}

	private boolean mNormal;
	private boolean mAnimation;
	private View.OnClickListener viewClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btn_normal:
					mNormal = !mNormal;
					switch (type) {
						case Constants.VIEW_VISIBLE:
							mDataBinding.tvNormal.setVisibility(mNormal ? View.VISIBLE : View.GONE);
							break;
						case Constants.VIEW_MOVE:
							LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mDataBinding.btnNormal.getLayoutParams();
							params.gravity = mNormal ? (Gravity.RIGHT | Gravity.TOP) : (Gravity.LEFT | Gravity.TOP);
							mDataBinding.tvNormal.setLayoutParams(params);
							break;
						case Constants.VIEW_SCALE:
							TransitionManager.beginDelayedTransition(mDataBinding.linearNormal, new Scale());
							mDataBinding.tvNormal.setVisibility(mNormal ? View.VISIBLE : View.INVISIBLE);
							break;
						case Constants.View_RECOLOR:
							mDataBinding.btnNormal.setTextColor(ContextCompat.getColor(ViewActivity.this, !mNormal ? R.color.colorAccent : R.color.colorPrimary));
							mDataBinding.btnNormal.setBackgroundColor(ContextCompat.getColor(ViewActivity.this, !mNormal ? R.color.colorPrimary : R.color.colorAccent));
							break;
						case Constants.CHANGETEXT:
							mDataBinding.btnNormal.setText(mNormal ? "哈喽，我要变化了" : "嗨，我也要变化了");
							break;
					}

					break;

				case R.id.btn_animation:
					Toast.makeText(ViewActivity.this, "点击了", Toast.LENGTH_SHORT).show();
					switch (type) {
						case Constants.VIEW_VISIBLE:
							animationVisible();
							break;
						case Constants.VIEW_MOVE:
							animationMove();
							break;
						case Constants.VIEW_SLIDE:
							animationSlideRight();
							break;
						case Constants.VIEW_SCALE:
							animationScaleSet();
							break;
						case Constants.View_RECOLOR:
							colorChange();
							break;
						case Constants.CHANGETEXT:
							textChange();
							break;
					}
					break;

			}
		}
	};

	private void animationVisible() {
		mAnimation = !mAnimation;
		Transition transition = new AutoTransition();
		transition.setDuration(500);
		transition.setInterpolator(new LinearInterpolator());
		transition.setStartDelay(500);
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, transition);
		mDataBinding.tvAnimation.setVisibility(mAnimation ? View.VISIBLE : View.GONE);
	}
	private void animationMove() {
		mAnimation = !mAnimation;
		Transition transition = new ChangeBounds();
		transition.setDuration(mAnimation ? 500 : 100);
		transition.setInterpolator(mAnimation ? new FastOutSlowInInterpolator() : new AccelerateInterpolator());
		transition.setStartDelay(mAnimation ? 0 : 500);
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, transition);
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mDataBinding.btnAnimation.getLayoutParams();
		params.gravity = mAnimation ? (Gravity.RIGHT | Gravity.TOP) : (Gravity.LEFT | Gravity.TOP);
		mDataBinding.btnAnimation.setLayoutParams(params);
	}

	private void animationSlideRight() {
		mAnimation = !mAnimation;
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, new Slide(Gravity.RIGHT));
		mDataBinding.tvAnimation.setVisibility(mAnimation ? View.VISIBLE : View.GONE);
	}

	private void animationScaleSet() {
		mAnimation = !mAnimation;
		TransitionSet set = new TransitionSet()
				.addTransition(new Scale(1f))
				.addTransition(new Fade())
				.setInterpolator(mAnimation ? new LinearInterpolator() : new LinearInterpolator());
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, set);
		mDataBinding.tvAnimation.setVisibility(mAnimation ? View.VISIBLE : View.INVISIBLE);
	}

	private void colorChange() {
		mAnimation = !mAnimation;
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, new Recolor());
		mDataBinding.btnAnimation.setTextColor(ContextCompat.getColor(this, !mAnimation ? R.color.colorAccent : R.color.colorPrimary));
		mDataBinding.btnAnimation.setBackgroundColor(ContextCompat.getColor(this, !mAnimation ? R.color.colorPrimary : R.color.colorAccent));
	}
	private void textChange(){
		mAnimation = !mAnimation;
		TransitionManager.beginDelayedTransition(mDataBinding.linearAnimation, new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
		mDataBinding.btnAnimation.setText(mAnimation ? "哈喽，我要变化了" : "嗨，我也要变化了");
	}

}
