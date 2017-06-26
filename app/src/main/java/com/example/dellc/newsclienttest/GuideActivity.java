package com.example.dellc.newsclienttest;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by dellc on 2017/6/26.
 */

public class GuideActivity extends BaseActivity {
    private boolean isExist=false;
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
    public int getLayoutRes() {
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
                        //playBackgroundMusic();
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

    private MediaPlayer mMediaPlayer;
    /** 循环播放背景音乐 */


    private void playBackgroundMusic() {
        try {
            AssetFileDescriptor fileDescriptor=getAssets().openFd("new_version.mp3");
            mMediaPlayer=new MediaPlayer();
            mMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor()
                    ,0L,fileDescriptor.getLength());

            mMediaPlayer.setLooping(true);       // 循环播放
            mMediaPlayer.setVolume(1.0f,1.0f);  // 左声道音量 右声道音量float范围： 0-1
            mMediaPlayer.prepare();             // 如果音频资源在assaets中:缓冲文件
            mMediaPlayer.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Activity界面显示时调用
    @Override
    protected void onStart() {
        super.onStart();
        //开始播放bgm
        playBackgroundMusic();
    }


    // Activity界面退出时调用
    @Override
    protected void onStop() {
        super.onStop();
        // 释放MediaPlayer资源
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!isExist){

        }
    }
}
