package com.ui.ApkSteady.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.HomematchAdapter;
import com.ui.ApkSteady.ui.data.HomeMatchBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

//首页面
public class HomeFragment extends Fragment {
    private GridView gvInfo;
    private TabLayout tbMatchTitle;
    private Bundle bundle;
    private List<HomeMatchBean> matchBeanList;
    private String[] tabs = {"热门", "足球", "篮球"};

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gvInfo = (GridView) view.findViewById(R.id.gv_info);
        tbMatchTitle = (TabLayout) view.findViewById(R.id.tab_match_title);
        bundle = this.getArguments();
        matchBeanList = new ArrayList<>();

        //添加tab
        for (int i = 0; i < tabs.length; i++) {
            tbMatchTitle.addTab(tbMatchTitle.newTab().setText(tabs[i]));
        }
        for (int i = 0; i <= 20; i++) {
            HomeMatchBean homeMatchBean;
            if ((i + 1) % 4 == 0) {
                homeMatchBean = new HomeMatchBean("中超", "未开始", "建宏说球", "4567",
                        "泰格雷斯 VS 蒙特瑞", R.drawable.matching);
            } else if ((i + 1) % 3 == 0) {
                homeMatchBean = new HomeMatchBean("中超", "完赛", "建宏说球", "3456",
                        "泰格雷斯 VS 蒙特瑞", R.drawable.matching);
            } else if ((i + 1) % 2 == 0) {
                homeMatchBean = new HomeMatchBean("墨西哥篮联", "进行中", "建宏说球", "2345",
                        "泰格雷斯 VS 蒙特瑞", R.drawable.matching);
            } else {
                homeMatchBean = new HomeMatchBean("中超", "直播", "建宏说球", "1234",
                        "泰格雷斯 VS 蒙特瑞", R.drawable.matching);
            }
            matchBeanList.add(homeMatchBean);
        }
        HomematchAdapter adapter = new HomematchAdapter(getActivity(), matchBeanList);
        gvInfo.setAdapter(adapter);
        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), position+",", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}