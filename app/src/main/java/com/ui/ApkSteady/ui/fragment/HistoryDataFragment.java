package com.ui.ApkSteady.ui.fragment;

import android.os.Bundle;
import android.view.ViewStub;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.presenter.DetailHisttoryPresenter;
import com.ui.ApkSteady.ui.adapter.DetailMultiAdapter;
import com.ui.ApkSteady.ui.adapter.FootballDetailMultiAdapter;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.FootBallDetailHistoryEntity;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.ArrayList;
import java.util.List;

import baselibs.base.BaseFragment;
import butterknife.BindView;

public class HistoryDataFragment extends BaseFragment<DetailHisttoryPresenter> implements DetailHistoryContract.DetailHistoryView {

    @BindView(R.id.detail_match_item)
    RecyclerView recyclerView;
    private IndexRes data;
    private List<FootBallDetailHistoryEntity> footBallDetailHistoryEntities;
    private FootballDetailMultiAdapter footballDetailMultiAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history_data;
    }

    @Override
    protected DetailHisttoryPresenter createPresenter() {
        return new DetailHisttoryPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        data = (IndexRes) arguments.getSerializable("IndexRes.Data");
        if (data == null) {
            data = new IndexRes();
        }
        try {
            if (data.getSportsId() == 1) {
                mPresenter.getFootBallHistoryDetail(String.valueOf(data.getMatchId()), String.valueOf(data.getSportsId()));
            } else if (data.getSportsId() == 2) {
                mPresenter.getBasketBallHistoryDetail(String.valueOf(data.getMatchId()), String.valueOf(data.getSportsId()));
            }
            footBallDetailHistoryEntities = new ArrayList<>();
            footballDetailMultiAdapter = new FootballDetailMultiAdapter(footBallDetailHistoryEntities);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(footballDetailMultiAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void upataFootBallUI(List<DetailHistoryEntity> data) {

    }

    @Override
    public void updataBasketBallUI(List<DetailHistoryEntity> data) {

    }

    @Override
    public void updateFootBallUI(List<FootBallDetailHistoryEntity> data) {
        footBallDetailHistoryEntities.clear();
        footBallDetailHistoryEntities.addAll(data);
        footballDetailMultiAdapter.setNewData(footBallDetailHistoryEntities);
        footballDetailMultiAdapter.notifyDataSetChanged();
    }
}