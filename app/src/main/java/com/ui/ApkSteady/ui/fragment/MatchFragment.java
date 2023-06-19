package com.ui.ApkSteady.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import baselibs.base.BaseFragment;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.contract.MatchContract;
import com.ui.ApkSteady.presenter.MatchPresenter;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.MatchConditionAdapter;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.MatchItemBean;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


//比赛页面
public class MatchFragment extends BaseFragment<MatchPresenter> implements MatchContract.View {
    //比赛分类tab
    @BindView(R.id.tab_match_title)
    TabLayout tabMatchTitle;
    //赛事列表
    @BindView(R.id.rv_match_list)
    RecyclerView rvMatchList;
    //列表适配器
    MatchConditionAdapter macthAdapter;
    //列表数据
    List<MatchItemBean> adapterList;
    //标题分类
    private String[] tabTitleList = {"全部", "足球", "篮球"};

    private int currentType=0;

    protected Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected int getLayoutId() {
        return R.layout.match_fragment;
    }

    @Override
    protected MatchPresenter createPresenter() {
        return new MatchPresenter();
    }

    @Override
    protected void initView() {
        //初始化tab
        for (int i = 0; i < tabTitleList.length; i++) {
            tabMatchTitle.addTab(tabMatchTitle.newTab().setText(tabTitleList[i]));
        }
        tabMatchTitle.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentType=tab.getPosition();
                mPresenter.getMatchList(currentType,true);
                //重选tab后刷新定时刷新任务
                handler.removeCallbacksAndMessages(null);
                timingRefresh();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //初始化recycleView
        rvMatchList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapterList = new ArrayList<>();
        macthAdapter = new MatchConditionAdapter(adapterList);
        rvMatchList.setAdapter(macthAdapter);
        macthAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getMatchList(currentType,true);
    }

    //刷新列表数据
    private void onDataChanged(List<MatchConditionBean> beans) {
        List<MatchConditionBean> inProgressList = new ArrayList<>();
        List<MatchConditionBean> finishList = new ArrayList<>();
        for (MatchConditionBean bean : beans) {
            if (bean.getMatchStatus() == MatchConditionBean.MatchStatus.IN_PROGRESS) {
                bean.setItemType(bean.getSportsId() == 1 ? MatchItemBean.ItemType.TYPE_MATCH_FOOTBALL : MatchItemBean.ItemType.TYPE_MATCH_BASKETBALL);
                inProgressList.add(bean);
            }
        }
        if (inProgressList.size() > 0) {
            adapterList.add(new MatchItemBean().setItemType(MatchItemBean.ItemType.TYPE_HEADER_IN_PROGRESS));
            adapterList.addAll(inProgressList);
        }
        for (MatchConditionBean bean : beans) {
            if (bean.getMatchStatus() == MatchConditionBean.MatchStatus.NOT_START) {
                bean.setItemType(bean.getSportsId() == 1 ? MatchItemBean.ItemType.TYPE_MATCH_FOOTBALL : MatchItemBean.ItemType.TYPE_MATCH_BASKETBALL);
                finishList.add(bean);
            }
        }
        if (finishList.size() > 0) {
            adapterList.add(new MatchItemBean().setItemType(MatchItemBean.ItemType.TYPE_HEADER_UNSTART));
            adapterList.addAll(finishList);
        }
        macthAdapter.notifyDataSetChanged();
    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onGetMatchLsitSuccess(List<MatchConditionBean> matchList) {
        adapterList.clear();
        onDataChanged(matchList);
    }

    @Override
    public void onGetMatchLsitFail(String msg) {
        ToastUtils.show(msg);
    }

    @Override
    protected void onFragmentResume() {
        super.onResume();
        //页面显示，开启定时刷新
        timingRefresh();
    }

    //定时刷新
    private void timingRefresh(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getMatchList(currentType,false);
                timingRefresh();
            }
        }, 10000);
    }

    @Override
    protected void onFragmentPause() {
        super.onPause();
        //页面到后台，关闭定时刷新
        handler.removeCallbacksAndMessages(null);
    }


}