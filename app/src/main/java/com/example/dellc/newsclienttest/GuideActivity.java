package com.example.dellc.newsclienttest;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by dellc on 2017/6/26.
 */

public class GuideActivity extends BaseActivity {
    private ImageView ivImg;
    private Button btnStart;
    private int index=0;   //当前的第几张图片
    //引导页的多张图片
    private int[] imagesArray=new int[]{
            R.drawable.ad_new_version1_img1,
            R.drawable.ad_new_version1_img2,
            R.drawable.ad_new_version1_img3,
            R.drawable.ad_new_version1_img4,
            R.drawable.ad_new_version1_img5,
            R.drawable.ad_new_version1_img6,
            R.drawable.ad_new_version1_img7,
    };


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

    private Handler mHandler = new Handler() {
        @Override   // mhandler发消息后，会执行此方法处理消息
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    startAnimation();
                    break;
            }
        }
    };
    @Override
    public void initData() {
        startAnimation();     //开始显示动画效果

    }
/*开始显示动画效果*/
    private void startAnimation() {
        index++;
        // 取余数
        ivImg.setBackgroundResource(imagesArray[index%imagesArray.length]);

        //图片恢复为原来的大小，1倍
        ivImg.setScaleX(1.0f);
        ivImg.setScaleY(1.0f);

        ivImg.animate()
                .scaleX(1.5f)
                .scaleY(1.5f)
                .setDuration(4000)
                .setListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                        // 延迟1秒后发消息，发消息后，会调用mHandler的handleMessage方法，
                        // 此处what为0，handleMessage会根据0作判断。
                        mHandler.sendEmptyMessageDelayed(0, 2000);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

    }
}
