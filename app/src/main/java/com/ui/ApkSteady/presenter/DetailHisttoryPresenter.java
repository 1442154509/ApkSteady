package com.ui.ApkSteady.presenter;

import com.hazz.baselibs.mvp.BasePresenter;
import com.hazz.baselibs.net.BaseHttpResult;
import com.hazz.baselibs.net.BaseObserver2;
import com.hazz.baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.contract.HomeContract;
import com.ui.ApkSteady.model.DetailHistoryModel;
import com.ui.ApkSteady.model.HomeModel;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;

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
                        List<DetailHistoryEntity> detailHistoryEntities = new ArrayList<>();
//                        for (BasketBallDetailRes basketBallDetailRes : result.getData()) {
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
                        }
//                        }
                        detailHistoryEntities.add(0,new DetailHistoryEntity(DetailHistoryEntity.TYPE_HISTORYBATTLES));
                        getView().updataBasketBallUI(detailHistoryEntities);
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {

                    }

                });
    }
}
