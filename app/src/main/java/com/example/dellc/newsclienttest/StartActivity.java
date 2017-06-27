package com.example.dellc.newsclienttest;

import android.content.Intent;
import android.os.SystemClock;

import com.example.dellc.newsclienttest.util.SharedPrefUtil;

/**
 * Created by dellc on 2017/6/26.
 */

public class StartActivity extends BaseActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new Thread() {
                    public void run() {
                        SystemClock.sleep(1500);

                       // 如果是第一次启动，则从StartActivity 进入 GuildeActivity,再进入MainActivity.

                        // 读取不到key为firstRun的值，则默认返回true，表示第一次启动应用
                        boolean firstRun = SharedPrefUtil.getBoolean(
                                getApplicationContext(), "firstRun", true);
                        if (firstRun) {
                            SharedPrefUtil.saveBoolean(StartActivity.this,
                                    "firstRun", false);
                            enterGuideActivity();
                        } else {
                            //如果不是第一次启动，则从StartActivity 直接进入MainActivity.
                            enterMainActivity();
                        }
                    }
                }.start();
    }

    /* 进入MainActivity*/
    private void enterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
/* 进入guideActivity*/
    private void enterGuideActivity() {
        Intent intent=new Intent(this,GuideActivity.class);
        startActivity(intent);
        finish();
    }
}
