package com.example.dellc.newsclienttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.dellc.newsclienttest.fragment.MainFragment01;
import com.example.dellc.newsclienttest.fragment.MainFragment02;
import com.example.dellc.newsclienttest.fragment.MainFragment03;
import com.example.dellc.newsclienttest.fragment.MainFragment04;
import com.example.dellc.newsclienttest.fragment.MainFragment05;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;



    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);
        initViewPager();
    }

    private void initViewPager() {
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        final List<Fragment> fragments=new ArrayList<>();
        fragments.add(new MainFragment01());
        fragments.add(new MainFragment02());
        fragments.add(new MainFragment03());
        fragments.add(new MainFragment04());
        fragments.add(new MainFragment05());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
    public void initListener() {
    }

    @Override
    public void initData() {
    }
}
