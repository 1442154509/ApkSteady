package com.ui.ApkSteady.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.utils.ConstantsUtils;
import com.ui.ApkSteady.ui.utils.DateUtils;

import java.util.List;

public class DetailMultiAdapter extends BaseMultiItemQuickAdapter<DetailHistoryEntity, BaseViewHolder> {

    public DetailMultiAdapter(List<DetailHistoryEntity> data) {
        super(data);
        addItemType(DetailHistoryEntity.TYPE_RANK, R.layout.list_item_title_rank_detail);
        addItemType(DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS, R.layout.list_item_processbar_detail);
        addItemType(DetailHistoryEntity.TYPE_HISTORYBATTLES, R.layout.item_history_detail);
        addItemType(DetailHistoryEntity.TYPE_RECENT, R.layout.list_item_recent_detail);
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
                        .setText(R.id.textview_detail_title_score_draw, rankDTO.getGoals() + "/" + rankDTO.getAgainst())
                        .setText(R.id.textview_detail_title_score_rank, rankDTO.getPosition());

                break;
            case DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS:
                int type_goald_position0 = ConstantsUtils.rank_size;
                DetailHistoryEntity.GoalDistributionsDTO goalDistributions = HistoryEntity.getGoalDistributions();
//
//                helper.setText(R.id.textview_detail_item_title_rank, entity.getHome().get(0).getDrawn())
//                        .setText(R.id.tv_lowest_price, entity.getPrePrice());
                break;
            case DetailHistoryEntity.TYPE_HISTORYBATTLES:
                /*第0条位置*/
                int type_history_position0 = ConstantsUtils.rank_size + ConstantsUtils.goald_size;
                DetailHistoryEntity.HistoryBattlesDTO historyBattlesDTO = HistoryEntity.getHistoryBattles();

                if (helper.getLayoutPosition() == type_history_position0) {
                    helper.setText(R.id.textview_detail_item_title, "历史交锋");
                    helper.getView(R.id.ll_include2).setVisibility(View.GONE);
                    helper.getView(R.id.constraintnlayout_detail_history_data).setVisibility(View.GONE);
                } else {

                    helper.getView(R.id.ll_include).setVisibility(View.GONE);
                    helper.getView(R.id.ll_include2).setVisibility(View.GONE);
                    helper.getView(R.id.imageview_detail_recent_teamlogo).setVisibility(View.GONE);
                    if (helper.getLayoutPosition() == type_history_position0 + 1) {
                        helper.getView(R.id.ll_include2).setVisibility(View.VISIBLE);
                        helper.getView(R.id.imageview_detail_recent_teamlogo).setVisibility(View.VISIBLE);
                        helper.setText(R.id.textview_detail_title_score_match, "近" + ConstantsUtils.his_battler_size + "场");
                        helper.setText(R.id.textview_detail_title_score_win, ConstantsUtils.his_battler_won + "胜");
                        helper.setText(R.id.textview_detail_title_score_draw, ConstantsUtils.his_battler_drawn + "平");
                        helper.setText(R.id.textview_detail_title_score_lost, ConstantsUtils.his_battler_lost + "负");
                        helper.setText(R.id.textview_detail_item_title_team_a, HistoryEntity.getHistoryBattles().getHomeTeamName());
                        Glide.with(getContext()).load(historyBattlesDTO.getHomeTeamLogo()).into((ImageView) helper.getView(R.id.imageview_detail_recent_teamlogo));

                    }
                    helper.setText(R.id.textView_detail_historybat_team_a, historyBattlesDTO.getHomeTeamName());
                    helper.setText(R.id.textView_detail_historybat_team_b, historyBattlesDTO.getAwayTeamName());
                    helper.setText(R.id.textView_detail_history_msg, DateUtils.timeStampToYMDHM(historyBattlesDTO.getMatchTime()) + "\t" + historyBattlesDTO.getLeagueName());
                    helper.setText(R.id.textView_detail_historybat_team_score, historyBattlesDTO.getHomeScore() + " : " + historyBattlesDTO.getAwayScore());

                    if (historyBattlesDTO.getHomeScore() > historyBattlesDTO.getAwayScore()) {
                        helper.setText(R.id.textView_detail_win, "胜");
                        helper.setBackgroundResource(R.id.textView_detail_win, R.drawable.detail_item_history_win_bg);
                    } else if (historyBattlesDTO.getHomeScore() == historyBattlesDTO.getAwayScore()) {
                        helper.setText(R.id.textView_detail_win, "平");
                        helper.setBackgroundResource(R.id.textView_detail_win, R.drawable.detail_item_history_drawn_bg);
                    } else {
                        helper.setText(R.id.textView_detail_win, "负");
                        helper.setBackgroundResource(R.id.textView_detail_win, R.drawable.detail_item_history_lost_bg);
                    }


                    Glide.with(getContext()).load(historyBattlesDTO.getHomeTeamLogo()).into((ImageView) helper.getView(R.id.imageview_detail_history_team_a_logo));
                    Glide.with(getContext()).load(historyBattlesDTO.getAwayTeamLogo()).into((ImageView) helper.getView(R.id.imageview_detail_history_team_b_logo));
                }
                break;
            case DetailHistoryEntity.TYPE_RECENT:
                /*第0条位置*/
                int type_recent_position0 = ConstantsUtils.rank_size + ConstantsUtils.goald_size + ConstantsUtils.his_battler_size;
                DetailHistoryEntity.RecentBattles recentBattles = HistoryEntity.getRecentBattles();
                if (helper.getLayoutPosition() == type_recent_position0) {
                    helper.setText(R.id.textview_detail_item_title, "近期战绩");
                    helper.setVisible(R.id.textview_detail_title_5match, true);
                    helper.getView(R.id.ll_include2).setVisibility(View.GONE);
                    helper.getView(R.id.linearlayout_detail_item_recent).setVisibility(View.GONE);
                } else {
                    helper.setVisible(R.id.ll_include, false);
                    helper.setText(R.id.textview_detail_item_title_team_a, recentBattles.getTeamname());
                    Glide.with(getContext()).load(recentBattles.getTeamlogo()).into((ImageView) helper.getView(R.id.imageview_detail_recent_teamlogo));

                    helper.setText(R.id.textview_detail_title_score_match, "近" + ConstantsUtils.recent_size + "场");
                    helper.setText(R.id.textview_detail_title_score_win, recentBattles.getWin() + "胜");
                    helper.setText(R.id.textview_detail_title_score_draw, recentBattles.getDrawn() + "平");
                    helper.setText(R.id.textview_detail_title_score_lost, recentBattles.getLost() + "负");
                    helper.setText(R.id.textView_recent_win_ratenum1, DateUtils.getPercent2(recentBattles.getWin(), ConstantsUtils.recent_size));
                    helper.setText(R.id.textView_recent_win_ratenum2, DateUtils.getPercent2(recentBattles.getLost(), ConstantsUtils.recent_size));
                    helper.setText(R.id.textView_recent_win_ratenum3, DateUtils.getPercent2(recentBattles.getDrawn(), ConstantsUtils.recent_size));
                    int[] stateid = {R.id.textView_recent_match_state1, R.id.textView_recent_match_state2, R.id.textView_recent_match_state3, R.id.textView_recent_match_state4, R.id.textView_recent_match_state5};
                    for (int i = 1; i < recentBattles.getMatchwinstate().size(); i++) {
                        if (recentBattles.getMatchwinstate().get(i) == 1) {
                            helper.setText(stateid[i], "胜");
                            helper.setBackgroundResource(stateid[i], R.drawable.detail_item_recent_win_bg);
                            helper.setTextColor(stateid[i], ContextCompat.getColor(getContext(), R.color.c_be3f30));
                        } else if (recentBattles.getMatchwinstate().get(i) == 2) {
                            helper.setText(stateid[i], "平");
                            helper.setBackgroundResource(stateid[i], R.drawable.detail_item_recent_tie_bg);
                            helper.setTextColor(stateid[i], ContextCompat.getColor(getContext(), R.color.c_969696));
                        } else if (recentBattles.getMatchwinstate().get(i) == 3) {
                            helper.setText(stateid[i], "负");
                            helper.setBackgroundResource(stateid[i], R.drawable.detail_item_recent_lose_bg);
                            helper.setTextColor(stateid[i], ContextCompat.getColor(getContext(), R.color.c_005ce0));
                        }
                    }
                }
                break;
        }
    }
}