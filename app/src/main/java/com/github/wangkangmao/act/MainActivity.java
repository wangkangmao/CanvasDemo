package com.github.wangkangmao.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.wangkangmao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_rect)
    Button btnRect;
    @BindView(R.id.btn_cicle)
    Button btnCicle;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_rect)
    public void rectClick() {
        startActivity(new Intent(MainActivity.this, RectSufceViewActivity.class));
    }

    @OnClick(R.id.btn_cicle)
    public void cicleClick() {
        startActivity(new Intent(MainActivity.this, RandomCicleActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
