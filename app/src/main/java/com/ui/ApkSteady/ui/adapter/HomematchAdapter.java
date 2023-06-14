package com.ui.ApkSteady.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.HomeMatchBean;
import com.ui.ApkSteady.ui.view.ResizableImageView;

import java.util.List;

//主页_比赛适配
public class HomematchAdapter extends BaseAdapter {
    private Context mContext;
    private List<HomeMatchBean> matchBeanList;

    public HomematchAdapter(Context context, List<HomeMatchBean> matchBeanList) {
        this.mContext = context;
        this.matchBeanList = matchBeanList;

    }

    @Override
    public int getCount() {
        return matchBeanList != null ? matchBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return matchBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_match_home, null);
            viewHolder = new ViewHolder();
            viewHolder.tvMatchVs = (TextView) convertView.findViewById(R.id.tv_home_match_name);

            viewHolder.tvTeamName = (TextView) convertView.findViewById(R.id.tv_competitionname);

            viewHolder.tvPlaystate = (TextView) convertView.findViewById(R.id.tv_playstate);

            viewHolder.tvExpositor = (TextView) convertView.findViewById(R.id.tv_expositor);

            viewHolder.tvViewNum = (TextView) convertView.findViewById(R.id.tv_viewNum);

            viewHolder.ivMatch = (ResizableImageView) convertView.findViewById(R.id.iv_homematch);

            viewHolder.iveye = (ResizableImageView) convertView.findViewById(R.id.iv_eye);

            viewHolder.ivmatchstate = (ResizableImageView) convertView.findViewById(R.id.iv_matchstate);

            viewHolder.ivMatchStateBg = (LinearLayout) convertView.findViewById(R.id.ll_match_state_bg);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvMatchVs.setText(matchBeanList.get(position).getVsName());
        viewHolder.tvTeamName.setText(matchBeanList.get(position).getTeamName());
        viewHolder.tvPlaystate.setText(matchBeanList.get(position).getPlayState());
        viewHolder.tvExpositor.setText(matchBeanList.get(position).getExpositor());
        viewHolder.tvViewNum.setText(matchBeanList.get(position).getViewNum());
        Glide.with(mContext).load(matchBeanList.get(position).getImages()).apply(RequestOptions.bitmapTransform(new RoundedCorners(25))).into(viewHolder.ivMatch);
//        Glide.with(mContext).load(matchBeanList.get(position).getImages()).into(viewHolder.ivMatch);

        Glide.with(mContext).load(R.mipmap.home_item_match_view_eye).into(viewHolder.iveye);

//        Glide.with(mContext).load(R.drawable.corner_matching).into(viewHolder.ivMatchStateBg);
//        viewHolder.ivMatchStateBg.setBackgroundResource(R.drawable.corner_matching);
        if ((position + 1) % 4 == 0) {
            viewHolder.ivMatchStateBg.setBackgroundResource(R.drawable.home_item_corner_matchunstart);
            viewHolder.ivmatchstate.setVisibility(View.GONE);
        } else if ((position + 1) % 3 == 0) {
            viewHolder.ivMatchStateBg.setBackgroundResource(R.drawable.home_item_corner_matchfinish);
            Glide.with(mContext).load(R.mipmap.home_item_match_finish).into(viewHolder.ivmatchstate);
            viewHolder.ivmatchstate.setVisibility(View.VISIBLE);
        } else if ((position + 1) % 2 == 0) {
            viewHolder.ivMatchStateBg.setBackgroundResource(R.drawable.home_item_corner_matching);
            viewHolder.ivmatchstate.setVisibility(View.GONE);
        } else {
            viewHolder.ivMatchStateBg.setBackgroundResource(R.drawable.home_item_corner_matchlive);
            Glide.with(mContext).load(R.mipmap.home_item_match_live).into(viewHolder.ivmatchstate);
            viewHolder.ivmatchstate.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    private final class ViewHolder {

        TextView tvMatchVs;
        TextView tvTeamName;
        TextView tvPlaystate;
        TextView tvExpositor;
        TextView tvViewNum;
        ResizableImageView ivMatch;
        ResizableImageView iveye;
        ResizableImageView ivmatchstate;
        LinearLayout ivMatchStateBg;
    }
}
