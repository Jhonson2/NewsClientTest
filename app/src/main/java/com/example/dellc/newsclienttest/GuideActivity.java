package com.example.dellc.newsclienttest;

import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by dellc on 2017/6/26.
 */

public class GuideActivity extends BaseActivity {
    private ImageView ivImg;
    private Button btnStart;

    @Override
    public int getLyoutRes() {
        return R.layout.activity_guide;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        btnStart= (Button) findViewById(R.id.btn_start);
        ivImg= (ImageView) findViewById(R.id.iv_img);

    }

    @Override
    public void initData() {

    }
}
