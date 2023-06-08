package com.ui.ApkSteady.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.tabs.TabLayout;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.DetailActivity;
import com.ui.ApkSteady.ui.adapter.HomematchAdapter;
import com.ui.ApkSteady.ui.data.HomeMatchBean;

import java.util.ArrayList;
import java.util.List;

//首页面
public class HomeFragment extends Fragment {
    private GridView mCardgv;
    private TabLayout mMatchTitletlyt;
    private SwipeRefreshLayout mSwiperlayout;
    private Bundle mBundle;
    private List<HomeMatchBean> mMatchDataList;
    private String[] sTabTitleName = {"热门", "足球", "篮球"};

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mCardgv = (GridView) view.findViewById(R.id.gridview_card);
        mMatchTitletlyt = (TabLayout) view.findViewById(R.id.tablayout_match_title);
        mSwiperlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperlayout_home_match);
        mBundle = this.getArguments();
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
        HomematchAdapter adapter = new HomematchAdapter(getActivity(), mMatchDataList);
        mCardgv.setAdapter(adapter);
        mCardgv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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