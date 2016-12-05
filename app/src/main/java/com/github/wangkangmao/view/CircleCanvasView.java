package com.github.wangkangmao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.github.wangkangmao.entity.CircleInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkangmao on 2016/12/5.
 */

public class CircleCanvasView extends View {

    //用于保存已经新建圆的信息
    public List<CircleInfo> mCircleInfoList = new ArrayList<>();

    public CircleCanvasView(Context context) {
        super(context);
    }

    public CircleCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init(canvas);
    }

    private void init(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true); //出去锯齿效果
        //根据保存的圆对象，开始绘制
        for (int i = 0; i < mCircleInfoList.size(); i++) {
            CircleInfo circleInfo = mCircleInfoList.get(i);

            //设置画笔的颜色
            paint.setColor(circleInfo.getColor());
            //绘制实心圆
            canvas.drawCircle(circleInfo.getX(),circleInfo.getY(),circleInfo.getRadius(),paint);
        }
    }
}
