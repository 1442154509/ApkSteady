package com.ui.ApkSteady.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.MatchConditionAdapter;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.MatchItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

//关注页面
public class AttentionFragment extends Fragment {
    //赛事分类
    @BindView(R.id.tab_match_title)
    TabLayout tabMatchTitle;
    //赛事列表
    @BindView(R.id.rv_match_list)
    RecyclerView rvMatchList;
    //列表适配器
    MatchConditionAdapter macthAdapter;

    //标题分类
    private String[] tabTitleList = {"全部", "足球", "篮球"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attention_fragment, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    //初始化布局
    private void initView() {
        //初始化tab
        for (int i = 0; i < tabTitleList.length; i++) {
            tabMatchTitle.addTab(tabMatchTitle.newTab().setText(tabTitleList[i]));
        }
        //初始化recycleView
        rvMatchList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        macthAdapter = new MatchConditionAdapter(new ArrayList());
        rvMatchList.setAdapter(macthAdapter);
        macthAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
        test();
    }

    private void test() {
        ArrayList<MatchConditionBean> list = new ArrayList<>();
        //足球
        for (int i = 1; i < 20; i++) {
            MatchConditionBean matchConditionBean = new MatchConditionBean();
            matchConditionBean.setItemType(new Random().nextBoolean() ? 11 : 12);
            matchConditionBean.setMatchStatus(new Random().nextBoolean() ? 0 : 1);
            list.add(matchConditionBean);
        }
        onDataChanged(list);
    }

    //刷新列表数据
    private void onDataChanged(List<MatchConditionBean> beans) {
        List<MatchConditionBean> inProgressList = new ArrayList<>();
        List<MatchConditionBean> finishList = new ArrayList<>();
        for (MatchConditionBean bean : beans) {
            if (bean.getMatchStatus() == MatchConditionBean.MatchStatus.IN_PROGRESS) {
                inProgressList.add(bean);
            }
        }
        if (inProgressList.size() > 0) {
            macthAdapter.addData(new MatchItemBean().setItemType(MatchItemBean.ItemType.TYPE_HEADER_IN_PROGRESS));
            macthAdapter.addData(inProgressList);
        }
        for (MatchConditionBean bean : beans) {
            if (bean.getMatchStatus() == MatchConditionBean.MatchStatus.NOT_START) {
                finishList.add(bean);
            }
        }
        if (finishList.size() > 0) {
            macthAdapter.addData(new MatchItemBean().setItemType(MatchItemBean.ItemType.TYPE_HEADER_UNSTART));
            macthAdapter.addData(finishList);
        }
        macthAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}