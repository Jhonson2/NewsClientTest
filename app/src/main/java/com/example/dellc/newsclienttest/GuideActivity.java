package com.example.dellc.newsclienttest;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
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
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterMainActivity();
            }
        });

    }
/*跳转到MainActivity主页面*/
    private void enterMainActivity() {
        Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
    }

    @Override
    public void initView() {
        btnStart= (Button) findViewById(R.id.btn_start);
        ivImg= (ImageView) findViewById(R.id.iv_img);

    }

    @Override
    public void initData() {
        startAnimation();     //开始显示动画效果

    }
/*开始显示动画效果*/
    private void startAnimation() {
        ivImg.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(3000);

    }
}
