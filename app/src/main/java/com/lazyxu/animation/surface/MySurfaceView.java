package com.lazyxu.animation.surface;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static android.graphics.Color.WHITE;

/**

 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Paint paint;
    private Paint mPaint;

    public MySurfaceView(Context context) {
        this(context,null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        SurfaceHolder surfaceHolder=getHolder();
        surfaceHolder.addCallback(this);
        paint = new Paint();
        paint.setColor(WHITE);
        paint.setStyle(Paint.Style.FILL);
        //创建画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setAntiAlias(true);
//        mSrcRect = new Rect();
//        mDstRect = new Rect();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
