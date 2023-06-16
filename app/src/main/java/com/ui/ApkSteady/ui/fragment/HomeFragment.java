package com.ui.ApkSteady.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.hazz.baselibs.base.BaseFragment;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.contract.HomeContract;
import com.ui.ApkSteady.presenter.HomePresenter;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.HomeGrideAdapter;
import com.ui.ApkSteady.ui.customview.LinearSpacingItemDecoration;
import com.ui.ApkSteady.ui.data.HomeAllBean;
import com.ui.ApkSteady.ui.data.HomeMatchBean;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//首页面
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {
    @BindView(R.id.rv_home_all)
    RecyclerView rvhome;
    @BindView(R.id.tablayout_match_title)
    TabLayout mMatchTitletlyt;
    @BindView(R.id.swiperlayout_home_match)
    SwipeRefreshLayout mSwiperlayout;
    @BindView(R.id.linearlayout_match_title)
    LinearLayout linearlayoutMatchTitle;
    private List<HomeMatchBean> mMatchDataList;
    private List<HomeAllBean> mHomeAllBean;
    private List<IndexRes> data;
    private String[] sTabTitleName = {"热门", "足球", "篮球"};
    private HomeGrideAdapter homeGrideAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        data = new ArrayList<>();
        //添加tab
        for (int i = 0; i < sTabTitleName.length; i++) {
            mMatchTitletlyt.addTab(mMatchTitletlyt.newTab().setText(sTabTitleName[i]));
        }
        homeGrideAdapter = new HomeGrideAdapter(R.layout.grid_item_match_home, data);
        rvhome.addItemDecoration(new LinearSpacingItemDecoration(getActivity(), 20));
        rvhome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvhome.setAdapter(homeGrideAdapter);
        homeGrideAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("IndexRes.Data", data.get(position));
                Intent intent = new Intent();
                intent.putExtras(mBundle);
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
        mSwiperlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                getRequest(0);
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false，停止刷新
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwiperlayout.setRefreshing(false);
                    }
                }, 1500);

            }
        });
        mMatchTitletlyt.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
//                getRequest(position);
                mPresenter.getDataFormModel(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        getRequest(0);
        mPresenter.getDataFormModel(0);
    }

    @Override
    protected boolean useEventBus() {
        return false;
    }


    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO 在此处添加执行的代码
            handler.postDelayed(this, 1000);// 50是延时时长
        }
    };

    @Override
    public void showError(String msg) {

    }

    @Override
    public void updataUI(List<IndexRes> result) {
        data.clear();
        data.addAll(result);
        homeGrideAdapter.setNewData(data);
        homeGrideAdapter.notifyDataSetChanged();
    }

//
//    private static final int PERIOD = 10 * 1000;
//    private static final int DELAY = 100;
//    private Timer mTimer;
//    private TimerTask mTimerTask;
//
//    protected void timeLooprefesh() {
//        LogUtils.e("++++定时器开始++++");
//        mTimer = new Timer();
//        mTimerTask = new TimerTask() {
//            @Override
//            public void run() {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        LogUtils.e("$$$$$定时器刷新了$$$$");
//                    }
//                });
//                //在此添加轮询
//
//            }
//        };
//        mTimer.schedule(mTimerTask, DELAY, PERIOD);
//    }

}