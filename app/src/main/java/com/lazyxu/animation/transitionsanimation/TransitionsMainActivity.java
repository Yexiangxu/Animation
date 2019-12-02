package com.lazyxu.animation.transitionsanimation;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lazyxu.animation.Constants;
import com.lazyxu.animation.R;

/**
 * Created by Administrator on 2017/6/27.
 */

public class TransitionsMainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clmain);
	}
	public void show(View v) {
		switch (v.getId()){
			case R.id.btn_view_gone1:
				Intent intent1= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				intent1.putExtra(Constants.VIEW_KEY,Constants.VIEW_VISIBLE);
				startActivity(intent1);
				break;
			case R.id.btn_view_gone2:
				Intent intent2= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				intent2.putExtra(Constants.VIEW_KEY,Constants.VIEW_MOVE);
				startActivity(intent2);

				break;
			case R.id.btn_view_gone3:
				Intent intent3= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				intent3.putExtra(Constants.VIEW_KEY,Constants.VIEW_SLIDE);
				startActivity(intent3);

				break;
			case R.id.btn_view_scale:
				Intent intentScale= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				intentScale.putExtra(Constants.VIEW_KEY,Constants.VIEW_SCALE);
				startActivity(intentScale);
				break;
			case R.id.btn_image:
				startActivity(new Intent(TransitionsMainActivity.this,ImageTransformActivity.class));
				break;
			case R.id.btn_colorchange:
				Intent intentColor= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				intentColor.putExtra(Constants.VIEW_KEY,Constants.View_RECOLOR);
				startActivity(intentColor);
				break;
			case R.id.btn_textchange:
				Intent textChange= new Intent(TransitionsMainActivity.this,ViewActivity.class) ;
				textChange.putExtra(Constants.VIEW_KEY,Constants.CHANGETEXT);
				startActivity(textChange);
				break;
			case R.id.btn_rotate:
				startActivity(new Intent(TransitionsMainActivity.this,RotateActivity.class));
				break;
		}
	}


}

