package com.lazyxu.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.lazyxu.animation.databinding.ActivityMainBinding;
import com.lazyxu.animation.transitionsanimation.ConstraintLayoutDetailActivity;
import com.lazyxu.animation.transitionsanimation.TransitionsMainActivity;

/**
 * Created by Administrator on 2017/5/16.
 */

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mDataBinding.btnFrameanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FrameAnimationctivity.class));
            }
        });
        mDataBinding.btnTweenanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TweenAnimationActivity.class));
            }
        });
        mDataBinding.btnPropertyanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PropertyAnimationActivity.class));
            }
        });
        mDataBinding.btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LayoutTransitionActivity.class));
            }
        });
        mDataBinding.btnClanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TransitionsMainActivity.class));
            }
        });
        mDataBinding.btnConstrain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 1);
                startActivity(intent);
            }
        });
        mDataBinding.btnConstrain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 2);
                startActivity(intent);
            }
        });
        mDataBinding.btnConstrain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 3);
                startActivity(intent);
            }
        });
        mDataBinding.btnConstrain4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 4);
                startActivity(intent);
            }
        });
        mDataBinding.btnConstrain5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 5);
                startActivity(intent);
            }
        });
        mDataBinding.btnConstrain6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutDetailActivity.class);
                intent.putExtra("KEY", 6);
                startActivity(intent);
            }
        });
    }
}
