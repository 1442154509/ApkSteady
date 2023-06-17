package com.ui.ApkSteady.presenter;

import com.hazz.baselibs.mvp.BasePresenter;
import com.hazz.baselibs.net.BaseHttpResult;
import com.hazz.baselibs.net.BaseObserver2;
import com.hazz.baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.model.DetailHistoryModel;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.CompetionRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.utils.ConstantsUtils;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;

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
                        List<DetailHistoryEntity> detailHistoryEntities = new ArrayList<>();
                        for (FootBallDetailRes.RanksDTO.HomeDTO homeDTO : result.getData().getRanks().getHome()) {
                            DetailHistoryEntity detailHistoryGoal = new DetailHistoryEntity(DetailHistoryEntity.TYPE_GOALDISTRIBUTIONS);
                            DetailHistoryEntity detailHistoryRank = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RANK);
                            DetailHistoryEntity detailHistoryRankAway = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RANK);

                            DetailHistoryEntity.GoalDistributionsDTO goalDistributionsDTO = new DetailHistoryEntity.GoalDistributionsDTO();
                            DetailHistoryEntity.RankDTO rankDTO = new DetailHistoryEntity.RankDTO();
                            DetailHistoryEntity.RankDTO rankDTOAway = new DetailHistoryEntity.RankDTO();

//                            for (FootBallDetailRes.RanksDTO.HomeDTO homeDTO :
//                                    footBallDetailRes.getRanks().getHome()) {
                            int position = result.getData().getRanks().getHome().indexOf(homeDTO);
                            FootBallDetailRes.RanksDTO.AwayDTO awayDTO = result.getData().getRanks().getAway().get(position);

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
//                            }

                            detailHistoryRank.setRank(rankDTO);
                            detailHistoryRankAway.setRank(rankDTOAway);
                            detailHistoryGoal.setGoalDistributions(goalDistributionsDTO);
                            detailHistoryEntities.add(detailHistoryGoal);
                            detailHistoryEntities.add(detailHistoryRank);
                            detailHistoryEntities.add(detailHistoryRankAway);
                        }
                        getView().upataFootBallUI(detailHistoryEntities);
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
                        ConstantsUtils.cleanHisBattlerData();
                        ConstantsUtils.cleanRecentData();

                        List<DetailHistoryEntity> detailHistoryEntities = new ArrayList<>();
                        /*历史交锋*/
                        //加上头部
