package com.ui.ApkSteady.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.HomeMatchBean;
import com.ui.ApkSteady.ui.view.AutoSizeImageView;

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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridlayout_home_match, null);
            viewHolder = new ViewHolder();
            viewHolder.tvMatchVs = (TextView) convertView.findViewById(R.id.tv_home_matchvs_name);

            viewHolder.tvTeamName = (TextView) convertView.findViewById(R.id.tv_team_name);

            viewHolder.tvPlaystate = (TextView) convertView.findViewById(R.id.tv_playstate);

            viewHolder.tvExpositor = (TextView) convertView.findViewById(R.id.tv_expositor);

            viewHolder.tvViewNum = (TextView) convertView.findViewById(R.id.tv_viewNum);

            viewHolder.ivMatch = (AutoSizeImageView) convertView.findViewById(R.id.iv_homematch);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvMatchVs.setText(matchBeanList.get(position).getVsName());
        viewHolder.tvTeamName.setText(matchBeanList.get(position).getTeamName());
        viewHolder.tvPlaystate.setText(matchBeanList.get(position).getPlayState());
        viewHolder.tvExpositor.setText(matchBeanList.get(position).getExpositor());
        viewHolder.tvViewNum.setText(matchBeanList.get(position).getViewNum());
        viewHolder.ivMatch.setBackgroundResource(matchBeanList.get(position).getImages());
        return convertView;
    }

    private final class ViewHolder {

        TextView tvMatchVs;
        TextView tvTeamName;
        TextView tvPlaystate;

        TextView tvExpositor;

        TextView tvViewNum;
        AutoSizeImageView ivMatch;
    }
}
