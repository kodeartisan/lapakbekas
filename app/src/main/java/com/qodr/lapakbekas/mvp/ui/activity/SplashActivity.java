package com.qodr.lapakbekas.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    public static final String TAG = SplashActivity.class.getSimpleName();

    @BindView(R.id.iv_logo)
    ImageView mIvLogo;

    @Override
    protected void initData() {

    }

    @Override
    public void initDagger() {

    }

    @Override
    public void initViewsAndListener() {
        initAnimation();
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initToolbar() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mIvLogo.startAnimation(animation);
    }
}
