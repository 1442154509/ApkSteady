package com.ui.ApkSteady.presenter;

import baselibs.mvp.BasePresenter;
import baselibs.net.BaseHttpResult;
import baselibs.net.BaseObserver2;
import baselibs.rx.RxSchedulers;

import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.model.DetailHistoryModel;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.FootBallDetailHistoryEntity;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.CompetionRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.utils.ConstantsUtils;
import com.ui.ApkSteady.ui.utils.FootBallDataUtil;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DetailHisttoryPresenter extends BasePresenter<DetailHistoryModel, DetailHistoryContract.DetailHistoryView> {

    @Override
    protected DetailHistoryModel createModel() {
        return new DetailHistoryModel();
    }

    public void getFootBallHistoryDetail(String matchId, String sportsId) {
        getModel().getFootBallHistoryDetail(matchId, sportsId)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<FootBallDetailRes>(getView()) {

                    @Override
                    public void onSuccess(BaseHttpResult<FootBallDetailRes> result) {
                        if (result.getData() == null) {
                            return;
                        }

                        List<FootBallDetailHistoryEntity> footBallDetailHistoryEntities = new ArrayList<>();
                        /*球队排名*/
                        if (result.getData().getRanks() != null && result.getData().getRanks().getHome() != null && result.getData().getRanks().getHome().size() > 0) {
                            FootBallDataUtil.rankSize = ((result.getData().getRanks().getHome().size() > 0 ? 1 : 0)
                                    + ((result.getData().getRanks().getAway() != null) ? (result.getData().getRanks().getAway().size() > 0 ? 1 : 0) : 0))
                                    + 1;
                            footBallDetailHistoryEntities.add(new FootBallDetailHistoryEntity(FootBallDetailHistoryEntity.TYPE_RANK));

                            FootBallDetailRes.RanksDTO.HomeDTO homeDTO = result.getData().getRanks().getHome().get(0);

                            FootBallDetailHistoryEntity footBallRank = new FootBallDetailHistoryEntity(DetailHistoryEntity.TYPE_RANK);

                            FootBallDetailHistoryEntity.RankDTO rankDTO = new FootBallDetailHistoryEntity.RankDTO();

                            rankDTO.setPosition(homeDTO.getPosition());
                            rankDTO.setPoints(homeDTO.getPoints());
                            rankDTO.setPlayed(homeDTO.getPlayed());
                            rankDTO.setWon(homeDTO.getWon());
                            rankDTO.setDrawn(homeDTO.getDrawn());
                            rankDTO.setLost(homeDTO.getLost());
                            rankDTO.setGoals(homeDTO.getGoals());
                            rankDTO.setAwayGoals(homeDTO.getAwayGoals());
                            rankDTO.setAgainst(homeDTO.getAgainst());
                            rankDTO.setDiff(homeDTO.getDiff());

                            footBallRank.setRank(rankDTO);
                            footBallDetailHistoryEntities.add(footBallRank);
                            /*客队排名*/
                            if (result.getData().getRanks() != null && result.getData().getRanks().getAway() != null && result.getData().getRanks().getAway().size() > 0) {
                                FootBallDetailHistoryEntity footBallRankAway = new FootBallDetailHistoryEntity(DetailHistoryEntity.TYPE_RANK);
                                FootBallDetailHistoryEntity.RankDTO rankDTOAway = new FootBallDetailHistoryEntity.RankDTO();
                                int position = 0;
                                FootBallDetailRes.RanksDTO.AwayDTO awayDTO = result.getData().getRanks().getAway().get(position);
                                rankDTOAway.setPosition(awayDTO.getPosition());
                                rankDTOAway.setPoints(awayDTO.getPoints());
                                rankDTOAway.setPlayed(awayDTO.getPlayed());
                                rankDTOAway.setWon(awayDTO.getWon());
                                rankDTOAway.setDrawn(awayDTO.getDrawn());
                                rankDTOAway.setLost(awayDTO.getLost());
                                rankDTOAway.setGoals(awayDTO.getGoals());
                                rankDTOAway.setAwayGoals(awayDTO.getAwayGoals());
                                rankDTOAway.setAgainst(awayDTO.getAgainst());
                                rankDTOAway.setDiff(awayDTO.getDiff());
                                footBallRankAway.setRank(rankDTOAway);
                                footBallDetailHistoryEntities.add(footBallRankAway);
                            }

//                            }
                        }
                        /*进球分布*/
                        if (result.getData().getGoalDistributions() != null && result.getData().getGoalDistributions().getHome().size() > 0
                                && result.getData().getGoalDistributions().getAway().size() > 0) {
                            for (FootBallDetailRes.GoalDistributionsDTO.HomeDTOX homeDTOX :
                                    result.getData().getGoalDistributions().getHome()) {
                                int position = result.getData().getGoalDistributions().getHome().indexOf(homeDTOX);
                                /*客队进球*/
                                FootBallDetailRes.GoalDistributionsDTO.AwayDTOX awayDTO = result.getData().getGoalDistributions().getAway().get(position);
                                /*分布对象*/
                                FootBallDetailHistoryEntity footBallDetailHistoryEntity = new FootBallDetailHistoryEntity(FootBallDetailHistoryEntity.TYPE_GOALDISTRIBUTIONS);
                                FootBallDetailHistoryEntity.GoalDistributionsDTO goalDistributionsDTO = new FootBallDetailHistoryEntity.GoalDistributionsDTO();

                                goalDistributionsDTO.setGoals_1_15_team_a(homeDTOX.getGoals_1_15());
                                goalDistributionsDTO.setGoals_1_15_team_b(awayDTO.getGoals_1_15());

                                goalDistributionsDTO.setGoals_16_30_team_a(homeDTOX.getGoals_16_30());
                                goalDistributionsDTO.setGoals_16_30_team_a(awayDTO.getGoals_16_30());

                                goalDistributionsDTO.setGoals_31_45_team_a(homeDTOX.getGoals_31_45());
                                goalDistributionsDTO.setGoals_31_45_team_b(awayDTO.getGoals_31_45());

                                goalDistributionsDTO.setGoals_46_60_team_a(homeDTOX.getGoals_46_60());
                                goalDistributionsDTO.setGoals_46_60_team_b(awayDTO.getGoals_46_60());

                                goalDistributionsDTO.setGoals_61_75_team_a(homeDTOX.getGoals_61_75());
                                goalDistributionsDTO.setGoals_61_75_team_b(awayDTO.getGoals_61_75());

                                goalDistributionsDTO.setGoals_76_90_team_a(homeDTOX.getGoals_76_90());
                                goalDistributionsDTO.setGoals_76_90_team_b(awayDTO.getGoals_76_90());

                                footBallDetailHistoryEntity.setGoalDistributions(goalDistributionsDTO);
                                footBallDetailHistoryEntities.add(footBallDetailHistoryEntity);
                            }
                        }
                        /*历史交锋*/
                        if (result.getData().getHistoryMatches() != null) {
                            if (result.getData().getHistoryMatches().getHistoryMatches() != null && result.getData().getHistoryMatches().getHistoryMatches().size() > 0) {
                                for (FootBallDetailRes.HistoryMatchesDTOX.HistoryMatchesDTO historyMatchesDTO :
                                        result.getData().getHistoryMatches().getHistoryMatches()) {
                                    FootBallDetailHistoryEntity footBallDetailHistoryEntity = new FootBallDetailHistoryEntity(FootBallDetailHistoryEntity.TYPE_HISTORYMATCHES);
                                    FootBallDetailHistoryEntity.HistoryMatches historyBattlesDTO = new FootBallDetailHistoryEntity.HistoryMatches();

                                    historyBattlesDTO.setMatchTime(historyMatchesDTO.getMatchTime());
                                    historyBattlesDTO.setLeagueName(historyMatchesDTO.getLeagueName());
                                    historyBattlesDTO.setHomeTeamName(historyMatchesDTO.getHomeTeamName());
                                    historyBattlesDTO.setHomeTeamLogo(historyMatchesDTO.getHomeTeamLogo());
                                    historyBattlesDTO.setAwayTeamName(historyMatchesDTO.getAwayTeamName());
                                    historyBattlesDTO.setAwayTeamLogo(historyMatchesDTO.getAwayTeamLogo());
                                    historyBattlesDTO.setHomeScoreHalf(historyMatchesDTO.getHomeScoreHalf());
                                    historyBattlesDTO.setAwayScoreHalf(historyMatchesDTO.getAwayScoreHalf());
                                    historyBattlesDTO.setHomeScore(historyMatchesDTO.getHomeScore());
                                    historyBattlesDTO.setAwayScore(historyMatchesDTO.getAwayScore());
                                    historyBattlesDTO.setHomeTeamId(historyMatchesDTO.getHomeTeamId());
                                    historyBattlesDTO.setAwayTeamId(historyMatchesDTO.getAwayTeamId());
                                    historyBattlesDTO.setLeagueId(historyMatchesDTO.getLeagueId());

                                    footBallDetailHistoryEntity.setHistoryMatches(historyBattlesDTO);
                                    footBallDetailHistoryEntities.add(footBallDetailHistoryEntity);
                                }
                            }

                        }
                        /*对战详情*/
                        if (result.getData().getHistoryMatches() != null) {
                            /*主队详情*/
                            if (result.getData().getHistoryMatches().getHomeHistoryMatches() != null && result.getData().getHistoryMatches().getHomeHistoryMatches().size() > 0) {
                                for (FootBallDetailRes.HistoryMatchesDTOX.HomeHistoryMatchesDTO historyMatchesDTO :
                                        result.getData().getHistoryMatches().getHomeHistoryMatches()) {
                                    FootBallDetailHistoryEntity footBallDetailHistoryEntity = new FootBallDetailHistoryEntity(FootBallDetailHistoryEntity.TYPE_MATCHDETAIL);
                                    FootBallDetailHistoryEntity.HistoryDetail historyDetail = new FootBallDetailHistoryEntity.HistoryDetail();

                                    historyDetail.setMatchTime(historyMatchesDTO.getMatchTime());
                                    historyDetail.setLeagueName(historyMatchesDTO.getLeagueName());
                                    historyDetail.setHomeTeamName(historyMatchesDTO.getHomeTeamName());
                                    historyDetail.setHomeTeamLogo(historyMatchesDTO.getHomeTeamLogo());
                                    historyDetail.setAwayTeamName(historyMatchesDTO.getAwayTeamName());
                                    historyDetail.setAwayTeamLogo(historyMatchesDTO.getAwayTeamLogo());
                                    historyDetail.setHomeScoreHalf(historyMatchesDTO.getHomeScoreHalf());
                                    historyDetail.setAwayScoreHalf(historyMatchesDTO.getAwayScoreHalf());
                                    historyDetail.setHomeScore(historyMatchesDTO.getHomeScore());
                                    historyDetail.setAwayScore(historyMatchesDTO.getAwayScore());
                                    historyDetail.setHomeTeamId(historyMatchesDTO.getHomeTeamId());
                                    historyDetail.setAwayTeamId(historyMatchesDTO.getAwayTeamId());
                                    historyDetail.setLeagueId(historyMatchesDTO.getLeagueId());

                                    footBallDetailHistoryEntity.setHistoryDetail(historyDetail);
                                    footBallDetailHistoryEntities.add(footBallDetailHistoryEntity);
                                }
                            }
                            /*客队详情*/
                            if (result.getData().getHistoryMatches().getAwayHistoryMatches() != null && result.getData().getHistoryMatches().getAwayHistoryMatches().size() > 0) {
                                for (FootBallDetailRes.HistoryMatchesDTOX.AwayHistoryMatchesDTO awayHistoryMatchesDTO :
                                        result.getData().getHistoryMatches().getAwayHistoryMatches()) {
                                    FootBallDetailHistoryEntity footBallDetailHistoryEntity = new FootBallDetailHistoryEntity(FootBallDetailHistoryEntity.TYPE_MATCHDETAIL);
                                    FootBallDetailHistoryEntity.HistoryDetail historyDetail = new FootBallDetailHistoryEntity.HistoryDetail();

                                    historyDetail.setMatchTime(awayHistoryMatchesDTO.getMatchTime());
                                    historyDetail.setLeagueName(awayHistoryMatchesDTO.getLeagueName());
                                    historyDetail.setHomeTeamName(awayHistoryMatchesDTO.getHomeTeamName());
                                    historyDetail.setHomeTeamLogo(awayHistoryMatchesDTO.getHomeTeamLogo());
                                    historyDetail.setAwayTeamName(awayHistoryMatchesDTO.getAwayTeamName());
                                    historyDetail.setAwayTeamLogo(awayHistoryMatchesDTO.getAwayTeamLogo());
                                    historyDetail.setHomeScoreHalf(awayHistoryMatchesDTO.getHomeScoreHalf());
                                    historyDetail.setAwayScoreHalf(awayHistoryMatchesDTO.getAwayScoreHalf());
                                    historyDetail.setHomeScore(awayHistoryMatchesDTO.getHomeScore());
                                    historyDetail.setAwayScore(awayHistoryMatchesDTO.getAwayScore());
                                    historyDetail.setHomeTeamId(awayHistoryMatchesDTO.getHomeTeamId());
                                    historyDetail.setAwayTeamId(awayHistoryMatchesDTO.getAwayTeamId());
                                    historyDetail.setLeagueId(awayHistoryMatchesDTO.getLeagueId());

                                    footBallDetailHistoryEntity.setHistoryDetail(historyDetail);
                                    footBallDetailHistoryEntities.add(footBallDetailHistoryEntity);
                                }
                            }
                        }
                        getView().updateFootBallUI(footBallDetailHistoryEntities);
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {

                    }

                });
    }

    public void getBasketBallHistoryDetail(String matchId, String sportsId) {
        getModel().getBasketBallHistoryDetail(matchId, sportsId)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<BasketBallDetailRes>(getView()) {

                    @Override
                    public void onSuccess(BaseHttpResult<BasketBallDetailRes> result) {
                        if (result.getData() == null) {
                            return;
                        }

                        ConstantsUtils.cleanRecordData();

                        List<DetailHistoryEntity> detailHistoryEntities = new ArrayList<>();
                        /*历史交锋*/
                        /*加上头部*/
                        if (result.getData().getHistoryMatches().getHistoryBattles() != null && result.getData().getHistoryMatches().getHistoryBattles().size() > 0) {
                            detailHistoryEntities.add(new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES));
                            ConstantsUtils.his_battler_size = result.getData().getHistoryMatches().getHistoryBattles().size() + 1;
                            for (BasketBallDetailRes.HistoryMatchesDTO.HistoryBattlesDTO historyMatchesDTO :
                                    result.getData().getHistoryMatches().getHistoryBattles()) {
                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES);
                                DetailHistoryEntity.HistoryBattlesDTO historyBattlesDTO = new DetailHistoryEntity.HistoryBattlesDTO();

                                historyBattlesDTO.setHomeTeamId(historyMatchesDTO.getHomeTeamId());
                                historyBattlesDTO.setAwayTeamId(historyMatchesDTO.getAwayTeamId());
                                historyBattlesDTO.setLeagueId(historyMatchesDTO.getLeagueId());
                                historyBattlesDTO.setMatchTime(historyMatchesDTO.getMatchTime());
                                historyBattlesDTO.setLeagueName(historyMatchesDTO.getLeagueName());
                                historyBattlesDTO.setHomeTeamName(historyMatchesDTO.getHomeTeamName());
                                historyBattlesDTO.setHomeTeamLogo(historyMatchesDTO.getHomeTeamLogo());
                                historyBattlesDTO.setAwayTeamName(historyMatchesDTO.getAwayTeamName());
                                historyBattlesDTO.setAwayTeamLogo(historyMatchesDTO.getAwayTeamLogo());
                                historyBattlesDTO.setHomeScore(historyMatchesDTO.getHomeScore());
                                historyBattlesDTO.setAwayScore(historyMatchesDTO.getAwayScore());
                                historyBattlesDTO.setHomeScoreH1(historyMatchesDTO.getHomeScoreH1());
                                historyBattlesDTO.setAwayScoreH1(historyMatchesDTO.getAwayScoreH1());

                                detailHistoryHistoryBattle.setHistoryBattles(historyBattlesDTO);
                                detailHistoryEntities.add(detailHistoryHistoryBattle);
                                if (historyMatchesDTO.getHomeScore() > historyMatchesDTO.getAwayScore()) {
                                    ConstantsUtils.his_battler_won++;
                                }
                                if (historyMatchesDTO.getHomeScore() == historyMatchesDTO.getAwayScore()) {
                                    ConstantsUtils.his_battler_drawn++;
                                }
                                if (historyMatchesDTO.getHomeScore() < historyMatchesDTO.getAwayScore()) {
                                    ConstantsUtils.his_battler_lost++;
                                }
                            }
                        }
                        /*近期战绩*/
                        if ((result.getData().getHistoryMatches().getHomeRecentBattles() != null || result.getData().getHistoryMatches().getAwayRecentBattles() != null) &&
                                (result.getData().getHistoryMatches().getHomeRecentBattles().size() > 0 || result.getData().getHistoryMatches().getAwayRecentBattles().size() > 0)) {
                            detailHistoryEntities.add(new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT));
                            ConstantsUtils.recent_size = 2;
                            /*主队数据*/
                            if (result.getData().getHistoryMatches().getHomeRecentBattles() != null && result.getData().getHistoryMatches().getHomeRecentBattles().size() > 0) {
                                List<Integer> winstate = new ArrayList<>();
                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT);
                                DetailHistoryEntity.RecentBattles recentBattles = new DetailHistoryEntity.RecentBattles();
                                for (BasketBallDetailRes.HistoryMatchesDTO.HomeRecentBattlesDTO homeRecentBattlesDTO :
                                        result.getData().getHistoryMatches().getHomeRecentBattles()) {
                                    /*主队主场作战*/
//                                    if (result.getData().getHomeTeamName().equals(homeRecentBattlesDTO.getHomeTeamName())) {
                                    if (homeRecentBattlesDTO.getHomeScore() > homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_won++;
                                        winstate.add(1);
                                    }
                                    if (homeRecentBattlesDTO.getHomeScore() == homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_drawn++;
                                        winstate.add(2);
                                    }
                                    if (homeRecentBattlesDTO.getHomeScore() < homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_lost++;
                                        winstate.add(3);
                                    }
//                                    }
//                                    else if(result.getData().getHomeTeamName().equals(homeRecentBattlesDTO.getHomeTeamName())){
//
//                                    }

                                    if (winstate.size() == 5) {
                                        break;
                                    }
                                }
                                recentBattles.setTeamname(result.getData().getHomeTeamName());
                                recentBattles.setTeamlogo(result.getData().getHomeTeamLogo());
                                recentBattles.setWin(ConstantsUtils.recent_won);
                                recentBattles.setDrawn(ConstantsUtils.recent_drawn);
                                recentBattles.setLost(ConstantsUtils.recent_lost);
                                recentBattles.setMatchwinstate(winstate);
                                detailHistoryHistoryBattle.setRecentBattles(recentBattles);
                                detailHistoryEntities.add(detailHistoryHistoryBattle);
                            }
                            /*客队数据*/
                            if (result.getData().getHistoryMatches().getAwayRecentBattles() != null && result.getData().getHistoryMatches().getAwayRecentBattles().size() > 0) {
                                List<Integer> winstate = new ArrayList<>();
                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT);
                                DetailHistoryEntity.RecentBattles recentBattles = new DetailHistoryEntity.RecentBattles();
                                ConstantsUtils.recent_size = 3;
                                for (BasketBallDetailRes.HistoryMatchesDTO.AwayRecentBattlesDTO awayRecentBattlesDTO :
                                        result.getData().getHistoryMatches().getAwayRecentBattles()) {

                                    if (awayRecentBattlesDTO.getHomeScore() > awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_away_won++;
                                        winstate.add(1);
                                    }
                                    if (awayRecentBattlesDTO.getHomeScore() == awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_away_drawn++;
                                        winstate.add(2);
                                    }
                                    if (awayRecentBattlesDTO.getHomeScore() < awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.recent_away_lost++;
                                        winstate.add(3);
                                    }

                                    if (winstate.size() == 5) {
                                        break;
                                    }
                                }
                                recentBattles.setTeamname(result.getData().getAwayTeamName());
                                recentBattles.setTeamlogo(result.getData().getAwayTeamLogo());
                                ConstantsUtils.recent_away_size = result.getData().getHistoryMatches().getAwayRecentBattles().size();
                                recentBattles.setWin(ConstantsUtils.recent_away_won);
                                recentBattles.setDrawn(ConstantsUtils.recent_away_drawn);
                                recentBattles.setLost(ConstantsUtils.recent_away_lost);
                                recentBattles.setMatchwinstate(winstate);
                                detailHistoryHistoryBattle.setRecentBattles(recentBattles);
                                detailHistoryEntities.add(detailHistoryHistoryBattle);
                            }
                        }
                        getView().updataBasketBallUI(detailHistoryEntities);
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {

                    }

                });
    }

    public void getCompetition(CompetitionReq body) {
        getModel().getCompetition(body)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<CompetionRes>>(getView()) {

                    @Override
                    public void onSuccess(BaseHttpResult<List<CompetionRes>> result) {
                        ToastUtils.show(result.getData().get(0).getLeagueName() + "比赛数据---");
                        LogUtils.e(result.getData().get(0).getLeagueName() + "比赛数据---");
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {
                        ToastUtils.show(errMsg + "错误数据---");
                        LogUtils.e(errMsg + "错误数据---");
                    }
                });
    }
}
