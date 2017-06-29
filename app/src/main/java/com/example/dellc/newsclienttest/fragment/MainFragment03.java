package com.example.dellc.newsclienttest.fragment;

import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.base.URLManager;
import com.example.dellc.newsclienttest.bean.VideoEntity;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by dellc on 2017/6/27.
 */

public class MainFragment03 extends BaseFragment {
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main_03;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        getVideoDatas();

    }
    /**
     * 获取服务器视频列表数据
     *
     */
    private void getVideoDatas() {
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, URLManager.VideoURL, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                System.out.println("----服务器返回的json数据:" + json);

                // （2）解析json数据
                // 替换json字符串中的新闻类别id
                json=json.replace("V9LG4B3A0","result");
                Gson gson=new Gson();       // 使用到反射  fastjson

                VideoEntity videoEntity=gson.fromJson(json,VideoEntity.class);
                System.out.println("----解晰json数据:" +videoEntity.getResult().size()+"个视频");

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
                System.out.println("----服务器返回的:" + error);

            }
        });
    }

            @Override
    protected void initData() {

    }
}
