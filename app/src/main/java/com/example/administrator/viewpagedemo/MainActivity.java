package com.example.administrator.viewpagedemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.action;
import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.fragment;
import static android.R.attr.text;

public class MainActivity extends AppCompatActivity {
    //实现Tab滑动效果
    private ViewPager mViewPager;

    //存放Fragment
    private ArrayList<Fragment> fragmentArrayList;

    //管理Fragment
    private FragmentManager fragmentManager;

    LinearLayout ll,two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        InitFragment();
        InitViewPager();
        initPoints();
    }

    /**
     * 初始化页卡内容区
     */
    private void InitViewPager() {

        //mViewPager = (ViewPager) findViewById(R.id.vPager);
        mViewPager.setAdapter(new MFragmentPagerAdapter(fragmentManager, fragmentArrayList));

        //让ViewPager缓存2个页面
        mViewPager.setOffscreenPageLimit(2);
        //设置默认打开第一
        mViewPager.setCurrentItem(0);
        //设置viewpager页面滑动监听事件
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    /**
     * 初始化Fragment，并添加到ArrayList中
     */
    private void InitFragment(){
        fragmentArrayList = new ArrayList<Fragment>();
        fragmentArrayList.add(new fragment1());
        fragmentArrayList.add(new fragment2());
        fragmentManager = getSupportFragmentManager();

    }

    /**
     * 页卡切换监听
     * @author weizhi
     * @version 1.0
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @RequiresApi(api = VERSION_CODES.JELLY_BEAN)
        @Override
        public void onPageSelected(int position) {
  //          Animation animation = null ;
            switch (position){
                case 0:
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(android.R.id.content, new fragment1());

                    Toast.makeText(MainActivity.this,"页面"+position+1,Toast.LENGTH_SHORT).show();
                    for (int i=0;i<ll.getChildCount();i++){
                        ll.getChildAt(i).setSelected(false);
                    }
                    ll.getChildAt(position).setSelected(true);
                    break;
                case 1:
                    FragmentManager fm1 = getSupportFragmentManager();
                    FragmentTransaction ft1 = fm1.beginTransaction();
                    ft1.replace(android.R.id.content, new fragment2());
                    for (int i=0;i<ll.getChildCount();i++){
                        ll.getChildAt(i).setSelected(false);
                    }
                    ll.getChildAt(position).setSelected(true);
                     Toast.makeText(MainActivity.this,"页面"+position+1,Toast.LENGTH_SHORT).show();
                    break;
            }
//            animation.setFillAfter(true);// true:图片停在动画结束位置
//            animation.setDuration(300);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    /**
     * 实现小圆点的添加，
     * 找到线性布局动态的向线性布局内添加小圆，并添加drawable选择的效果
     */
    private void initPoints() {
        //实例化线性布局
        ll = (LinearLayout) findViewById(R.id.main_ll);
        //绘制和图片对应的圆点的数量
        for (int i = 0; i < fragmentArrayList.size(); i++) {
            View view = new View(this);
            //设置圆点的大小
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            //设置间距
            params.setMargins(10, 10, 10, 10);
            //设置图片的自定义效果
            view.setBackgroundResource(R.drawable.start_selsect);
            //把设置好的视图属性设置到View中
            view.setLayoutParams(params);
            //把创建好的View添加到线性布局中
            ll.addView(view);
        }
        Log.e("TAG", ":" + ll.getChildCount());
        //设置选中线性布局中的第一个
        ll.getChildAt(0).setSelected(true);
    }
}
