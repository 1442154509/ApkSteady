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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.BaseFragment;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.HomeGrideAdapter;
import com.ui.ApkSteady.ui.data.HomeAllBean;
import com.ui.ApkSteady.ui.data.HomeMatchBean;
import com.ui.ApkSteady.ui.data.res.IndexRes;
import com.ui.ApkSteady.ui.utils.ApiJsonRequest;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.ToastUtils;
import com.ui.ApkSteady.ui.customview.LinearSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//首页面
public class HomeFragment extends BaseFragment {
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
    private List<IndexRes.DataDTO> data;
    private String[] sTabTitleName = {"热门", "足球", "篮球"};
    private HomeGrideAdapter homeGrideAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        data = new ArrayList<>();
        //添加tab
        for (int i = 0; i < sTabTitleName.length; i++) {
            mMatchTitletlyt.addTab(mMatchTitletlyt.newTab().setText(sTabTitleName[i]));
        }
//        mMatchDataList = new ArrayList<>();

//        for (int i = 0; i <= 20; i++) {
//            HomeMatchBean homeMatchBean;
//            if ((i + 1) % 4 == 0) {
//                homeMatchBean = new HomeMatchBean("中超", "未开始", "建宏说球", "4567",
//                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
//            } else if ((i + 1) % 3 == 0) {
//                homeMatchBean = new HomeMatchBean("中超", "完赛", "建宏说球", "3456",
//                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
//            } else if ((i + 1) % 2 == 0) {
//                homeMatchBean = new HomeMatchBean("墨西哥篮联", "进行中", "建宏说球", "2345",
//                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
//            } else {
//                homeMatchBean = new HomeMatchBean("中超", "直播", "建宏说球", "1234",
//                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
//            }
//            mMatchDataList.add(homeMatchBean);
//        }
//        mHomeAllBean = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            HomeAllBean homeAllBean = new HomeAllBean();
//            mHomeAllBean.add(homeAllBean);
//        }

        homeGrideAdapter = new HomeGrideAdapter(R.layout.grid_item_match_home, data);
        rvhome.addItemDecoration(new LinearSpacingItemDecoration(getActivity(), 20));
        rvhome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvhome.setAdapter(homeGrideAdapter);
        homeGrideAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("IndexRes.DataDTO", data.get(position));
                Intent intent = new Intent();
                intent.putExtras(mBundle);
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
                onFragmentUnVisible();
            }
        });
        mSwiperlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getRequest(0);
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
                getRequest(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        isTimmerUse = true;
        getRequest(0);
    }

    private void getRequest(int position) {
        ApiJsonRequest<IndexRes> apiJsonRequest = new ApiJsonRequest<>(
                "http://34.80.205.147:12300/Api/Index?sportsId=" + position, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.e(error.toString());
                ToastUtils.show(error.toString());
            }
        }, new Response.Listener<IndexRes>() {
            @Override
            public void onResponse(IndexRes response) {
                ToastUtils.show(position+"");
                data.clear();
                data.addAll(response.getData());
                homeGrideAdapter.setNewData(data);
                homeGrideAdapter.notifyDataSetChanged();
//                for (IndexRes.DataDTO dto :
//                        response.getData()) {
//                    LogUtils.e(dto.toString());
//                }
                //获取最新数据
//                processData(response);
                //显示新闻
//                showNews();

            }
        }, IndexRes.class);
        addVolleyResQue(apiJsonRequest);
    }

    @Override
    protected void onFragmentVisible() {
        super.onFragmentVisible();
        meHandler();
    }

    @Override
    protected void onFragmentUnVisible() {
        super.onFragmentUnVisible();
    }

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO 在此处添加执行的代码
            handler.postDelayed(this, 1000);// 50是延时时长
        }
    };
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