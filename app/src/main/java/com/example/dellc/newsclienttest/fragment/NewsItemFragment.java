package com.example.dellc.newsclienttest.fragment;

import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.dellc.newsclienttest.R;
import com.example.dellc.newsclienttest.adapter.NewsAdapter;
import com.example.dellc.newsclienttest.base.URLManager;
import com.example.dellc.newsclienttest.bean.NewsEntity;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
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
    private NewsAdapter newsAdapter;
    private SpringView springView;
    private List<NewsEntity.ResultBean> listDatas;
    private View headerView;

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
        listView= (ListView) mRootView.findViewById(R.id.list_view);
        textView.setText("类别id："+channelId);

        newsAdapter=new NewsAdapter(getContext(),null);
        listView.setAdapter(newsAdapter);


        initSpringView();


    }
        /*显示下拉和加载更多*/
    private void initSpringView() {
        springView= (SpringView) mRootView.findViewById(R.id.spring_view);

        //设置springView的头部和尾部
        springView.setHeader(new MeituanHeader(getContext()));
        springView.setFooter(new MeituanFooter(getContext()));

        springView.setType(SpringView.Type.FOLLOW);

        //设置监听器
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {       //下拉刷新第一页
               // showToast("下拉刷新");

                //请求服务器数据。。。刷新第一页
                //。。。。
                getDataFromServer(true);
            }

            //请求服务器数据。。。加载下一页
            //。。。

            @Override
            public void onLoadmore() {         //上拉加载下一页
                //showToast("上拉加载下一页");
                getDataFromServer(false);
            }
        });
    }

    @Override
    protected void initData() {
        // 获取服务器新闻数据
        getDataFromServer(true);

    }
    /** 要加载第几页数据 默认第一页*/
    private int pageNo = 1;

    /**
     * 获取服务器新闻数据
     *
     * @param refresh true表示下拉刷新，false表示加载下一页数据
     *
     */
    private void getDataFromServer(final boolean refresh) {
        if (refresh)  // 如果是下拉刷新
            pageNo = 1;

        String newsUrl = URLManager.getUrl(channelId,pageNo);

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
                 listDatas=newsDatas.getResult();


                //（3） 显示数据到列表中(数据 列表项 适配器)
                if (refresh) {  // 下拉刷新
                    showDatas(listDatas);

                } else {        // 上拉加载下一页数据
                    newsAdapter.appendDatas(listDatas);
                }
                pageNo++;       // 页码自增1

                //  隐藏SpringView的下拉和上拉显示
                springView.onFinishFreshAndLoad();

            }

            @Override//获取失败
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
                System.out.println("----服务器返回失败:" + msg);
            }
        });
    }

    private void showDatas(List<NewsEntity.ResultBean> listDatas) {
        if (listDatas == null
                || listDatas.size() == 0) {
            System.out.println("----没有获取到服务器的新闻数据");
            return;
        }
        //  (1)显示轮播图
        //取出轮播图显示的数据作为：第一条新闻数据
        List<NewsEntity.ResultBean.AdsBean> ads
                =listDatas.get(0).getAds();

        //轮播图广告
        if(ads !=null && ads.size() >0){
            View headerView= LayoutInflater.from(getContext())
                    .inflate(R.layout.list_header,listView,false);

            //查找轮播图控件
            SliderLayout sliderLayout=
                    (SliderLayout) headerView.findViewById(R.id.sliding_layout);

            //通过循环取出轮播图显示的数据
            for (int i = 0; i < ads.size(); i++) {
                NewsEntity.ResultBean.AdsBean adBean = ads.get(i);
                TextSliderView sliderView=new TextSliderView(getContext());

                sliderView.description(adBean.getTitle())   //获取轮播图的标题
                .image(adBean.getImgsrc());                 //获取轮播图的图片

                // 添加子界面
                sliderLayout.addSlider(sliderView);

                // 设置点击事件
                sliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        showToast(slider.getDescription());
                    }
                });
            }
            // 添加列表头部布局
            listView.addHeaderView(headerView);

        }else{//没有轮播图情况

        }



        //（2）显示新闻列表
         newsAdapter.setDatas(listDatas);       // 重置列表的数据，刷新列表显示



    }
}
