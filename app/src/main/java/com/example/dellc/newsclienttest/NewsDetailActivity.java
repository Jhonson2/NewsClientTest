package com.example.dellc.newsclienttest;

import android.provider.Settings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dellc.newsclienttest.bean.NewsEntity;

/**
 * Created by dellc on 2017/6/29.
 */

public class NewsDetailActivity extends BaseActivity {
    private WebView webView;
    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {
        initWebView();

    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_view);

    }

    @Override
    public void initData() {
        // 上一个界面传过来的新闻数据
        NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean)
                getIntent().getSerializableExtra("news");

        String newUrl = newsBean.getUrl();
        System.out.println("----------"+newUrl);
        webView.loadUrl(newUrl);        // 显示新闻网页数据

        // 显示标题栏
        getSupportActionBar().setTitle(newsBean.getTitle());
    }
}
