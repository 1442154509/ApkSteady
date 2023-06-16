package com.ui.ApkSteady.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.hazz.baselibs.base.BaseMvpActivity;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.presenter.DetailHisttoryPresenter;
import com.ui.ApkSteady.presenter.HomePresenter;
import com.ui.ApkSteady.ui.adapter.DetailMultiAdapter;
import com.ui.ApkSteady.ui.customview.LinearSpacingItemDecoration;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.MyData;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;
import com.ui.ApkSteady.ui.utils.ApiJsonRequest;
import com.ui.ApkSteady.ui.utils.DateUtils;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailActivity extends BaseMvpActivity<DetailHisttoryPresenter> implements DetailHistoryContract.DetailHistoryView {
    @BindView(R.id.vs_nodiscuss)
    ViewStub vsNodiscuss;
    @Nullable
    @BindView(R.id.vs_matchdata)
    ViewStub vsMatchdata;
    @BindView(R.id.tv_detail_match_leaguename)
    TextView tvLeagueName;
    @BindView(R.id.tv_team_name_a)
    TextView tvTeamAName;
    @BindView(R.id.tv_team_name_b)
    TextView tvTeamBName;
    @BindView(R.id.tv_yellow_a)
    TextView tvYellowA;
    @BindView(R.id.tv_red_a)
    TextView tvRedA;
    @BindView(R.id.tv_yellow_b)
    TextView tvYellowB;
    @BindView(R.id.tv_red_b)
    TextView tvRedB;
    @BindView(R.id.tv_detail_match_starttime)
    TextView tvMatchTime;
    @BindView(R.id.tv_detail_match_state)
    TextView tvMatchState;
    @BindView(R.id.tv_detail_match_score_a)
    TextView tvScoreA;
    @BindView(R.id.tv_detail_match_score_b)
    TextView tvScoreB;
    @BindView(R.id.tv_corner)
    TextView tvCorner;
    @BindView(R.id.ivdetail_match_leaguelogo)
    ImageView ivLeagueLogo;
    @BindView(R.id.iv_team_logo_a)
    ImageView ivTeamALogo;
    @BindView(R.id.iv_team_logo_b)
    ImageView ivTeamBLogo;
    @BindView(R.id.ll_video_playbg)
    LinearLayout llVideoPlay;
    @BindView(R.id.ll_detail_flag)
    LinearLayout llFlag;
    private int CONTAINSTATE = 2;//0无评论，1有评论，2比赛数据
    private List<MyData> list;
    private Bundle mBundle;
    private IndexRes data;
    private RecyclerView recyclerView;
    private List<DetailHistoryEntity> detailHistoryEntities;
    private DetailMultiAdapter detailMultiAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_matchdetail;
    }

    @Override
    protected void getIntent(Intent intent) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initMvp() {
        mBundle = getIntent().getExtras();
        data = (IndexRes) mBundle.getSerializable("IndexRes.Data");
        if (data == null) {
            data = new IndexRes();
        }
        tvLeagueName.setText(data.getMatchVediosInfo().getLeagueName());
        tvTeamAName.setText(data.getMatchVediosInfo().getHome());
        tvTeamBName.setText(data.getMatchVediosInfo().getAway());
        tvRedA.setText(String.valueOf(data.getMatchVediosInfo().getARed()));
        tvRedB.setText(String.valueOf(data.getMatchVediosInfo().getBRed()));
        tvYellowA.setText(String.valueOf(data.getMatchVediosInfo().getAYellow()));
        tvYellowB.setText(String.valueOf(data.getMatchVediosInfo().getBYellow()));
        Glide.with(this).load(data.getMatchVediosInfo().getLeagueLogo()).into(ivLeagueLogo);
        Glide.with(this).load(data.getMatchVediosInfo().getALogo()).into(ivTeamALogo);
        Glide.with(this).load(data.getMatchVediosInfo().getBLogo()).into(ivTeamBLogo);
        //赛事状态 ， 0.为开赛，1.开赛中，3.完赛
        if (data.getMatchVediosInfo().getMatchStatus() == 0) {
            tvMatchState.setText("未开始");
            tvScoreA.setText("-");
            tvScoreB.setText("-");
            tvMatchTime.setText("开赛时间 " + DateUtils.timeStampToSmdhm(data.getMatchVediosInfo().getMatchTime()));

            tvRedA.setVisibility(View.INVISIBLE);
            tvRedB.setVisibility(View.INVISIBLE);
            tvYellowA.setVisibility(View.INVISIBLE);
            tvYellowB.setVisibility(View.INVISIBLE);
            llFlag.setVisibility(View.INVISIBLE);
        } else if (data.getMatchVediosInfo().getMatchStatus() == 1) {
            tvMatchState.setText(":");
            tvScoreA.setText(String.valueOf(data.getMatchVediosInfo().getAScore()));
            tvScoreB.setText(String.valueOf(data.getMatchVediosInfo().getBScore()));
            tvMatchTime.setText(data.getMatchVediosInfo().getMatchType() + " " + data.getMatchVediosInfo().getRunTime());
            tvCorner.setText(data.getMatchVediosInfo().getACorner() + "-" + data.getMatchVediosInfo().getBCorner());
        } else if (data.getMatchVediosInfo().getMatchStatus() == 2) {
            tvMatchState.setText(":");
            tvScoreA.setText(String.valueOf(data.getMatchVediosInfo().getAScore()));
            tvScoreB.setText(String.valueOf(data.getMatchVediosInfo().getBScore()));
            tvMatchTime.setText("开赛时间 " + DateUtils.timeStampToSmdhm(data.getMatchVediosInfo().getMatchTime()));
            tvCorner.setText(data.getMatchVediosInfo().getACorner() + "-" + data.getMatchVediosInfo().getBCorner());
        }

        if (data.getMatchVediosInfo().isIsLive() && !TextUtils.isEmpty(data.getMatchVediosInfo().getLiveUrl())) {
            llVideoPlay.setVisibility(View.VISIBLE);

        } else {
            llVideoPlay.setVisibility(View.INVISIBLE);
        }

        switch (CONTAINSTATE) {
            case 0:
                vsNodiscuss = (ViewStub) findViewById(R.id.vs_nodiscuss);
                vsNodiscuss.inflate();
                break;
            case 1:
                break;
            case 2:
//                vsMatchdata = (ViewStub) findViewById(R.id.vs_matchdata);
                vsMatchdata.inflate();

                recyclerView = (RecyclerView) findViewById(R.id.detail_match_item);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
//                createData();
                recyclerView.addItemDecoration(new LinearSpacingItemDecoration(this, 10));
//                DetailMatchAdapter adapter = new DetailMatchAdapter(this, list);
//                recyclerView.setAdapter(adapter);

                break;
            default:
                vsNodiscuss = (ViewStub) findViewById(R.id.vs_nodiscuss);
                vsNodiscuss.inflate();
        }
//        questdetail(data.getMatchId(), data.getSportsId());
        try {
            detailHistoryEntities = new ArrayList<>();
            detailMultiAdapter = new DetailMultiAdapter(detailHistoryEntities);
            recyclerView.setAdapter(detailMultiAdapter);
            if (data.getSportsId() == 1) {
                mPresenter.getFootBallHistoryDetail(String.valueOf(data.getMatchId()), String.valueOf(data.getSportsId()));
            } else if (data.getSportsId() == 2) {
                mPresenter.getBasketBallHistoryDetail(String.valueOf(data.getMatchId()), String.valueOf(data.getSportsId()));
            }

//            detailMultiAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void questdetail(int matchId, int sportsId) {
//        List<DetailHistoryEntity> detailHistoryEntities = new ArrayList<>();
//        DetailMultiAdapter detailMultiAdapter = new DetailMultiAdapter(detailHistoryEntities);
////        rvhome.addItemDecoration(new LinearSpacingItemDecoration(getActivity(), 20));
////        rvhome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        recyclerView.setAdapter(detailMultiAdapter);
//        if (sportsId == 1) {
//            ApiJsonRequest<FootBallDetailRes> apiJsonRequest = new ApiJsonRequest<>(
//                    "http://34.80.205.147:12300/Api/Detail/Football?matchId=" + matchId + "&sportsId=1", new com.android.volley.Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    LogUtils.e(error.toString());
//                    ToastUtils.show(error.toString());
//                }
//            }, new Response.Listener<FootBallDetailRes>() {
//                @Override
//                public void onResponse(FootBallDetailRes response) {
//                    for (FootBallDetailRes.DataDTO.GoalDistributionsDTO.HomeDTOX homeDTOX :
//                            response.getData().getGoalDistributions().getHome()) {
//                        int position = response.getData().getGoalDistributions().getHome().indexOf(homeDTOX);
//                        FootBallDetailRes.DataDTO.GoalDistributionsDTO.AwayDTOX awayDTOX = response.getData().getGoalDistributions().getAway().get(position);
//
//                        DetailHistoryEntity detailHistoryEntity = new DetailHistoryEntity(DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS);
//                        DetailHistoryEntity.GoalDistributionsDTO goalDistributionsDTO = new DetailHistoryEntity.GoalDistributionsDTO();
//
//                        goalDistributionsDTO.setGoals_1_15_team_a(homeDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_16_30_team_a(homeDTOX.getGoals_16_30());
//                        goalDistributionsDTO.setGoals_31_45_team_a(homeDTOX.getGoals_31_45());
//                        goalDistributionsDTO.setGoals_46_60_team_a(homeDTOX.getGoals_46_60());
//                        goalDistributionsDTO.setGoals_61_75_team_a(homeDTOX.getGoals_61_75());
//                        goalDistributionsDTO.setGoals_76_90_team_a(homeDTOX.getGoals_76_90());
//
//
//                        goalDistributionsDTO.setGoals_1_15_team_b(awayDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_16_30_team_b(awayDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_31_45_team_b(awayDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_46_60_team_b(awayDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_61_75_team_b(awayDTOX.getGoals_1_15());
//                        goalDistributionsDTO.setGoals_76_90_team_b(awayDTOX.getGoals_1_15());
//
////                        DetailHistoryEntity.RankDTO rankDTO = new DetailHistoryEntity.RankDTO();
////                        rankDTO.setAgainst(ranksDTO.getAgainst());
////                        rankDTO.setDiff(ranksDTO.getDiff());
////                        rankDTO.setLost(ranksDTO.getLost());
////                        rankDTO.setDrawn(ranksDTO.getDrawn());
////                        rankDTO.setGoals(ranksDTO.getGoals());
////                        rankDTO.setPlayed(ranksDTO.getPlayed());
////                        rankDTO.setPoints(ranksDTO.getPoints());
////                        rankDTO.setWon(ranksDTO.getWon());
////                        rankDTO.setAwayGoals(ranksDTO.getAwayGoals());
////                        rankDTO.setTeamtype(response.getData().getRanks().getHome().size() > 0 ? 1 : 0);
//
//                        detailHistoryEntity.setGoalDistributions(goalDistributionsDTO);
//                        detailHistoryEntities.add(detailHistoryEntity);
//                    }
//                    detailMultiAdapter.setNewData(detailHistoryEntities);
//                    detailMultiAdapter.notifyDataSetChanged();
//                    LogUtils.e(response.getData().getGameInfoId() + "");
//                }
//            }, FootBallDetailRes.class);
//            addVolleyResQue(apiJsonRequest);
//        } else {
//            ApiJsonRequest<BasketBallDetailRes> apiJsonRequest = new ApiJsonRequest<>(
//                    "http://34.80.205.147:12300/Api/Detail/Basketball?matchId=" + matchId + "&sportsId=2", new com.android.volley.Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    LogUtils.e(error.toString());
//                    ToastUtils.show(error.toString());
//                }
//            }, new Response.Listener<BasketBallDetailRes>() {
//                @Override
//                public void onResponse(BasketBallDetailRes response) {
//                    for (BasketBallDetailRes.DataDTO.HistoryMatchesDTO.HistoryBattlesDTO historyBattlesDTO :
//                            response.getData().getHistoryMatches().getHistoryBattles()) {
//
//                        DetailHistoryEntity detailHistoryEntity = new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES);
//
//                        detailHistoryEntity.setHistoryBattles(historyBattlesDTO);
//                        detailHistoryEntities.add(detailHistoryEntity);
//                    }
//                    detailMultiAdapter.setNewData(detailHistoryEntities);
//                    detailMultiAdapter.notifyDataSetChanged();
//                    LogUtils.e(response.getData().getMatchTime() + "");
//                }
//            }, BasketBallDetailRes.class);
//            addVolleyResQue(apiJsonRequest);
//        }
//
//    }

    //创造数据
    private void createData() {
        //球队排名,进球分布,历史交锋,近期战绩,对战详情
        list = new ArrayList<>();
        MyData data1 = new MyData("球队排名", R.mipmap.detail_team_logo_england, 0);
        MyData data2 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 0);
        MyData data3 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 0);
        MyData data4 = new MyData("进球分布", R.mipmap.detail_team_logo_england, 1);
        MyData data5 = new MyData("布莱顿VS", R.mipmap.detail_team_logo_england, 1);
        MyData data6 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 1);
        MyData data7 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data8 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data9 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data10 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data11 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data12 = new MyData("历史交锋", R.mipmap.detail_team_logo_england, 2);
        MyData data13 = new MyData("莱斯特城his", R.mipmap.detail_team_logo_england, 2);
        MyData data14 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data15 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data16 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data17 = new MyData("近期战绩", R.mipmap.detail_team_logo_england, 3);
        MyData data18 = new MyData("莱斯特城绩VS", R.mipmap.detail_team_logo_england, 3);
        MyData data19 = new MyData("布莱顿VS", R.mipmap.detail_team_logo_england, 3);
        MyData data20 = new MyData("对战详情", R.mipmap.detail_team_logo_england, 4);
        MyData data21 = new MyData("莱斯特城his", R.mipmap.detail_team_logo_england, 4);
        MyData data22 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data23 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data24 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data25 = new MyData("布莱顿his", R.mipmap.detail_team_logo_england, 4);
        MyData data26 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);
        MyData data27 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);
        MyData data28 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);

        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);
        list.add(data7);
        list.add(data8);
        list.add(data9);
        list.add(data10);
        list.add(data11);
        list.add(data12);
        list.add(data13);
        list.add(data14);
        list.add(data15);
        list.add(data16);
        list.add(data17);
        list.add(data18);
        list.add(data19);
        list.add(data20);
        list.add(data21);
        list.add(data22);
        list.add(data23);
        list.add(data24);
        list.add(data25);
        list.add(data26);
        list.add(data27);
        list.add(data28);

    }

    @OnClick(R.id.iv_detail_back)
    public void onClick() {
        finish();
    }

    @Override
    public void upataFootBallUI(List<DetailHistoryEntity> data) {
        detailHistoryEntities.addAll(data);
        detailMultiAdapter.setNewData(detailHistoryEntities);
        detailMultiAdapter.notifyDataSetChanged();

    }

    @Override
    public void updataBasketBallUI(List<DetailHistoryEntity> data) {
        detailHistoryEntities.addAll(data);
        detailMultiAdapter.setNewData(detailHistoryEntities);
        detailMultiAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    protected DetailHisttoryPresenter createPresenter() {
        return new DetailHisttoryPresenter();
    }
}