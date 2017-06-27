package com.example.dellc.newsclienttest.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dellc.newsclienttest.BaseActivity;
import com.example.dellc.newsclienttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellc on 2017/6/27.
 */

public class MainFragment01 extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main_01;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        tabLayout= (TabLayout) mRootView.findViewById(R.id.tab_layout);
        viewPager= (ViewPager) mRootView.findViewById(R.id.view_pager_02);
        initViewPager();


    }
        //显示Viewpager和TabLayout
    private void initViewPager() {
        final String[] titles = new String[] {
                "头条", "社会", "科技", "财经", "体育", "汽车"
        };

        final String[] channelId = new String[] {
                "T1348647909107",
                "T1348648037603",
                "T1348649580692",
                "T1348648756099",
                "T1348649079062",
                "T1348654060988",
        };

        //创建新闻的6个fragment
        final List<Fragment> fragments = new ArrayList<>();
        //通过循环fragments遍历
        for (int i = 0; i < titles.length; i++) {
            NewsItemFragment fragment = new NewsItemFragment();
           //设置新闻类别id
            fragment.setChannelId(channelId[i]);
            fragments.add(fragment);
        }

        viewPager.setAdapter(new FragmentPagerAdapter(
                getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
