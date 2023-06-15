package com.ui.ApkSteady.ui.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class DetailHistoryEntity implements MultiItemEntity {
    /*球队排名*/
    public static final int TYPE_RANK = 1;
    /*进球分布*/
    public static final int TYPE_GOALDISTRIBUTIONS = 2;
    /*历史交锋*/
    public static final int TYPE_HISTORYBATTLES = 3;
    /*近期战绩*/
    public static final int TYPE_RECENT = 4;
    /*对战详情*/
    public static final int TYPE_BATTER = 5;
    private int itemType;


    private RankDTO rank;
    private GoalDistributionsDTO goalDistributions;
    private HistoryBattlesDTO historyBattles;

    public GoalDistributionsDTO getGoalDistributions() {
        return goalDistributions;
    }

    public void setGoalDistributions(GoalDistributionsDTO goalDistributions) {
        this.goalDistributions = goalDistributions;
    }

    @Override
    public int getItemType() {
        return this.itemType;
    }

    public RankDTO getRank() {
        return rank;
    }

    public void setRank(RankDTO rank) {
        this.rank = rank;
    }

    public HistoryBattlesDTO getHistoryBattles() {
        return historyBattles;
    }

    public void setHistoryBattles(HistoryBattlesDTO historyBattles) {
        this.historyBattles = historyBattles;
    }

    public static class GoalDistributionsDTO {
        private int goals_1_15;
        private int goals_16_30;
        private int goals_31_45;
        private int goals_46_60;
        private int goals_61_75;
        private int goals_76_90;
        private int teamtype;

        public int getGoals_1_15() {
            return goals_1_15;
        }

        public void setGoals_1_15(int goals_1_15) {
            this.goals_1_15 = goals_1_15;
        }

        public int getGoals_16_30() {
            return goals_16_30;
        }

        public void setGoals_16_30(int goals_16_30) {
            this.goals_16_30 = goals_16_30;
        }

        public int getGoals_31_45() {
            return goals_31_45;
        }

        public void setGoals_31_45(int goals_31_45) {
            this.goals_31_45 = goals_31_45;
        }

        public int getGoals_46_60() {
            return goals_46_60;
        }

        public void setGoals_46_60(int goals_46_60) {
            this.goals_46_60 = goals_46_60;
        }

        public int getGoals_61_75() {
            return goals_61_75;
        }

        public void setGoals_61_75(int goals_61_75) {
            this.goals_61_75 = goals_61_75;
        }

        public int getGoals_76_90() {
            return goals_76_90;
        }

        public void setGoals_76_90(int goals_76_90) {
            this.goals_76_90 = goals_76_90;
        }

        public int getTeamtype() {
            return teamtype;
        }

        public void setTeamtype(int teamtype) {
            this.teamtype = teamtype;
        }
    }

    public static class RankDTO {
        private int position;
        private int points;
        private int played;
        private int won;
        private int drawn;
        private int lost;
        private int goals;
        private int awayGoals;
        private int against;
        private int diff;
        private int teamtype;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getPlayed() {
            return played;
        }

        public void setPlayed(int played) {
            this.played = played;
        }

        public int getWon() {
            return won;
        }

        public void setWon(int won) {
            this.won = won;
        }

        public int getDrawn() {
            return drawn;
        }

        public void setDrawn(int drawn) {
            this.drawn = drawn;
        }

        public int getLost() {
            return lost;
        }

        public void setLost(int lost) {
            this.lost = lost;
        }

        public int getGoals() {
            return goals;
        }

        public void setGoals(int goals) {
            this.goals = goals;
        }

        public int getAwayGoals() {
            return awayGoals;
        }

        public void setAwayGoals(int awayGoals) {
            this.awayGoals = awayGoals;
        }

        public int getAgainst() {
            return against;
        }

        public void setAgainst(int against) {
            this.against = against;
        }

        public int getDiff() {
            return diff;
        }

        public void setDiff(int diff) {
            this.diff = diff;
        }

        public int getTeamtype() {
            return teamtype;
        }

        public void setTeamtype(int teamtype) {
            this.teamtype = teamtype;
        }
    }

    public static class HistoryBattlesDTO {
        private int homeTeamId;
        private int awayTeamId;
        private int leagueId;
        private int matchTime;
        private String leagueName;
        private String homeTeamName;
        private String homeTeamLogo;
        private String awayTeamName;
        private String awayTeamLogo;
        private int homeScore;
        private int awayScore;
        private int homeScoreH1;
        private int teamtype;

        public int getHomeTeamId() {
            return homeTeamId;
        }

        public void setHomeTeamId(int homeTeamId) {
            this.homeTeamId = homeTeamId;
        }

        public int getAwayTeamId() {
            return awayTeamId;
        }

        public void setAwayTeamId(int awayTeamId) {
            this.awayTeamId = awayTeamId;
        }

        public int getLeagueId() {
            return leagueId;
        }

        public void setLeagueId(int leagueId) {
            this.leagueId = leagueId;
        }

        public int getMatchTime() {
            return matchTime;
        }

        public void setMatchTime(int matchTime) {
            this.matchTime = matchTime;
        }

        public String getLeagueName() {
            return leagueName;
        }

        public void setLeagueName(String leagueName) {
            this.leagueName = leagueName;
        }

        public String getHomeTeamName() {
            return homeTeamName;
        }

        public void setHomeTeamName(String homeTeamName) {
            this.homeTeamName = homeTeamName;
        }

        public String getHomeTeamLogo() {
            return homeTeamLogo;
        }

        public void setHomeTeamLogo(String homeTeamLogo) {
            this.homeTeamLogo = homeTeamLogo;
        }

        public String getAwayTeamName() {
            return awayTeamName;
        }

        public void setAwayTeamName(String awayTeamName) {
            this.awayTeamName = awayTeamName;
        }

        public String getAwayTeamLogo() {
            return awayTeamLogo;
        }

        public void setAwayTeamLogo(String awayTeamLogo) {
            this.awayTeamLogo = awayTeamLogo;
        }

        public int getHomeScore() {
            return homeScore;
        }

        public void setHomeScore(int homeScore) {
            this.homeScore = homeScore;
        }

        public int getAwayScore() {
            return awayScore;
        }

        public void setAwayScore(int awayScore) {
            this.awayScore = awayScore;
        }

        public int getHomeScoreH1() {
            return homeScoreH1;
        }

        public void setHomeScoreH1(int homeScoreH1) {
            this.homeScoreH1 = homeScoreH1;
        }

        public int getTeamtype() {
            return teamtype;
        }

        public void setTeamtype(int teamtype) {
            this.teamtype = teamtype;
        }
    }
}
