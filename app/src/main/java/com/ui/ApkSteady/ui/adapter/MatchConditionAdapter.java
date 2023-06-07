package com.ui.ApkSteady.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.MatchConditionBean;

import java.util.List;

public class MatchConditionAdapter extends BaseMultiItemQuickAdapter {
    public MatchConditionAdapter(List data){
        super(data);
        addItemType(MatchConditionBean.SportType.FOOTBALL, R.layout.item_match_football);
        addItemType(MatchConditionBean.SportType.BASKETBALL, R.layout.item_match_basketball);
    }
    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, Object o) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
