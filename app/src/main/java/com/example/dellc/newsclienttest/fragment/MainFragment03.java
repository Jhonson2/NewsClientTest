package com.example.dellc.newsclienttest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.adapter.VideoAdapter;
import com.example.dellc.newsclienttest.base.URLManager;
import com.example.dellc.newsclienttest.bean.VideoEntity;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by dellc on 2017/6/27.
 */

public class MainFragment03 extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main_03;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);
    }

    @Override
    protected void initData() {
        getVideoDatas();

    }
    /**
     * 获取服务器视频列表数据
     *
     */
    private void getVideoDatas() {
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, URLManager.VideoURL, new RequestCallBack<String>() {

            @Override// 请求成功
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                System.out.println("----服务器返回的json数据:" + json);

                // （2）解析json数据
                // 替换json字符串中的新闻类别id
                json=json.replace("V9LG4B3A0","result");
                Gson gson=new Gson();       // 使用到反射  fastjson

                VideoEntity videoEntity=gson.fromJson(json,VideoEntity.class);
                System.out.println("----解晰json数据:" +videoEntity.getResult().size()+"个视频");

                // 列表显示的数据
                List<VideoEntity.ResultBean> listDatas = videoEntity.getResult();

                // （3）显示列表(RecyclerView: 列表，网格，瀑布流)
                // RecyclerView: 列表数据，列表项布局， 适配器
               showRecyclerView(listDatas);
            }

            @Override        // 请求失败
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
                System.out.println("----服务器返回的:" + error);

            }
        });
    }
    /** 显示列表RecyclerView */
    private void showRecyclerView(List<VideoEntity.ResultBean> listDatas) {
        // 设置列表布局管理器-----LinearLayoutManager线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        VideoAdapter videoAdapter = new VideoAdapter(getContext(), listDatas);
        recyclerView.setAdapter(videoAdapter);

    }


}
