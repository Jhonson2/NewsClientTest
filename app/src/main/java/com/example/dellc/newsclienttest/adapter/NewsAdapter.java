package com.example.dellc.newsclienttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.bean.NewsEntity;

import java.util.List;

/**
 * Created by dellc on 2017/6/28.
 */

public final class NewsAdapter extends BaseAdapter {
    private Context context;

    /*列表显示的新闻显示*/
    private List<NewsEntity.ResultBean> listDatas;

    public NewsAdapter(Context context,List<NewsEntity.ResultBean> listDatas){
        this.context=context;
        this.listDatas=listDatas;
    }

    //有多少的列表项
    @Override
    public int getCount() {
        return (listDatas==null) ? 0:listDatas.size();
    }

    //返回指定位置的列表项的实体数据
    @Override
    public NewsEntity.ResultBean getItem(int position) {
        return listDatas.get(position);
    }

    //返回指定位置
    @Override
    public long getItemId(int position) {
        return position;
    }

    //返回列表项视图，只要显示列表项时，就会调用此方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1 创建列表项的item视图
        if(convertView==null){
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.item_news_1,parent,false);
        }

        // 2 查找列表item中的子控件
        ImageView ivIcon= (ImageView) convertView.findViewById(R.id.iv_icon);
        TextView tvTitle= (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvSource= (TextView) convertView.findViewById(R.id.tv_source);
        TextView tvComment= (TextView) convertView.findViewById(R.id.tv_comment);

        //3 获取列表项的对应数据（javabean）
        NewsEntity.ResultBean info=getItem(position);

        // 4 显示列表item中的子控件
        tvTitle.setText(info.getTitle());
        tvSource.setText(info.getSource());
        tvComment.setText(info.getReplyCount()+"跟帖");

        return convertView;
    }
}
