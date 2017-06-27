package com.example.dellc.newsclienttest.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by dellc on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment{
    protected View mRootView;
    protected Activity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = LayoutInflater.from(getContext())
                    .inflate(getLayoutRes(), container, false);

            initView();
            initListener();
            initData();
        }
        return mRootView;
        
    }
    /** 返回一个Fragment要显示的布局界面 */
    protected abstract int getLayoutRes();

    /** 设置控件的监听器 */
    protected abstract void initListener();


    /** 查找布局中的子控件 */
    protected abstract void initView();

    /** 初始化数据 */
    protected abstract void initData();

    private Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mActivity, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
