package com.example.dellc.newsclienttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.bean.VideoEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 视频列表适配器
 * Created by dellc on 2017/6/29.
 */

public class VideoAdapter extends RecyclerView.Adapter {
    private Context context;

    /**
     * 列表数据集合
     */
    private List<VideoEntity.ResultBean> listDatas;


    // 构造方法
    public VideoAdapter(Context context, List<VideoEntity.ResultBean> listDatas) {
        this.context = context;
        this.listDatas = listDatas;
    }

    // 创建列表项, 返回ViewHolder
    // ViewHolder: 避免每次都findViewById查找子控件，
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建列表项
        View itemView = LayoutInflater.from(context).inflate(
                R.layout.item_video, parent, false);

        // 创建ViewHolder，并返回
        return new MyViewHolder(itemView);
    }

    // 刷新列表项中的子控件
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;

        // 列表项对应的数据
        VideoEntity.ResultBean video = listDatas.get(position);

        // 显示列表项中的子控件
            //1 显示视频标题
        holder.tvVideoTitle.setText(video.getTitle());
            //2 显示视频播放时长
        String duration = video.getLength() / 60 + "分" + video.getLength() % 60 + "秒";
        holder.tvVideoDuration.setText(duration);
            //3 显示视频预览图片
        Picasso.with(context).load(video.getCover()).into(holder.ivVideoImage);

        // 设置列表项点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 有多少个列表项
    @Override
    public int getItemCount() {
        return (listDatas == null) ? 0 : listDatas.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivVideoImage;
        private TextView tvVideoTitle;
        private TextView tvVideoDuration;
        private TextView tvPlayCount;


        public MyViewHolder(View itemView) {
            super(itemView);

            ivVideoImage = (ImageView) itemView.findViewById(R.id.iv_video_image);
            tvVideoTitle = (TextView) itemView.findViewById(R.id.tv_video_title);
            tvVideoDuration = (TextView) itemView.findViewById(R.id.tv_video_duration);
            tvPlayCount = (TextView) itemView.findViewById(R.id.tv_play_count);
        }
    }
}