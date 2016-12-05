package com.github.wangkangmao.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.wangkangmao.view.RectSurfaceView;

/**
 * Created by wangkangmao on 2016/12/5.
 */

public class RectSufceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RectSurfaceView(this));
    }

}

