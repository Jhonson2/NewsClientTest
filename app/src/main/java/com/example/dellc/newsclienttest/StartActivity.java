package com.example.dellc.newsclienttest;

import android.content.Intent;
import android.os.SystemClock;

/**
 * Created by dellc on 2017/6/26.
 */

public class StartActivity extends BaseActivity {

    @Override
    public int getLyoutRes() {
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
                        //进入guideActivity
                        enterGuideActivity();
                    }
                }.start();
    }

/* 进入guideActivity*/
    private void enterGuideActivity() {
        Intent intent=new Intent(this,GuideActivity.class);
        startActivity(intent);
        finish();
    }
}