//                        if (result.getData().getHistoryMatches().getHistoryBattles() != null && result.getData().getHistoryMatches().getHistoryBattles().size() > 0) {
//                            ConstantsUtils.his_battler_size = result.getData().getHistoryMatches().getHistoryBattles().size();
//                            detailHistoryEntities.add(new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES));
//                            for (BasketBallDetailRes.HistoryMatchesDTO.HistoryBattlesDTO historyMatchesDTO :
//                                    result.getData().getHistoryMatches().getHistoryBattles()) {
//                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES);
//                                DetailHistoryEntity.HistoryBattlesDTO historyBattlesDTO = new DetailHistoryEntity.HistoryBattlesDTO();
//
//                                historyBattlesDTO.setHomeTeamId(historyMatchesDTO.getHomeTeamId());
//                                historyBattlesDTO.setAwayTeamId(historyMatchesDTO.getAwayTeamId());
//                                historyBattlesDTO.setLeagueId(historyMatchesDTO.getLeagueId());
//                                historyBattlesDTO.setMatchTime(historyMatchesDTO.getMatchTime());
//                                historyBattlesDTO.setLeagueName(historyMatchesDTO.getLeagueName());
//                                historyBattlesDTO.setHomeTeamName(historyMatchesDTO.getHomeTeamName());
//                                historyBattlesDTO.setHomeTeamLogo(historyMatchesDTO.getHomeTeamLogo());
//                                historyBattlesDTO.setAwayTeamName(historyMatchesDTO.getAwayTeamName());
//                                historyBattlesDTO.setAwayTeamLogo(historyMatchesDTO.getAwayTeamLogo());
//                                historyBattlesDTO.setHomeScore(historyMatchesDTO.getHomeScore());
//                                historyBattlesDTO.setAwayScore(historyMatchesDTO.getAwayScore());
//                                historyBattlesDTO.setHomeScoreH1(historyMatchesDTO.getHomeScoreH1());
//                                historyBattlesDTO.setAwayScoreH1(historyMatchesDTO.getAwayScoreH1());
//
//                                detailHistoryHistoryBattle.setHistoryBattles(historyBattlesDTO);
//                                detailHistoryEntities.add(detailHistoryHistoryBattle);
//                                if (historyMatchesDTO.getHomeScore() > historyMatchesDTO.getAwayScore()) {
//                                    ConstantsUtils.his_battler_won++;
//                                }
//                                if (historyMatchesDTO.getHomeScore() == historyMatchesDTO.getAwayScore()) {
//                                    ConstantsUtils.his_battler_drawn++;
//                                }
//                                if (historyMatchesDTO.getHomeScore() < historyMatchesDTO.getAwayScore()) {
//                                    ConstantsUtils.his_battler_lost++;
//                                }
//                            }
//                        }
                        /*近期战绩*/
                        if ((result.getData().getHistoryMatches().getHomeRecentBattles() != null || result.getData().getHistoryMatches().getAwayRecentBattles() != null) &&
                                (result.getData().getHistoryMatches().getHomeRecentBattles().size() > 0 || result.getData().getHistoryMatches().getAwayRecentBattles().size() > 0)) {
                            ConstantsUtils.his_battler_size = result.getData().getHistoryMatches().getHistoryBattles().size();
                            detailHistoryEntities.add(new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT));
                            /*主队数据*/
                            if (result.getData().getHistoryMatches().getHomeRecentBattles() != null && result.getData().getHistoryMatches().getHomeRecentBattles().size() > 0) {
                                List<Integer> winstate = new ArrayList<>();
                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT);
                                DetailHistoryEntity.RecentBattles recentBattles = new DetailHistoryEntity.RecentBattles();
                                for (BasketBallDetailRes.HistoryMatchesDTO.HomeRecentBattlesDTO homeRecentBattlesDTO :
                                        result.getData().getHistoryMatches().getHomeRecentBattles()) {

                                    if (homeRecentBattlesDTO.getHomeScore() > homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_home_won++;
                                        winstate.add(1);
                                    }
                                    if (homeRecentBattlesDTO.getHomeScore() == homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_home_drawn++;
                                        winstate.add(2);
                                    }
                                    if (homeRecentBattlesDTO.getHomeScore() < homeRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_home_lost++;
                                        winstate.add(3);
                                    }
                                    recentBattles.setTeamname(homeRecentBattlesDTO.getHomeTeamName());
                                    recentBattles.setTeamlogo(homeRecentBattlesDTO.getHomeTeamLogo());
                                    if (winstate.size() == 5) {
                                        break;
                                    }
                                }
                                ConstantsUtils.his_recent_home_size = result.getData().getHistoryMatches().getHomeRecentBattles().size();
                                recentBattles.setWin(ConstantsUtils.his_recent_home_won);
                                recentBattles.setDrawn(ConstantsUtils.his_recent_home_drawn);
                                recentBattles.setLost(ConstantsUtils.his_recent_home_lost);
                                recentBattles.setMatchwinstate(winstate);
                                detailHistoryHistoryBattle.setRecentBattles(recentBattles);
                                detailHistoryEntities.add(detailHistoryHistoryBattle);
                            }
                            /*客队数据*/
                            if (result.getData().getHistoryMatches().getAwayRecentBattles() != null && result.getData().getHistoryMatches().getAwayRecentBattles().size() > 0) {
                                List<Integer> winstate = new ArrayList<>();
                                DetailHistoryEntity detailHistoryHistoryBattle = new DetailHistoryEntity(DetailHistoryEntity.TYPE_RECENT);
                                DetailHistoryEntity.RecentBattles recentBattles = new DetailHistoryEntity.RecentBattles();
                                for (BasketBallDetailRes.HistoryMatchesDTO.AwayRecentBattlesDTO awayRecentBattlesDTO :
                                        result.getData().getHistoryMatches().getAwayRecentBattles()) {

                                    if (awayRecentBattlesDTO.getHomeScore() > awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_away_won++;
                                        winstate.add(1);
                                    }
                                    if (awayRecentBattlesDTO.getHomeScore() == awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_away_drawn++;
                                        winstate.add(2);
                                    }
                                    if (awayRecentBattlesDTO.getHomeScore() < awayRecentBattlesDTO.getAwayScore()) {
                                        ConstantsUtils.his_recent_away_lost++;
                                        winstate.add(3);
                                    }
                                    recentBattles.setTeamname(awayRecentBattlesDTO.getHomeTeamName());
                                    recentBattles.setTeamlogo(awayRecentBattlesDTO.getHomeTeamLogo());
                                    if (winstate.size() == 5) {
                                        break;
                                    }
                                }
                                ConstantsUtils.his_recent_away_size = result.getData().getHistoryMatches().getAwayRecentBattles().size();
                                recentBattles.setWin(ConstantsUtils.his_recent_away_won);
                                recentBattles.setDrawn(ConstantsUtils.his_recent_away_drawn);
                                recentBattles.setLost(ConstantsUtils.his_recent_away_lost);
                                recentBattles.setMatchwinstate(winstate);
                                detailHistoryHistoryBattle.setRecentBattles(recentBattles);
                                detailHistoryEntities.add(detailHistoryHistoryBattle);
                            }
                        }

//                        }

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
