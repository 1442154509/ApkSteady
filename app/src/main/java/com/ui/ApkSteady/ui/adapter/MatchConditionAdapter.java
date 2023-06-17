package com.ui.ApkSteady.ui.adapter;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.MatchItemBean;

import java.util.List;

public class MatchConditionAdapter extends BaseMultiItemQuickAdapter<MatchItemBean, BaseViewHolder> {
    public MatchConditionAdapter(List data) {
        super(data);
        //未开始header
        addItemType(MatchItemBean.ItemType.TYPE_HEADER_UNSTART, R.layout.header_macth_status_un_start);
        //进行中header
        addItemType(MatchItemBean.ItemType.TYPE_HEADER_IN_PROGRESS, R.layout.header_macth_status_in_progress);
//        //已结束header
//        addItemType(MatchItemBean.ItemType.TYPE_HEADER_FINISH, R.layout.item_match_football);
        //足球
        addItemType(MatchItemBean.ItemType.TYPE_MATCH_FOOTBALL, R.layout.item_match_football);
        //篮球
        addItemType(MatchItemBean.ItemType.TYPE_MATCH_BASKETBALL, R.layout.item_match_basketball);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MatchItemBean matchItemBean) {
        switch (matchItemBean.getItemType()) {
            case MatchItemBean.ItemType.TYPE_MATCH_FOOTBALL:
                MatchConditionBean footMatch = ((MatchConditionBean) matchItemBean);
                //开赛时间
                baseViewHolder.setText(R.id.tv_match_start_time, footMatch.getMatchTime());
                //赛事状态
                TextView matchStatus = baseViewHolder.getView(R.id.tv_match_top_status);
//                matchStatus
                break;
            case MatchItemBean.ItemType.TYPE_MATCH_BASKETBALL:
                break;
        }
    }
}
