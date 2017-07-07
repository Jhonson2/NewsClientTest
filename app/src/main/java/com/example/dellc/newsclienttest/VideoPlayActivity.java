package com.example.dellc.newsclienttest;

import android.media.MediaPlayer;
import android.widget.VideoView;

/**
 * /**
 * 视频播放界面
 * Created by dellc on 2017/7/7.
 */

public class VideoPlayActivity extends BaseActivity {
    /**
     *视频播放控件
     */
    private VideoView videoView;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_video;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        videoView = (VideoView) findViewById(R.id.video_view);

    }

    @Override
    public void initData() {
        //接受 主界面传过来的视频url的 (传递意图)
        String videoUrl = getIntent().getStringExtra("video_url");
        System.out.println("---------"+videoUrl);
        // 设置视频播放路径 使用VideoView播放视频
        videoView.setVideoPath(videoUrl);
        // 设置监听器，监听缓冲完成
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();  // 缓冲完成后，开始播放视频
            }
        });
    }
}
