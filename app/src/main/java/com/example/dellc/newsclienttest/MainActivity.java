package com.example.dellc.newsclienttest;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);
        initViewPager();
        initNavigationView();
        initToolbar();
    }

    // 使用toolBar代替ActionBar,并设置相应属性
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);       // 使用toolbar代替ActionBar

        toolbar.setLogo(R.mipmap.ic_launcher);

        //toolbar.setTitle("ToolBar");   // 通过代码设置才生效：app:title="toolbar"

      /*  toolbar.setSubtitle("这是子标题");
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setSubtitleTextColor(Color.YELLOW);*/

        // 导航栏图标显示
        toolbar.setNavigationIcon(R.drawable.biz_video_pause);

       /* // 点击toolbar导航栏左上角的图标后，退出当前界面
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }

    //================Toolbar右上角弹出菜单(begin)=======================

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_01) {
            showToast("标题1");
            return true;
        }else if(item.getItemId() == R.id.item_02) {
            showToast("标题2");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//================Toolbar右上角弹出菜单(end)=========================


    /*  侧滑菜单点击监听*/
    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView= (NavigationView) findViewById(R.id.navigation_view);

        // 侧滑菜单点击监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 点击侧滑菜单item时，通过DrawerLayout关闭侧滑菜单
                showToast("" + item.getTitle());
                drawerLayout.closeDrawers();
                return false;
            }
        });
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
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.rb_01:
                       viewPager.setCurrentItem(0);
                       break;

                   case R.id.rb_02:
                       viewPager.setCurrentItem(1);
                       break;

                   case R.id.rb_03:
                       viewPager.setCurrentItem(2);
                       break;

                   case R.id.rb_04:
                       viewPager.setCurrentItem(3);
                       break;

                   case R.id.rb_05:
                       viewPager.setCurrentItem(4);
                       break;
               }
           }
       });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.rb_01);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_02);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_03);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_04);
                        break;
                    case 4:
                        radioGroup.check(R.id.rb_05);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void initData() {
    }
}
