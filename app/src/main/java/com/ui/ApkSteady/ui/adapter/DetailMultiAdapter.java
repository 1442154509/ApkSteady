package com.ui.ApkSteady.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;

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
            case DetailHistoryEntity.TYPE_RANK:
                DetailHistoryEntity.RankDTO rankDTO = HistoryEntity.getRank();
                helper.setText(R.id.textview_detail_item_title_rank, HistoryEntity.getHistoryBattles().getHomeTeamName())
                        .setText(R.id.textview_detail_title_score_match, rankDTO.getPlayed())
                        .setText(R.id.textview_detail_title_score_score, rankDTO.getWon() + "/" + rankDTO.getDrawn() + "/" + rankDTO.getLost())
                        .setText(R.id.textview_detail_title_score_pure, rankDTO.getGoals() + "/" + rankDTO.getAgainst())
                        .setText(R.id.textview_detail_title_score_rank, rankDTO.getPosition())
                ;

            case DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS:
//                DetailHistoryEntity.GoalDistributionsDTO goalDistributions = HistoryEntity.getGoalDistributions();
//
//                helper.setText(R.id.textview_detail_item_title_rank, entity.getHome().get(0).getDrawn())
//                        .setText(R.id.tv_lowest_price, entity.getPrePrice());
            case DetailHistoryEntity.TYPE_HISTORYBATTLES:
                DetailHistoryEntity.HistoryBattlesDTO historyBattlesDTO = HistoryEntity.getHistoryBattles();

                if (helper.getLayoutPosition() == 0) {
                    helper.setText(R.id.textview_detail_item_title, "历史交锋");
                    helper.getView(R.id.ll_include2).setVisibility(View.GONE);
                    helper.getView(R.id.constraintnlayout_detail_history_data).setVisibility(View.GONE);
                } else {

                    helper.getView(R.id.ll_include).setVisibility(View.GONE);
                    helper.getView(R.id.ll_include2).setVisibility(View.GONE);
                    if (helper.getLayoutPosition() == 1) {
                        helper.getView(R.id.ll_include2).setVisibility(View.VISIBLE);
                    }
                    helper.setText(R.id.textView_detail_history_team_a, historyBattlesDTO.getHomeTeamName());
                    helper.setText(R.id.textView_detail_history_team_b, historyBattlesDTO.getAwayTeamName());
//                    helper.setText(R.id.textView_detail_history_msg, historyBattlesDTO.getMatchTime());
                    helper.setText(R.id.textView_detail_history_team_score, historyBattlesDTO.getHomeScore() + " : " + historyBattlesDTO.getAwayScore());

                    Glide.with(getContext()).load(historyBattlesDTO.getHomeTeamLogo()).into((ImageView) helper.getView(R.id.imageview_detail_history_team_a_logo));
                    Glide.with(getContext()).load(historyBattlesDTO.getAwayTeamLogo()).into((ImageView) helper.getView(R.id.imageview_detail_history_team_b_logo));
                }


        }
    }
}