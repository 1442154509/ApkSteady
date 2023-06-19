package com.ui.ApkSteady.ui.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.MatchItemBean;
import com.ui.ApkSteady.ui.utils.DateUtils;

import java.util.List;

import baselibs.glide.GlideUtils;

public class MatchConditionAdapter extends BaseMultiItemQuickAdapter<MatchItemBean, BaseViewHolder> {
    public MatchConditionAdapter(List<MatchItemBean> data) {
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
            //足球
            case MatchItemBean.ItemType.TYPE_MATCH_FOOTBALL:
                MatchConditionBean footMatchBean = ((MatchConditionBean) matchItemBean);
//              //开赛时间
                baseViewHolder.setText(R.id.tv_match_start_time, DateUtils.timeStampToMDHM(footMatchBean.getMatchTime()));
//              //赛事状态
                TextView matchStatus = baseViewHolder.getView(R.id.tv_match_top_status);
                switch (footMatchBean.getMatchStatus()){
                    case 0:
                        matchStatus.setText("未开始");
                        matchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_8b8b8b));
                        matchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_unstart,0,0,0);
                        baseViewHolder.setText(R.id.tv_item_match_status,"未开始");
                        baseViewHolder.setTextColorRes(R.id.tv_item_match_status,R.color.c_8b8b8b);
                        break;
                    case 1:
                        matchStatus.setText("进行中");
                        matchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_2a2a2a));
                        matchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_ing,0,0,0);
                        baseViewHolder.setText(R.id.tv_item_match_status,"中场");
                        baseViewHolder.setTextColorRes(R.id.tv_item_match_status,R.color.c_ca4a4a);
                        break;
                    case 2:
                        matchStatus.setText("结束");
                        matchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_ca4a4a));
                        matchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_end,0,0,0);
                        baseViewHolder.setText(R.id.tv_item_match_status,"结束");
                        baseViewHolder.setTextColorRes(R.id.tv_item_match_status,R.color.c_8b8b8b);
                        break;
                }
                //主队LOG
                ImageView aLogo = baseViewHolder.getView(R.id.iv_item_match_logo_a);
                GlideUtils.loadRoundImage(getContext(),aLogo,footMatchBean.getALogo(),R.mipmap.item_macth_football_icon);
                //主队名称
                baseViewHolder.setText(R.id.tv_item_match_name_a,footMatchBean.getHome());
                //主队比分
                baseViewHolder.setText(R.id.tv_item_match_score_a,footMatchBean.getAScore()+"");
                //主队红牌
                baseViewHolder.setText(R.id.tv_item_match_red_a,footMatchBean.getARed()+"");
                //主队黄牌
                baseViewHolder.setText(R.id.tv_item_match_yellow_a,footMatchBean.getAYellow()+"");

                //客队LOG
                ImageView bLogo = baseViewHolder.getView(R.id.iv_item_match_logo_b);
                GlideUtils.loadRoundImage(getContext(),bLogo,footMatchBean.getBLogo(),R.mipmap.item_macth_football_icon);
                //客队名称
                baseViewHolder.setText(R.id.tv_item_match_name_b,footMatchBean.getAway());
                //客队比分
                baseViewHolder.setText(R.id.tv_item_match_score_b,footMatchBean.getBScore()+"");
                //客队红牌
                baseViewHolder.setText(R.id.tv_item_match_red_b,footMatchBean.getBRed()+"");
                //客队黄牌
                baseViewHolder.setText(R.id.tv_item_match_yellow_b,footMatchBean.getBYellow()+"");

                //角球
                baseViewHolder.setText(R.id.tv_item_match_corner,footMatchBean.getACorner()+"-"+footMatchBean.getBCorner());

                break;

            //篮球
            case MatchItemBean.ItemType.TYPE_MATCH_BASKETBALL:

                MatchConditionBean basketballMatchBean = ((MatchConditionBean) matchItemBean);
//                //开赛时间
                baseViewHolder.setText(R.id.tv_match_start_time, DateUtils.timeStampToMDHM(basketballMatchBean.getMatchTime()));
//                //赛事状态
                TextView basketballMatchStatus = baseViewHolder.getView(R.id.tv_match_top_status);
                switch (basketballMatchBean.getMatchStatus()){
                    case 0:
                        basketballMatchStatus.setText("未开始");
                        basketballMatchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_8b8b8b));
                        basketballMatchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_unstart,0,0,0);
                        baseViewHolder.setText(R.id.tv_item_match_status,"未开始");
                        baseViewHolder.setTextColorRes(R.id.tv_item_match_status,R.color.c_8b8b8b);
                        break;
                    case 1:
                        basketballMatchStatus.setText("进行中");
                        basketballMatchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_2a2a2a));
                        basketballMatchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_ing,0,0,0);
                        break;
                    case 2:
                        basketballMatchStatus.setText("结束");
                        basketballMatchStatus.setTextColor(ContextCompat.getColor(getContext(), R.color.c_ca4a4a));
                        basketballMatchStatus.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.item_match_status_end,0,0,0);
                        baseViewHolder.setText(R.id.tv_item_match_status,"结束");
                        baseViewHolder.setTextColorRes(R.id.tv_item_match_status,R.color.c_8b8b8b);
                        break;
                }

                //主队LOG
                ImageView aBasketBallLogo = baseViewHolder.getView(R.id.iv_item_match_logo_a);
                GlideUtils.loadRoundImage(getContext(),aBasketBallLogo,basketballMatchBean.getALogo(),R.mipmap.item_macth_football_icon);
                //主队名称
                baseViewHolder.setText(R.id.tv_item_match_name_a,basketballMatchBean.getHome());
                //主队比分
                baseViewHolder.setText(R.id.tv_item_match_score_a,basketballMatchBean.getAScore()+"");

                //客队LOG
                ImageView bBasketLogo = baseViewHolder.getView(R.id.iv_item_match_logo_b);
                GlideUtils.loadRoundImage(getContext(),bBasketLogo,basketballMatchBean.getBLogo(),R.mipmap.item_macth_football_icon);
                //客队名称
                baseViewHolder.setText(R.id.tv_item_match_name_b,basketballMatchBean.getAway());
                //客队比分
                baseViewHolder.setText(R.id.tv_item_match_score_b,basketballMatchBean.getBScore()+"");
                break;
        }
    }
}
