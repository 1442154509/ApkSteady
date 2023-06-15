package com.ui.ApkSteady.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.res.IndexRes;
import com.ui.ApkSteady.ui.customview.ResizableImageView;

import java.util.List;

//首页适配器
public class HomeGrideAdapter extends BaseQuickAdapter<IndexRes.DataDTO, BaseViewHolder> {
    public HomeGrideAdapter(int layoutResId, @Nullable List<IndexRes.DataDTO> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, IndexRes.DataDTO data) {
//        baseViewHolder.getView(R.id.imageView_detail_start_mark);
        baseViewHolder.setText(R.id.tv_home_match_name, data.getMatchVediosInfo().getHome() + " VS " + data.getMatchVediosInfo().getAway());
        // 赛事状态 ： 0未开始,1直播中,2直播结束
        if (data.getStatus() == 0) {
            baseViewHolder.setText(R.id.tv_playstate, "未开始");
            baseViewHolder.setBackgroundResource(R.id.ll_match_state_bg, R.drawable.home_item_corner_matchunstart);
            baseViewHolder.setVisible(R.id.iv_eye, false);
        } else if (data.getStatus() == 1) {
            baseViewHolder.setText(R.id.tv_playstate, "直播");
            baseViewHolder.setBackgroundResource(R.id.ll_match_state_bg, R.drawable.home_item_corner_matchlive);
            Glide.with(getContext()).load(R.mipmap.home_item_match_live).into((ResizableImageView) baseViewHolder.getView(R.id.iv_matchstate));
            baseViewHolder.setVisible(R.id.iv_eye, true);
        } else if (data.getStatus() == 2) {
            baseViewHolder.setText(R.id.tv_playstate, "完赛");
            baseViewHolder.setBackgroundResource(R.id.ll_match_state_bg, R.drawable.home_item_corner_matchfinish);
            Glide.with(getContext()).load(R.mipmap.home_item_match_finish).into((ResizableImageView) baseViewHolder.getView(R.id.iv_matchstate));
            baseViewHolder.setVisible(R.id.iv_eye, true);
        } else {
            baseViewHolder.setText(R.id.tv_playstate, "未开始");
            baseViewHolder.setBackgroundResource(R.id.ll_match_state_bg, R.drawable.home_item_corner_matchunstart);
            baseViewHolder.setVisible(R.id.iv_eye, false);
        }

        baseViewHolder.setText(R.id.tv_competitionname, data.getCompetitionName());
        baseViewHolder.setText(R.id.tv_viewNum, data.getTitle());

        Glide.with(getContext()).load(data.getPortraitUrl()).placeholder(R.mipmap.home_item_matching_card_show_placeholder)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25))).into((ResizableImageView) baseViewHolder.getView(R.id.iv_homematch));
    }
}
