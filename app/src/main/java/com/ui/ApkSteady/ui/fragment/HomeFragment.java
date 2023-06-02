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

//首页面
public class HomeFragment extends Fragment {

    private GridView gvInfo;
    private Bundle bundle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gvInfo = (GridView) view.findViewById(R.id.gv_info);
        bundle = this.getArguments();
        HomematchAdapter adapter = new HomematchAdapter(getActivity());
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