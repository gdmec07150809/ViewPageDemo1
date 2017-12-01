package com.example.administrator.viewpagedemo;

import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/12/1.
 */

public class fragment1 extends Fragment{
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    private LinearLayout layout;
    LinearLayout ll,two;
    //图标
    int icno[] = {  R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,
                    R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,
                    R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg,R.drawable.c7_bg};
    //图标下的文字
    String name[]={"待办事项","常用数据","一般数据","生日","身份证","银行资料",
            "待办事项", "常用数据","一般数据","生日","身份证","银行资料",
            "待办事项", "常用数据","一般数据","生日","身份证","杂项","买菜"};
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item2, container, false);
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
                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
                layout=getActivity().findViewById(R.id.layout);
                layout.setBackgroundResource(R.color.colorPrimary);
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
