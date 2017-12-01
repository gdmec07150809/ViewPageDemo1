package com.example.administrator.viewpagedemo;

import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.action;

/**
 * Created by Administrator on 2017/12/1.
 */

public class fragment2 extends Fragment {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    //图标
    int icno[] = {  R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,
            R.drawable.c10_bg,R.drawable.c10_bg, R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,
            R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,
            R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,R.drawable.c10_bg,
            R.drawable.c10_bg};
    //图标下的文字
    String name[]={"待办事项","常用数据","一般数据","生日","身份证","银行资料",
            "待办事项", "常用数据","一般数据","生日","身份证","银行资料",
            "待办事项", "常用数据","一般数据","生日","身份证","杂项",
            "待办事项", "常用数据","一般数据","生日","身份证","编辑","买菜"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item, container, false);
        gridView = (GridView) view.findViewById(R.id.gridview);
        //初始化数据
        initData();
        String[] from={"img","text"};

        int[] to={R.id.img,R.id.text};

        adapter=new SimpleAdapter(getActivity(), dataList, R.layout.gride_view_item, from, to);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @RequiresApi(api = VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                System.out.println(dataList.get(arg2));
            }
        });
        return view;
    }
    void initData() {
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }
}
