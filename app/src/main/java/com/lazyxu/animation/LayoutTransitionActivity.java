package com.lazyxu.animation;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;
import android.view.*;
import android.widget.TextView;
import com.lazyxu.animation.databinding.ActivityLayouttransitionBinding;

/**
 * Created by Administrator on 2017/9/6.
 */

public class LayoutTransitionActivity extends AppCompatActivity {
	private ActivityLayouttransitionBinding mDataBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_layouttransition);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.layout_changes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_add_item:
				findViewById(android.R.id.empty).setVisibility(View.GONE);
				addItem();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void addItem() {
		//实例化一个子View
		final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.list_item_example, mDataBinding.container, false);
		// 随机设置子View的内容
		((TextView) newView.findViewById(android.R.id.text1)).setText(COUNTRIES[(int) (Math.random() * COUNTRIES.length)]);
		//设置删除按钮的监听
		newView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mDataBinding.container.removeView(newView);
				// If there are no rows remaining, show the empty view.
				if (mDataBinding.container.getChildCount() == 0) {
					findViewById(android.R.id.empty).setVisibility(View.VISIBLE);
				}
			}
		});
		//添加子View
		mDataBinding.container.addView(newView, 0);
	}
	private static final String[] COUNTRIES = new String[]{"Belgium", "France", "Italy", "Germany", "Spain", "Austria", "Russia", "Poland", "Croatia", "Greece", "Ukraine",};
}
