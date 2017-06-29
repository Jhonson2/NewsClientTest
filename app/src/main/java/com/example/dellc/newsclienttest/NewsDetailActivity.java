package com.example.dellc.newsclienttest;

import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
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
        // 支持javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);

        // 禁止使用外部的浏览器打开网页
        webView.setWebViewClient(new WebViewClient(){
            @Override  // 网页加载完成
            public void onPageFinished(WebView view, String url) {
                System.out.println("------onPageFinished");
                super.onPageFinished(view, url);
            }
        });


    }

    @Override
    public void initData() {
        // 上一个界面传过来的新闻数据
        NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean)
                getIntent().getSerializableExtra("news");

        String newUrl = newsBean.getUrl();
        System.out.println("----------" + newUrl);
        webView.loadUrl(newUrl);        // 显示新闻网页数据

        // 显示标题栏左上角的返回图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 显示标题栏
        getSupportActionBar().setTitle(newsBean.getTitle());
    }


       @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                finish();   // 标题栏左上角的返回按钮，退出当前界面
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


}
