package com.github.wangkangmao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wangkangmao on 2016/12/5.
 */

public class RectSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    //创建画笔对象
    Paint mPaint = new Paint();
    private Timer mTimer;
    private TimerTask mTask;
    //定义并初始化要绘制的图形的坐标
    private float x = 0;
    private float y = 0;
    private float speedx = 50;
    private float speedy = 50;
    //定义并初始化坐标一定的变化量
    private float addx = 50;
    private float addy = 20;

    public RectSurfaceView(Context context) {
        super(context);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true); //去除锯齿效果
        getHolder().addCallback(this);//holder回调
    }

    /**
     * 启动定时后台线程
     */
    private void startTimer() {
        mTimer = new Timer();
        mTask = new TimerTask() {

            @Override
            public void run() {
                //在定时器中调用绘制方法
                draw();
            }
        };
        // 设置定时器每隔0.1秒启动这个任务
        mTimer.schedule(mTask, 100, 100);
    }

    /**
     * 定时定时器线程
     */
    private void stopTimer() {
        mTimer.cancel();
    }

    private void draw() {
        //锁定画布
        Canvas canvas = getHolder().lockCanvas();
        //初始化画布
        canvas.drawColor(Color.WHITE);
        //绘制一个矩形
        canvas.drawRect(x, y, x + speedx, y + speedy, mPaint);
        x += addx;
        y += addy;
        //设计矩形的移动路径
        if (x < 0) {
            //如果图形左边界面坐标超出屏幕则向右移动
            addx = Math.abs(addx);
        }
        if (x > getWidth() - speedx) {
            //如果图形右面界面超出屏幕的宽度则想做移动
            addx = -Math.abs(addx);
        }
        if (y < 0) {
            addy = Math.abs(addy);
        }
        if (y > getHeight() - speedy) {
            addy = -Math.abs(addy);

        }
        //解锁画布
        getHolder().unlockCanvasAndPost(canvas);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //在surfaceView创建后启动线程
        startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //销毁之前结束线程
        stopTimer();
    }
}
