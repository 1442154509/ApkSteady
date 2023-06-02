package com.ui.ApkSteady.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.adapter.HomematchAdapter;
import com.ui.ApkSteady.ui.data.HomeMatchBean;

import java.util.ArrayList;
import java.util.List;

//首页面
public class HomeFragment extends Fragment {

    private GridView gvInfo;
    private Bundle bundle;
    private List<HomeMatchBean> matchBeanList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gvInfo = (GridView) view.findViewById(R.id.gv_info);
        bundle = this.getArguments();
        matchBeanList=new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            HomeMatchBean homeMatchBean=new HomeMatchBean("中超","直播","建宏","5467",
                    "泰格雷斯 VS 蒙特瑞",R.drawable.matching);
            matchBeanList.add(homeMatchBean);
        }
        HomematchAdapter adapter = new HomematchAdapter(getActivity(),matchBeanList);
        gvInfo.setAdapter(adapter);

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