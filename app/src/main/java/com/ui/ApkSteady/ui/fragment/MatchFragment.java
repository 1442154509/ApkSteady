package com.ui.ApkSteady.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;


//比赛页面
public class MatchFragment extends Fragment {
    //比赛分类tab
    TabLayout tabMatchTitle;
    //赛事列表
    RecyclerView rvMatchList;

    //标题分类
    private String[] tabTitleList = {"全部", "足球", "篮球"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.match_fragment, container, false);
        initView(rootView);
        return rootView;
    }

    //初始化布局
    private void initView(View view) {
        //初始化tab
        tabMatchTitle=view.findViewById(R.id.tab_match_title);
        for (int i = 0; i < tabTitleList.length; i++) {
            tabMatchTitle.addTab(tabMatchTitle.newTab().setText(tabTitleList[i]));
        }
        //初始化recycleView
        rvMatchList=view.findViewById(R.id.rv_match_list);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}