package com.ui.ApkSteady.ui.adapter;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.HomeAllBean;
import com.ui.ApkSteady.ui.view.ResizableImageView;

import java.util.List;
//首页适配器
public class HomeGrideAdapter extends BaseQuickAdapter<HomeAllBean, BaseViewHolder> {
    public HomeGrideAdapter(int layoutResId, @Nullable List<HomeAllBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, HomeAllBean homeAllBean) {
//        baseViewHolder.getView(R.id.imageView_detail_start_mark);
        baseViewHolder.setText(R.id.tv_home_matchvs_name, TextUtils.isEmpty(homeAllBean.getMatchName()) ? "泰格雷斯 VS 蒙特瑞" : homeAllBean.getMatchName());
        baseViewHolder.setText(R.id.tv_playstate, (homeAllBean.getStatus() == 0) ? "直播" : "未开始");
        baseViewHolder.setText(R.id.tv_competitionname, homeAllBean.getCompetitionName());
        baseViewHolder.setText(R.id.tv_viewNum, homeAllBean.getTitle());

        baseViewHolder.setBackgroundResource(R.id.ll_match_state_bg,R.drawable.home_item_corner_matchlive);
        Glide.with(getContext()).load(R.mipmap.home_item_match_view_eye).into((ResizableImageView) baseViewHolder.getView(R.id.iv_eye));
        Glide.with(getContext()).load(R.mipmap.home_item_match_live).into((ResizableImageView) baseViewHolder.getView(R.id.iv_matchstate));
        Glide.with(getContext()).load(homeAllBean.getPortraitUrl()).placeholder(R.mipmap.home_item_matching_card_show_placeholder)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25))).into((ResizableImageView) baseViewHolder.getView(R.id.iv_homematch));
    }
}
