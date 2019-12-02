package com.lazyxu.animation.transitionsanimation;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.lazyxu.animation.R;

/**
 * Created by Administrator on 2017/6/27.
 */

public class ConstraintLayoutDetailActivity extends AppCompatActivity {
	private ConstraintLayout constraintLayout;
	private ConstraintSet applyConstraintSet = new ConstraintSet();
	private ConstraintSet resetConstraintSet = new ConstraintSet();
	private int position=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cldetail);
		position=getIntent().getIntExtra("KEY",0) ;
		constraintLayout = (ConstraintLayout) findViewById(R.id.main);
		resetConstraintSet.clone(constraintLayout);
		applyConstraintSet.clone(constraintLayout);
	}


	public void onApplyClick(View view) {
		switch (position){
			case 1://button1移动到marginstart=0处（所有跟button1位置相关联的控件随button1的移动而移动 ）
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.setMargin(R.id.button1,ConstraintSet.TOP,0);
				applyConstraintSet.applyTo(constraintLayout);
				break;
			case 2://设置居中先把margin消除
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.setMargin(R.id.button1,ConstraintSet.START,0);
				applyConstraintSet.setMargin(R.id.button1,ConstraintSet.END,0);
				applyConstraintSet.setMargin(R.id.button2,ConstraintSet.START,0);
				applyConstraintSet.setMargin(R.id.button2,ConstraintSet.END,0);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.START,0);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.END,0);
				applyConstraintSet.centerHorizontally(R.id.button1, R.id.main);
				applyConstraintSet.centerHorizontally(R.id.button2, R.id.main);
				applyConstraintSet.centerHorizontally(R.id.button3, R.id.main);
				applyConstraintSet.applyTo(constraintLayout);
				break;
			case 3://设置某个控件整体居中
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.START,0);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.END,0);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.TOP,0);
				applyConstraintSet.setMargin(R.id.button3,ConstraintSet.BOTTOM,0);
				applyConstraintSet.centerHorizontally(R.id.button3, R.id.main);
				applyConstraintSet.centerVertically(R.id.button3, R.id.main);
				applyConstraintSet.applyTo(constraintLayout);
				break;
			case 4:  //设置某个控件宽度拉伸
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.constrainWidth(R.id.button1,600); //设置宽，高度设置方法constrainHeight
				applyConstraintSet.applyTo(constraintLayout);
				break;
			case 5:
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.setVisibility(R.id.button2,ConstraintSet.GONE);
				applyConstraintSet.setVisibility(R.id.button3,ConstraintSet.GONE);
				applyConstraintSet.clear(R.id.button1);//把 view 上的所有 constraint 都清除掉
				applyConstraintSet.connect(R.id.button1,ConstraintSet.LEFT,R.id.main,ConstraintSet.LEFT,0);
				applyConstraintSet.connect(R.id.button1,ConstraintSet.RIGHT,R.id.main,ConstraintSet.RIGHT,0);
				applyConstraintSet.connect(R.id.button1,ConstraintSet.TOP,R.id.main,ConstraintSet.TOP,0);
				applyConstraintSet.connect(R.id.button1,ConstraintSet.BOTTOM,R.id.main,ConstraintSet.BOTTOM,0);
				applyConstraintSet.applyTo(constraintLayout);
				break;
			case 6:
				TransitionManager.beginDelayedTransition(constraintLayout);
				applyConstraintSet.clear(R.id.button1);//清除所有的约束(包括宽高、边距，全部设置为0)
				applyConstraintSet.clear(R.id.button2);
				applyConstraintSet.clear(R.id.button3);
				// button 1 left and top align to parent
				applyConstraintSet.connect(R.id.button1, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0);
				// button 3 right and top align to parent
				applyConstraintSet.connect(R.id.button3, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0);
				// bi-direction or Chaining between button 1 and button 2
				applyConstraintSet.connect(R.id.button2, ConstraintSet.LEFT, R.id.button1, ConstraintSet.RIGHT, 0);
				applyConstraintSet.connect(R.id.button1, ConstraintSet.RIGHT, R.id.button2, ConstraintSet.LEFT, 0);
				// bi-direction or Chaining between button 2 and button 3
				applyConstraintSet.connect(R.id.button2, ConstraintSet.RIGHT, R.id.button3, ConstraintSet.LEFT, 0);
				applyConstraintSet.connect(R.id.button3, ConstraintSet.LEFT, R.id.button2, ConstraintSet.RIGHT, 0);
				applyConstraintSet.createHorizontalChain(R.id.button1, ConstraintSet.LEFT, R.id.button3,  ConstraintSet.RIGHT,
						new int[]{R.id.button1,R.id.button2, R.id.button3},
						null, ConstraintWidget.CHAIN_PACKED);
				applyConstraintSet.constrainWidth(R.id.button1,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.constrainWidth(R.id.button2,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.constrainWidth(R.id.button3,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.constrainHeight(R.id.button1,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.constrainHeight(R.id.button2,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.constrainHeight(R.id.button3,ConstraintSet.WRAP_CONTENT);
				applyConstraintSet.applyTo(constraintLayout);
				break;
		}

	}

	public void onResetClick(View view) {
		TransitionManager.beginDelayedTransition(constraintLayout);
		resetConstraintSet.applyTo(constraintLayout);
	}
}


