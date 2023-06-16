package com.ui.ApkSteady.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;

import java.util.List;

public class DetailMultiAdapter extends BaseMultiItemQuickAdapter<DetailHistoryEntity, BaseViewHolder> {

    public DetailMultiAdapter(List<DetailHistoryEntity> data) {
        super(data);
        addItemType(DetailHistoryEntity.TYPE_RANK, R.layout.list_item_title_rank_detail);
        addItemType(DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS, R.layout.list_item_processbar_detail);
        addItemType(DetailHistoryEntity.TYPE_HISTORYBATTLES, R.layout.item_history_detail);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailHistoryEntity item) {
        DetailHistoryEntity HistoryEntity = (DetailHistoryEntity) item;
        switch (HistoryEntity.getItemType()) {
//            case DetailHistoryEntity.TYPE_RANK:
//                DetailHistoryEntity.RankDTO rankDTO = HistoryEntity.getRank();
//
//                helper.setText(R.id.textview_detail_item_title_rank, rankDTO.getDiff())
//                        .setText(R.id.tv_lowest_price, entity.getPrePrice());
//            case DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS:
//                DetailHistoryEntity.GoalDistributionsDTO goalDistributions = HistoryEntity.getGoalDistributions();
//
//                helper.setText(R.id.textview_detail_item_title_rank, entity.getHome().get(0).getDrawn())
//                        .setText(R.id.tv_lowest_price, entity.getPrePrice());
//            case DetailHistoryEntity.TYPE_HISTORYBATTLES:
//                DetailHistoryEntity.HistoryBattlesDTO historyBattlesDTO = HistoryEntity.getHistoryBattles();
//
//                helper.setText(R.id.tv_name, seriesEntity.getName());
        }
    }
}