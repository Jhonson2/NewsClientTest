package com.example.dellc.newsclienttest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dellc on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment{
    private View mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = LayoutInflater.from(getContext())
                    .inflate(getLayoutRes(), container, false);

            initView();
            initListener();
            initData();
        }
        return mRoot;
        
    }
    /** 返回一个Fragment要显示的布局界面 */
    protected abstract int getLayoutRes();

    /** 设置控件的监听器 */
    protected abstract void initListener();


    /** 查找布局中的子控件 */
    protected abstract void initView();

    /** 初始化数据 */
    protected abstract void initData();
}
