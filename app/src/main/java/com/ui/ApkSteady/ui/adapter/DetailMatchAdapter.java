package com.ui.ApkSteady.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.data.MyData;

import java.util.List;

public class DetailMatchAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<MyData> list;

    public DetailMatchAdapter(Context context, List<MyData> mMyData) {
        mContext = context;
        list = mMyData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_title, parent, false);
                MyViewHolder0 viewHolder0 = new MyViewHolder0(view);
                return viewHolder0;
            case 1:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_processbar, parent, false);
                MyViewHolder1 viewHolder1 = new MyViewHolder1(view1);
                return viewHolder1;
        }
        return null;
    }
    //返回viewHolder的类型


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //获取数据得到类型
        MyData data = list.get(position);
        int type = data.getType();
        switch (type) {
            case 0:
                MyViewHolder0 holder0 = (MyViewHolder0) holder;
                if (position == 0) {
                    holder0.llytmatch.setVisibility(View.VISIBLE);
                    holder0.llytmatchvs.setVisibility(View.GONE);
                }
                if (position == 1 || position == 2) {
                    holder0.llytmatch.setVisibility(View.VISIBLE);
                    holder0.llytmatchvs.setVisibility(View.GONE);
//                holder0.tvTitle.setText(data.getText());
                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
//                    Drawable top = AppCompatResources.getDrawable(mContext, R.mipmap.detail_team_logo_england);
                    holder0.tvTitle.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder0.tvTitle.setTextSize(15);
                    holder0.tvTitle.setText(data.getText());
//                holder0.tvmatch.setBackgroundResource(data.getImage());
                    //增加布局
//                    RelativeLayout rl = new RelativeLayout(mContext);
//                    rl.setBackground(AppCompatResources.getDrawable(mContext, R.drawable.detail_score_bg_yellow));
//                    RelativeLayout.LayoutParams relLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                    relLayoutParams.height = 10;
//                    rl.setLayoutParams(relLayoutParams);
//                    holder0.llytmatch.addView(rl, -1);
                }
                if (position == 3) {
                    holder0.llytmatch.setVisibility(View.GONE);
                    holder0.llytmatchvs.setVisibility(View.GONE);
                    holder0.tvTitle.setText(data.getText());
                }
                if (position == 4) {
                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder0.llytmatch.setVisibility(View.GONE);
                    holder0.llytmatchvs.setVisibility(View.VISIBLE);
                    holder0.tvTitle.setText(data.getText());
                    holder0.tvTitle.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder0.tvrightteam.setText(data.getText());
                    holder0.tvrightteam.setCompoundDrawablesWithIntrinsicBounds(null, null, top, null);
                }

                break;
            case 1:
                MyViewHolder1 holder1 = (MyViewHolder1) holder;
                holder1.probarLeft.setProgress(85);
                holder1.probarRight.setProgress(100);
                //到达100就改变边上三角颜色
                if (holder1.probarLeft.getProgress() == 100) {
                    holder1.tvLeftTriangle.setBackgroundResource(R.drawable.detail_item_progressbar_left_tr_red);
                } else if (holder1.probarLeft.getProgress() != 100) {
                    holder1.tvLeftTriangle.setBackgroundResource(R.drawable.detail_item_progressbar_left_tr_white);
                }
                if (holder1.probarRight.getProgress() == 100) {
                    holder1.tvRightTriangle.setBackgroundResource(R.drawable.detail_item_progressbar_right_tr_blue);
                } else if (holder1.probarRight.getProgress() != 100) {
                    holder1.tvRightTriangle.setBackgroundResource(R.drawable.detail_item_progressbar_right_tr_white);
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建布局不同的ViewHolder
    class MyViewHolder0 extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvmatch;
        TextView tvrightteam;
        LinearLayout llytmatch;
        LinearLayout llytmatchvs;

        public MyViewHolder0(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_detail_item_title_rank);
            tvmatch = (TextView) itemView.findViewById(R.id.textview_detail_title_score_match);
            tvrightteam = (TextView) itemView.findViewById(R.id.textview_detail_title_vs_right);
            llytmatch = (LinearLayout) itemView.findViewById(R.id.linearlayout_detail_title_score);
            llytmatchvs = (LinearLayout) itemView.findViewById(R.id.linearlayout_detail_title_vs);
        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView tvLeftTeamName, tvRightTeamName, tvTime, tvLeftTriangle, tvRightTriangle;
        ProgressBar probarLeft, probarRight;

        public MyViewHolder1(View itemView) {
            super(itemView);
            tvLeftTeamName = (TextView) itemView.findViewById(R.id.textview_detail_item_left_team);
            tvRightTeamName = (TextView) itemView.findViewById(R.id.textview_detail_item_right_team);
            tvTime = (TextView) itemView.findViewById(R.id.textview_detail_item_time);
            tvLeftTriangle = (TextView) itemView.findViewById(R.id.textview_detail_left_triangle);
            tvRightTriangle = (TextView) itemView.findViewById(R.id.textview_detail_right_triangle);
            probarLeft = (ProgressBar) itemView.findViewById(R.id.progressbar_detail_item_left_team);
            probarRight = (ProgressBar) itemView.findViewById(R.id.progressbar_detail_item_right_team);
        }
    }

}
