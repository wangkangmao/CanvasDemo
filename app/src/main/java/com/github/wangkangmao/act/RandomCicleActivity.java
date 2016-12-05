package com.github.wangkangmao.act;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.wangkangmao.R;
import com.github.wangkangmao.entity.CircleInfo;
import com.github.wangkangmao.view.CircleCanvasView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangkangmao on 2016/12/5.
 */

public class RandomCicleActivity extends AppCompatActivity {


    @BindView(R.id.relativelayout)
    RelativeLayout relativelayout;
    private CircleCanvasView mCircleCanvasView;
    private Random mRandom;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_cicle);
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mCircleCanvasView = new CircleCanvasView(this);
        relativelayout.addView(mCircleCanvasView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }


    public void initData() {
        /**
         * 获取屏幕的宽和高
         */
        final int width = getWindowManager().getDefaultDisplay().getWidth();
        final int height = getWindowManager().getDefaultDisplay().getHeight();

        new Thread() {
            @Override
            public void run() {
                super.run();
                mRandom = new Random();
                for (int i = 0; i < 30; i++) {
                    SystemClock.sleep(1000);
                    //随机生成圆的坐标和半径
                    float x = (float) (mRandom.nextInt(width));
                    float y = (float) (mRandom.nextInt(height));
                    float radius = (float) (20 + mRandom.nextInt(100));

                    //设置生成圆的颜色
                    int color = randomColor();
                    CircleInfo circleInfo = new CircleInfo();
                    circleInfo.setX(x);
                    circleInfo.setY(y);
                    circleInfo.setRadius(radius);
                    circleInfo.setColor(color);
                    mCircleCanvasView.mCircleInfoList.add(circleInfo);
                    mCircleCanvasView.postInvalidate();


                }
            }
        }.start();
    }

    private int randomColor() {
        //如果值太大，会偏白，太小会偏黑，所以要对颜色的值进行范围限定
        int red = mRandom.nextInt(150) + 50;//50-199
        int green = mRandom.nextInt(150) + 50;//50-199
        int blue = mRandom.nextInt(150) + 50;//50-199
        return Color.rgb(red, green, blue);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
