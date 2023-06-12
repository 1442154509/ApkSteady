package com.ui.ApkSteady.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.HomeGrideAdapter;
import com.ui.ApkSteady.ui.data.HomeAllBean;
import com.ui.ApkSteady.ui.data.HomeMatchBean;
import com.ui.ApkSteady.ui.view.LinearSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//首页面
public class HomeFragment extends Fragment {
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
    private String[] sTabTitleName = {"热门", "足球", "篮球"};

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        addData();
        return view;
    }

    private void addData() {
        mMatchDataList = new ArrayList<>();

        //添加tab
        for (int i = 0; i < sTabTitleName.length; i++) {
            mMatchTitletlyt.addTab(mMatchTitletlyt.newTab().setText(sTabTitleName[i]));
        }
        for (int i = 0; i <= 20; i++) {
            HomeMatchBean homeMatchBean;
            if ((i + 1) % 4 == 0) {
                homeMatchBean = new HomeMatchBean("中超", "未开始", "建宏说球", "4567",
                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
            } else if ((i + 1) % 3 == 0) {
                homeMatchBean = new HomeMatchBean("中超", "完赛", "建宏说球", "3456",
                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
            } else if ((i + 1) % 2 == 0) {
                homeMatchBean = new HomeMatchBean("墨西哥篮联", "进行中", "建宏说球", "2345",
                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
            } else {
                homeMatchBean = new HomeMatchBean("中超", "直播", "建宏说球", "1234",
                        "泰格雷斯 VS 蒙特瑞", R.mipmap.home_item_matching_card_show_placeholder);
            }
            mMatchDataList.add(homeMatchBean);
        }
        mHomeAllBean = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            HomeAllBean homeAllBean = new HomeAllBean();
            mHomeAllBean.add(homeAllBean);
        }
        HomeGrideAdapter homeGrideAdapter = new HomeGrideAdapter(R.layout.grid_item_match_home, mHomeAllBean);
        rvhome.addItemDecoration(new LinearSpacingItemDecoration(getActivity(), 20));
        rvhome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvhome.setAdapter(homeGrideAdapter);
        homeGrideAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("homeallbean", mHomeAllBean.get(position));
                Intent intent = new Intent();
                intent.putExtras(mBundle);
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
        mSwiperlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false，停止刷新
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwiperlayout.setRefreshing(false);
                    }
                }, 1500);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}