package com.ui.ApkSteady.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
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
                View view = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_title_rank, parent, false);
                MyViewHolder0 viewHolder0 = new MyViewHolder0(view);
                return viewHolder0;
            case 1:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_processbar, parent, false);
                MyViewHolder1 viewHolder1 = new MyViewHolder1(view1);
                return viewHolder1;
            case 2:
                View view2 = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_history, parent, false);
                MyViewHolder2 viewHolder2 = new MyViewHolder2(view2);
                return viewHolder2;
            case 3:
                View view3 = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_recent, parent, false);
                MyViewHolder3 viewHolder3 = new MyViewHolder3(view3);
                return viewHolder3;
            case 4:
                View view4 = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item_history, parent, false);
                MyViewHolder4 viewHolder4 = new MyViewHolder4(view4);
                return viewHolder4;
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
                if (data.getText().equals("球队排名")) {
                    holder0.llytmatch.setVisibility(View.VISIBLE);
                    holder0.llytmatchvs.setVisibility(View.GONE);
                    holder0.tvTitle.setText(data.getText());
                } else {
                    holder0.llytmatch.setVisibility(View.VISIBLE);
                    holder0.llytmatchvs.setVisibility(View.VISIBLE);

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder0.tvTitle.setText(data.getText());
                    holder0.tvTitle.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder0.tvrightteam.setText(data.getText());
                    holder0.tvrightteam.setCompoundDrawablesWithIntrinsicBounds(null, null, top, null);
                    holder0.tvTitle.setTextSize(15);
                    holder0.llytmatchvs.setVisibility(View.GONE);
                }

                break;
            case 1:
                MyViewHolder1 holder1 = (MyViewHolder1) holder;
                if (data.getText().equals("进球分布")) {
                    setHold1Visible(View.VISIBLE, holder1.llyttitle);
                    setHold1Visible(View.GONE, holder1.llytteamvs, holder1.ctytprocess);

                    holder1.tvTitle.setText(data.getText());



                } else if (data.getText().contains("VS")) {
                    setHold1Visible(View.GONE, holder1.llyttitle, holder1.ctytprocess);
                    setHold1Visible(View.VISIBLE, holder1.llytteamvs);

                    holder1.tvteama.setText(data.getText().replace("VS", ""));
                    holder1.tvteamb.setText(data.getText().replace("VS", ""));

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder1.tvteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder1.tvteamb.setCompoundDrawablesWithIntrinsicBounds(null, null, top, null);
                } else {
                    setHold1Visible(View.GONE, holder1.llyttitle, holder1.llytteamvs);
                    setHold1Visible(View.VISIBLE, holder1.ctytprocess);
                    holder1.tvTime.setText("1-15分钟");
                    holder1.probara.setProgress(60);
                    holder1.probarb.setProgress(100);

                    if (holder1.probara.getProgress() == 100) {
                        holder1.tvTrianglea.setBackgroundResource(R.drawable.detail_item_progressbar_left_tr_red);
                    } else if (holder1.probara.getProgress() != 100) {
                        holder1.tvTrianglea.setBackgroundResource(R.drawable.detail_item_progressbar_left_tr_white);
                    }
                    if (holder1.probarb.getProgress() == 100) {
                        holder1.tvTriangleb.setBackgroundResource(R.drawable.detail_item_progressbar_right_tr_blue);
                    } else if (holder1.probarb.getProgress() != 100) {
                        holder1.tvTriangleb.setBackgroundResource(R.drawable.detail_item_progressbar_right_tr_white);
                    }

                }
                break;
            case 2:
                MyViewHolder2 holder2 = (MyViewHolder2) holder;
                if (data.getText().equals("历史交锋")) {
                    setHold1Visible(View.VISIBLE, holder2.llyttitle);
                    setHold1Visible(View.GONE, holder2.llyt5match, holder2.ctytdata);

                    holder2.tvTitle.setText(data.getText());

                } else if (data.getText().contains("his")) {
                    setHold1Visible(View.GONE, holder2.llyttitle, holder2.ctytdata);
                    setHold1Visible(View.VISIBLE, holder2.llyt5match);

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder2.tvTitle.setTextSize(15);
                    holder2.tvTitle.setText(data.getText().replace("his", ""));
                    holder2.tvTitle.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);

                    holder2.tvtitleteama.setText(data.getText().replace("his", ""));
                    holder2.tvtitleteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);

                    holder2.tvvictort.setText("1胜");
                    holder2.tvpure.setText("1平");
                    holder2.tvrank.setText("1负");
                } else {
                    setHold1Visible(View.GONE, holder2.llyttitle, holder2.llyt5match);
                    setHold1Visible(View.VISIBLE, holder2.ctytdata);

                    holder2.tvmsg.setText("2021-09-23  11:30  西甲");

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder2.tvteama.setText(data.getText().replace("VS", ""));
                    holder2.tvteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder2.tvteamb.setText(data.getText().replace("VS", ""));
                    holder2.tvteamb.setCompoundDrawablesWithIntrinsicBounds(null, null, top, null);
                    holder2.tvmidscore.setText("5 : 3");
                    holder2.tvtitleteama.setText(data.getText().replace("VS", ""));
                }
                break;
            case 3:
                MyViewHolder3 holder3 = (MyViewHolder3) holder;
                if (data.getText().equals("近期战绩")) {
                    setHold1Visible(View.VISIBLE, holder3.llyttitle, holder3.tvTitle5match);
                    setHold1Visible(View.GONE, holder3.conlayoutrecent, holder3.llyt5match);
                    holder3.tvTitle.setText(data.getText());
                } else if (data.getText().contains("VS")) {
                    setHold1Visible(View.VISIBLE, holder3.llyt5match);
                    setHold1Visible(View.GONE, holder3.llyttitle);

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder3.tvtitleteama.setText(data.getText().replace("VS", ""));
                    holder3.tvtitleteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                } else {
                    setHold1Visible(View.GONE, holder3.llyttitle);
                    setHold1Visible(View.VISIBLE, holder3.conlayoutrecent, holder3.llyt5match);
                }
                break;
            case 4:
                MyViewHolder4 holder4 = (MyViewHolder4) holder;
                if (data.getText().equals("对战详情")) {
                    setHold1Visible(View.VISIBLE, holder4.llyttitle);
                    setHold1Visible(View.GONE, holder4.llyt5match, holder4.ctytdata);

                    holder4.tvTitle.setText(data.getText());

                } else if (data.getText().contains("his")) {
                    setHold1Visible(View.GONE, holder4.llyttitle, holder4.ctytdata);
                    setHold1Visible(View.VISIBLE, holder4.llyt5match);

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder4.tvTitle.setTextSize(15);
                    holder4.tvTitle.setText(data.getText().replace("his", ""));
                    holder4.tvTitle.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);

                    holder4.tvtitleteama.setText(data.getText().replace("his", ""));
                    holder4.tvtitleteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);

                    holder4.tvvictort.setText("1胜");
                    holder4.tvpure.setText("1平");
                    holder4.tvrank.setText("1负");
                } else {
                    setHold1Visible(View.GONE, holder4.llyttitle, holder4.llyt5match);
                    setHold1Visible(View.VISIBLE, holder4.ctytdata);

                    holder4.tvmsg.setText("2021-09-23  11:30  西甲");

                    Drawable top = AppCompatResources.getDrawable(mContext, data.getImage());
                    holder4.tvteama.setText(data.getText().replace("VS", ""));
                    holder4.tvteama.setCompoundDrawablesWithIntrinsicBounds(top, null, null, null);
                    holder4.tvteamb.setText(data.getText().replace("VS", ""));
                    holder4.tvteamb.setCompoundDrawablesWithIntrinsicBounds(null, null, top, null);
                    holder4.tvmidscore.setText("5 : 3");
                    holder4.tvtitleteama.setText(data.getText().replace("VS", ""));
                }
                break;
        }


    }

    private void setHold1Visible(int visiable, View... holder1) {
        for (View h1 :
                holder1) {
            h1.setVisibility(visiable);
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
        //比分列表
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
        TextView tvScorea, tvScoreb, tvTime, tvTrianglea, tvTriangleb,tvteama,tvteamb;

        ProgressBar probara, probarb;
        //顶部数据
        TextView tvTitle;
        LinearLayout llyttitle, llytteamvs;
        ConstraintLayout ctytprocess;
        //比分列表

        public MyViewHolder1(View itemView) {
            super(itemView);
            llyttitle = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title);
            llytteamvs = (LinearLayout) itemView.findViewById(R.id.linearlayout_detail_item_vs);
            ctytprocess = (ConstraintLayout) itemView.findViewById(R.id.constraintnlayout_detail_process_data);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_detail_item_title);


            tvScorea = (TextView) itemView.findViewById(R.id.textview_detail_item_score_a);
            tvScoreb = (TextView) itemView.findViewById(R.id.textview_detail_item_score_b);
            tvTime = (TextView) itemView.findViewById(R.id.textview_detail_item_time);
            tvTrianglea = (TextView) itemView.findViewById(R.id.textview_detail_triangle_a);
            tvTriangleb = (TextView) itemView.findViewById(R.id.textview_detail_triangle_b);
            probara = (ProgressBar) itemView.findViewById(R.id.progressbar_detail_item_team_a);
            probarb = (ProgressBar) itemView.findViewById(R.id.progressbar_detail_item_team_b);
            tvteama = (TextView) itemView.findViewById(R.id.textView_detail_history_team_a);
            tvteamb = (TextView) itemView.findViewById(R.id.textView_detail_history_team_b);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        //顶部数据
        TextView tvTitle, tvmatch, tvtitleteama;
        TextView tvscore, tvvictort, tvpure, tvrank;
        //比分列表
        LinearLayout llyttitle;
        LinearLayout llyt5match;
        ConstraintLayout ctytdata;
        TextView tvmsg, tvteama, tvmidscore, tvteamb, tvwin;

        public MyViewHolder2(View itemView) {
            super(itemView);
            llyttitle = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_detail_item_title);
//
            tvtitleteama = (TextView) itemView.findViewById(R.id.textview_detail_item_title_team_a);
            tvmatch = (TextView) itemView.findViewById(R.id.textview_detail_title_score_match);
            tvvictort = (TextView) itemView.findViewById(R.id.textview_detail_title_score_victort);
            tvscore = (TextView) itemView.findViewById(R.id.textview_detail_title_score_score);
            tvpure = (TextView) itemView.findViewById(R.id.textview_detail_title_score_pure);
            tvrank = (TextView) itemView.findViewById(R.id.textview_detail_title_score_rank2);

            llyt5match = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title5match);


            ctytdata = (ConstraintLayout) itemView.findViewById(R.id.constraintnlayout_detail_history_data);

            tvmsg = (TextView) itemView.findViewById(R.id.textView_detail_history_msg);
            tvmidscore = (TextView) itemView.findViewById(R.id.textView_detail_history_team_score);
            tvteama = (TextView) itemView.findViewById(R.id.textView_detail_history_team_a);
            tvteamb = (TextView) itemView.findViewById(R.id.textView_detail_history_team_b);
            tvwin = (TextView) itemView.findViewById(R.id.textView_detail_win);
        }
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder {
        //头部区
        LinearLayout llyttitle;
        TextView tvTitle, tvtitleteama, tvTitle5match;
        LinearLayout llyt5match;
        //胜率区
        TextView tvratenum1, tvratenum2, tvratenum3, tvrmatchstate1, tvrmatchstate2, tvrmatchstate3, tvrmatchstate4, tvrmatchstate5;
        ConstraintLayout conlayoutrecent;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            llyttitle = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_detail_item_title);
            tvTitle5match = (TextView) itemView.findViewById(R.id.textview_detail_title_5match);


            llyt5match = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title5match);
            tvtitleteama = (TextView) itemView.findViewById(R.id.textview_detail_item_title_team_a);

            conlayoutrecent = (ConstraintLayout) itemView.findViewById(R.id.linearlayout_detail_item_recent);
            tvratenum1 = (TextView) itemView.findViewById(R.id.textView_recent_win_ratenum1);
            tvratenum2 = (TextView) itemView.findViewById(R.id.textView_recent_win_ratenum2);
            tvratenum3 = (TextView) itemView.findViewById(R.id.textView_recent_win_ratenum3);
            tvrmatchstate1 = (TextView) itemView.findViewById(R.id.textView_recent_match_state1);
            tvrmatchstate2 = (TextView) itemView.findViewById(R.id.textView_recent_match_state2);
            tvrmatchstate3 = (TextView) itemView.findViewById(R.id.textView_recent_match_state3);
            tvrmatchstate4 = (TextView) itemView.findViewById(R.id.textView_recent_match_state4);
            tvrmatchstate5 = (TextView) itemView.findViewById(R.id.textView_recent_match_state5);
        }
    }
    class MyViewHolder4 extends RecyclerView.ViewHolder {

        //顶部数据
        TextView tvTitle, tvmatch, tvtitleteama;
        TextView tvscore, tvvictort, tvpure, tvrank;
        //比分列表
        LinearLayout llyttitle;
        LinearLayout llyt5match;
        ConstraintLayout ctytdata;
        TextView tvmsg, tvteama, tvmidscore, tvteamb, tvwin;

        public MyViewHolder4(View itemView) {
            super(itemView);
            llyttitle = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_detail_item_title);
//
            tvtitleteama = (TextView) itemView.findViewById(R.id.textview_detail_item_title_team_a);
            tvmatch = (TextView) itemView.findViewById(R.id.textview_detail_title_score_match);
            tvvictort = (TextView) itemView.findViewById(R.id.textview_detail_title_score_victort);
            tvscore = (TextView) itemView.findViewById(R.id.textview_detail_title_score_score);
            tvpure = (TextView) itemView.findViewById(R.id.textview_detail_title_score_pure);
            tvrank = (TextView) itemView.findViewById(R.id.textview_detail_title_score_rank2);

            llyt5match = (LinearLayout) itemView.findViewById(R.id.detail_list_item_title5match);


            ctytdata = (ConstraintLayout) itemView.findViewById(R.id.constraintnlayout_detail_history_data);

            tvmsg = (TextView) itemView.findViewById(R.id.textView_detail_history_msg);
            tvmidscore = (TextView) itemView.findViewById(R.id.textView_detail_history_team_score);
            tvteama = (TextView) itemView.findViewById(R.id.textView_detail_history_team_a);
            tvteamb = (TextView) itemView.findViewById(R.id.textView_detail_history_team_b);
            tvwin = (TextView) itemView.findViewById(R.id.textView_detail_win);
        }
    }
}
