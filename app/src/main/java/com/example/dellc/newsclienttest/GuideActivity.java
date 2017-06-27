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
    private boolean mExitActivity =false;
    private ImageView ivImg;
    private Button btnStart;
    private int index=0;  /** 当前显示的是第几张图片 */

    /** 要切换的图片 */
    private int[] mImagesRes=new int[]{
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
    protected void onDestroy() {
        super.onDestroy();
        // 退出了当前界面
        mExitActivity = true;
        // 停止播放音乐
        stopMusic();
    }



    @Override
    public void initListener() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 停止播放音乐
                stopMusic();

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

        // 开始执行动画
        startAnimation();
        // 播放背景音乐
        playMusic();

    }



    /*  private Handler mHandler = new Handler() {
          @Override   // mhandler发消息后，会执行此方法处理消息
          public void handleMessage(Message msg) {
              switch (msg.what) {
                  case 0:
                      startAnimation();
                      break;
              }
          }
      };*/
    @Override
    public void initData() {

    }

/*开始显示动画效果*/
    private void startAnimation() {
        index++;
        // 取余数
        ivImg.setBackgroundResource(mImagesRes[index%mImagesRes.length]);

        //图片恢复为原来的大小，1倍
        ivImg.setScaleX(1.0f);
        ivImg.setScaleY(1.0f);

        // 1. 渐变动画
        // ScaleAnimation

        // 2. 属性动画（sdk 3.0）
        ivImg.animate()
                // (1) 缩放
                .scaleX(1.5f)
                .scaleY(1.5f)

              // （2）平移 (translation)
//                .translationX(50)
//                .translationY(50)
//                // (3) 旋转
//                .rotation(90)
//                // (4) 透明度变化
//                .alpha(0.5f)
                .setDuration(4000)  // 动画执行时间
                .setListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                    /*     延迟1秒后发消息，发消息后，会调用mHandler的handleMessage方法，
                           此处what为0，handleMessage会根据0作判断。
                             mHandler.sendEmptyMessageDelayed(0, 2000);
                             playBackgroundMusic();*/
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // 动画执行完毕
                        if (!mExitActivity) { // 没有退出当前界面时，才执行动画
                                    startAnimation();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

    }






   /* // Activity界面显示时调用
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
    }*/

    //================背景音乐播放(begin)=======================
    private MediaPlayer mMediaPlayer;

    /** 开始播放背景音乐 */
    private void playMusic() {
        try {
       /*   1.音频资源在assaets中
            AssetFileDescriptor fileDescriptor=getAssets().openFd("new_version.mp3");
            mMediaPlayer=new MediaPlayer();
            mMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor()
                    ,0L,fileDescriptor.getLength());*/

            //2.音频资源在raw中
            mMediaPlayer = MediaPlayer.create(this, R.raw.new_version);
            mMediaPlayer.setLooping(true);       // 循环播放
            mMediaPlayer.setVolume(1.0f,1.0f);  // 左声道音量 右声道音量float范围： 0-1
         //   mMediaPlayer.prepare();             // 如果音频资源在assaets中:缓冲文件
            mMediaPlayer.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** 停止播放背景音乐 */
    private void stopMusic() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            // mMediaPlayer.reset();
            mMediaPlayer.release();     // 释放资源
            mMediaPlayer = null;
        }
    }

    //================背景音乐播放(end)=========================

}
