package com.example.dellc.newsclienttest.fragment;

import android.provider.Settings;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.adapter.NewsAdapter;
import com.example.dellc.newsclienttest.base.URLManager;
import com.example.dellc.newsclienttest.bean.NewsEntity;
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

public class NewsItemFragment extends BaseFragment{
    private TextView textView;
    private ListView listView;

    /** 新闻类别id */
    private String channelId;

    /*设置新闻类别id*/
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        textView= (TextView) mRootView.findViewById(R.id.tv_01);
        textView.setText("类别id："+channelId);

        listView= (ListView) mRootView.findViewById(R.id.list_view);


    }

    @Override
    protected void initData() {
        getDataFromServer();

    }
    // 请求服务器获取页签详细数据
    private void getDataFromServer() {

        String newsUrl = URLManager.getUrl(channelId);

        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, newsUrl, new RequestCallBack<String>() {

            @Override// 获取成功
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //（1）从服务器返回json数据
                String json=responseInfo.result;
                System.out.println("----服务器返回的json数据:" + json);

                //（2）解析json数据
                    //替换还本的新闻列表类别id
                json =  json.replace(channelId, "result");
                Gson gson=new Gson();

                NewsEntity newsDatas=gson.fromJson(json, NewsEntity.class);
                System.out.println("----解析json:" + newsDatas.getResult().size()+"条数据");
                //列表显示集合
                List<NewsEntity.ResultBean> listDatas=newsDatas.getResult();


                //（3） 显示数据到列表中(数据 列表项 适配器)
                showDatas(newsDatas);
            }

            @Override//获取失败
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
                System.out.println("----服务器返回失败:" + msg);
            }
        });
    }

    private void showDatas(NewsEntity newsDatas) {
        if (newsDatas == null
                || newsDatas.getResult() == null
                || newsDatas.getResult().size() == 0) {
            System.out.println("----没有获取到服务器的新闻数据");
            return;
        }
        //  (1)显示轮播图

        //（2）显示新闻列表
        NewsAdapter newsAdapter=new NewsAdapter(
                mActivity,newsDatas.getResult());

        listView.setAdapter(newsAdapter);



    }
}
