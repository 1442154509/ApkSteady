package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;

public class FootBallDetailRes implements Serializable {

    private int code;
    private String msg;
    private DataDTO data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO implements Serializable {
        private String gameInfoId;
        private int matchId;
        private int matchTime;
        private String leagueName;
        private String leagueLogo;
        private String homeTeamName;
        private String homeTeamLogo;
        private String awayTeamName;
        private String awayTeamLogo;
        private RanksDTO ranks;
        private GoalDistributionsDTO goalDistributions;
        private HistoryMatchesDTOX historyMatches;
        private LineupsDTO lineups;
        private int leagueId;
        private int homeTeamId;
        private int awayTeamId;
        private IntelligencesDTO intelligences;
        private boolean hasIntelligence;
        private List<LivesDTO> lives;

        public String getGameInfoId() {
            return gameInfoId;
        }

        public void setGameInfoId(String gameInfoId) {
            this.gameInfoId = gameInfoId;
        }

        public int getMatchId() {
            return matchId;
        }

        public void setMatchId(int matchId) {
            this.matchId = matchId;
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

        public String getLeagueLogo() {
            return leagueLogo;
        }

        public void setLeagueLogo(String leagueLogo) {
            this.leagueLogo = leagueLogo;
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

        public RanksDTO getRanks() {
            return ranks;
        }

        public void setRanks(RanksDTO ranks) {
            this.ranks = ranks;
        }

        public GoalDistributionsDTO getGoalDistributions() {
            return goalDistributions;
        }

        public void setGoalDistributions(GoalDistributionsDTO goalDistributions) {
            this.goalDistributions = goalDistributions;
        }

        public HistoryMatchesDTOX getHistoryMatches() {
            return historyMatches;
        }

        public void setHistoryMatches(HistoryMatchesDTOX historyMatches) {
            this.historyMatches = historyMatches;
        }

        public LineupsDTO getLineups() {
            return lineups;
        }

        public void setLineups(LineupsDTO lineups) {
            this.lineups = lineups;
        }

        public int getLeagueId() {
            return leagueId;
        }

        public void setLeagueId(int leagueId) {
            this.leagueId = leagueId;
        }

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

        public IntelligencesDTO getIntelligences() {
            return intelligences;
        }

        public void setIntelligences(IntelligencesDTO intelligences) {
            this.intelligences = intelligences;
        }

        public boolean isHasIntelligence() {
            return hasIntelligence;
        }

        public void setHasIntelligence(boolean hasIntelligence) {
            this.hasIntelligence = hasIntelligence;
        }

        public List<LivesDTO> getLives() {
            return lives;
        }

        public void setLives(List<LivesDTO> lives) {
            this.lives = lives;
        }

        public static class RanksDTO implements Serializable {
            private List<HomeDTO> home;
            private List<AwayDTO> away;

            public List<HomeDTO> getHome() {
                return home;
            }

            public void setHome(List<HomeDTO> home) {
                this.home = home;
            }

            public List<AwayDTO> getAway() {
                return away;
            }

            public void setAway(List<AwayDTO> away) {
                this.away = away;
            }

            public static class HomeDTO implements Serializable {
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
            }

            public static class AwayDTO implements Serializable {
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
            }
        }

        public static class GoalDistributionsDTO implements Serializable {
            private List<HomeDTOX> home;
            private List<AwayDTOX> away;

            public List<HomeDTOX> getHome() {
                return home;
            }

            public void setHome(List<HomeDTOX> home) {
                this.home = home;
            }

            public List<AwayDTOX> getAway() {
                return away;
            }

            public void setAway(List<AwayDTOX> away) {
                this.away = away;
            }

            public static class HomeDTOX implements Serializable {
                private int goals_1_15;
                private int goals_16_30;
                private int goals_31_45;
                private int goals_46_60;
                private int goals_61_75;
                private int goals_76_90;

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
            }

            public static class AwayDTOX implements Serializable {
                private int goals_1_15;
                private int goals_16_30;
                private int goals_31_45;
                private int goals_46_60;
                private int goals_61_75;
                private int goals_76_90;

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
            }
        }

        public static class HistoryMatchesDTOX implements Serializable {
            private List<HistoryMatchesDTO> historyMatches;
            private List<HomeHistoryMatchesDTO> homeHistoryMatches;
            private List<AwayHistoryMatchesDTO> awayHistoryMatches;

            public List<HistoryMatchesDTO> getHistoryMatches() {
                return historyMatches;
            }

            public void setHistoryMatches(List<HistoryMatchesDTO> historyMatches) {
                this.historyMatches = historyMatches;
            }

            public List<HomeHistoryMatchesDTO> getHomeHistoryMatches() {
                return homeHistoryMatches;
            }

            public void setHomeHistoryMatches(List<HomeHistoryMatchesDTO> homeHistoryMatches) {
                this.homeHistoryMatches = homeHistoryMatches;
            }

            public List<AwayHistoryMatchesDTO> getAwayHistoryMatches() {
                return awayHistoryMatches;
            }

            public void setAwayHistoryMatches(List<AwayHistoryMatchesDTO> awayHistoryMatches) {
                this.awayHistoryMatches = awayHistoryMatches;
            }

            public static class HistoryMatchesDTO implements Serializable {
                private int matchTime;
                private String leagueName;
                private String homeTeamName;
                private String homeTeamLogo;
                private String awayTeamName;
                private String awayTeamLogo;
                private int homeScoreHalf;
                private int awayScoreHalf;
                private int homeScore;
                private int awayScore;
                private int homeTeamId;
                private int awayTeamId;
                private int leagueId;

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

                public int getHomeScoreHalf() {
                    return homeScoreHalf;
                }

                public void setHomeScoreHalf(int homeScoreHalf) {
                    this.homeScoreHalf = homeScoreHalf;
                }

                public int getAwayScoreHalf() {
                    return awayScoreHalf;
                }

                public void setAwayScoreHalf(int awayScoreHalf) {
                    this.awayScoreHalf = awayScoreHalf;
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
            }

            public static class HomeHistoryMatchesDTO implements Serializable {
                private int matchTime;
                private String leagueName;
                private String homeTeamName;
                private String homeTeamLogo;
                private String awayTeamName;
                private String awayTeamLogo;
                private int homeScoreHalf;
                private int awayScoreHalf;
                private int homeScore;
                private int awayScore;
                private int homeTeamId;
                private int awayTeamId;
                private int leagueId;

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

                public int getHomeScoreHalf() {
                    return homeScoreHalf;
                }

                public void setHomeScoreHalf(int homeScoreHalf) {
                    this.homeScoreHalf = homeScoreHalf;
                }

                public int getAwayScoreHalf() {
                    return awayScoreHalf;
                }

                public void setAwayScoreHalf(int awayScoreHalf) {
                    this.awayScoreHalf = awayScoreHalf;
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
            }

            public static class AwayHistoryMatchesDTO implements Serializable {
                private int matchTime;
                private String leagueName;
                private String homeTeamName;
                private String homeTeamLogo;
                private String awayTeamName;
                private String awayTeamLogo;
                private int homeScoreHalf;
                private int awayScoreHalf;
                private int homeScore;
                private int awayScore;
                private int homeTeamId;
                private int awayTeamId;
                private int leagueId;

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

                public int getHomeScoreHalf() {
                    return homeScoreHalf;
                }

                public void setHomeScoreHalf(int homeScoreHalf) {
                    this.homeScoreHalf = homeScoreHalf;
                }

                public int getAwayScoreHalf() {
                    return awayScoreHalf;
                }

                public void setAwayScoreHalf(int awayScoreHalf) {
                    this.awayScoreHalf = awayScoreHalf;
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
            }
        }

        public static class LineupsDTO implements Serializable {
            private String homeFormation;
            private String awayFormation;
            private List<HomeDTOXX> home;
            private List<AwayDTOXX> away;

            public String getHomeFormation() {
                return homeFormation;
            }

            public void setHomeFormation(String homeFormation) {
                this.homeFormation = homeFormation;
            }

            public String getAwayFormation() {
                return awayFormation;
            }

            public void setAwayFormation(String awayFormation) {
                this.awayFormation = awayFormation;
            }

            public List<HomeDTOXX> getHome() {
                return home;
            }

            public void setHome(List<HomeDTOXX> home) {
                this.home = home;
            }

            public List<AwayDTOXX> getAway() {
                return away;
            }

            public void setAway(List<AwayDTOXX> away) {
                this.away = away;
            }

            public static class HomeDTOXX implements Serializable {
                private int first;
                private String playerName;
                private String playerFullName;
                private String playerLogo;
                private String shirtNumber;

                public int getFirst() {
                    return first;
                }

                public void setFirst(int first) {
                    this.first = first;
                }

                public String getPlayerName() {
                    return playerName;
                }

                public void setPlayerName(String playerName) {
                    this.playerName = playerName;
                }

                public String getPlayerFullName() {
                    return playerFullName;
                }

                public void setPlayerFullName(String playerFullName) {
                    this.playerFullName = playerFullName;
                }

                public String getPlayerLogo() {
                    return playerLogo;
                }

                public void setPlayerLogo(String playerLogo) {
                    this.playerLogo = playerLogo;
                }

                public String getShirtNumber() {
                    return shirtNumber;
                }

                public void setShirtNumber(String shirtNumber) {
                    this.shirtNumber = shirtNumber;
                }
            }

            public static class AwayDTOXX implements Serializable {
                private int first;
                private String playerName;
                private String playerFullName;
                private String playerLogo;
                private String shirtNumber;

                public int getFirst() {
                    return first;
                }

                public void setFirst(int first) {
                    this.first = first;
                }

                public String getPlayerName() {
                    return playerName;
                }

                public void setPlayerName(String playerName) {
                    this.playerName = playerName;
                }

                public String getPlayerFullName() {
                    return playerFullName;
                }

                public void setPlayerFullName(String playerFullName) {
                    this.playerFullName = playerFullName;
                }

                public String getPlayerLogo() {
                    return playerLogo;
                }

                public void setPlayerLogo(String playerLogo) {
                    this.playerLogo = playerLogo;
                }

                public String getShirtNumber() {
                    return shirtNumber;
                }

                public void setShirtNumber(String shirtNumber) {
                    this.shirtNumber = shirtNumber;
                }
            }
        }

        public static class IntelligencesDTO implements Serializable {
            private HomeIntelligenceDTO homeIntelligence;
            private AwayIntelligenceDTO awayIntelligence;
            private NeutralIntelligenceDTO neutralIntelligence;
            private int matchId;
            private String homeTeamLogo;
            private String awayTeamLogo;
            private String homeTeamFullName;
            private String awayTeamFullName;
            private String homeTeamName;
            private String awayTeamName;

            public HomeIntelligenceDTO getHomeIntelligence() {
                return homeIntelligence;
            }

            public void setHomeIntelligence(HomeIntelligenceDTO homeIntelligence) {
                this.homeIntelligence = homeIntelligence;
            }

            public AwayIntelligenceDTO getAwayIntelligence() {
                return awayIntelligence;
            }

            public void setAwayIntelligence(AwayIntelligenceDTO awayIntelligence) {
                this.awayIntelligence = awayIntelligence;
            }

            public NeutralIntelligenceDTO getNeutralIntelligence() {
                return neutralIntelligence;
            }

            public void setNeutralIntelligence(NeutralIntelligenceDTO neutralIntelligence) {
                this.neutralIntelligence = neutralIntelligence;
            }

            public int getMatchId() {
                return matchId;
            }

            public void setMatchId(int matchId) {
                this.matchId = matchId;
            }

            public String getHomeTeamLogo() {
                return homeTeamLogo;
            }

            public void setHomeTeamLogo(String homeTeamLogo) {
                this.homeTeamLogo = homeTeamLogo;
            }

            public String getAwayTeamLogo() {
                return awayTeamLogo;
            }

            public void setAwayTeamLogo(String awayTeamLogo) {
                this.awayTeamLogo = awayTeamLogo;
            }

            public String getHomeTeamFullName() {
                return homeTeamFullName;
            }

            public void setHomeTeamFullName(String homeTeamFullName) {
                this.homeTeamFullName = homeTeamFullName;
            }

            public String getAwayTeamFullName() {
                return awayTeamFullName;
            }

            public void setAwayTeamFullName(String awayTeamFullName) {
                this.awayTeamFullName = awayTeamFullName;
            }

            public String getHomeTeamName() {
                return homeTeamName;
            }

            public void setHomeTeamName(String homeTeamName) {
                this.homeTeamName = homeTeamName;
            }

            public String getAwayTeamName() {
                return awayTeamName;
            }

            public void setAwayTeamName(String awayTeamName) {
                this.awayTeamName = awayTeamName;
            }

            public static class HomeIntelligenceDTO implements Serializable {
                private String teamName;
                private String teamLogo;
                private List<String> goodIntelligences;
                private List<String> harmfulIntelligences;

                public String getTeamName() {
                    return teamName;
                }

                public void setTeamName(String teamName) {
                    this.teamName = teamName;
                }

                public String getTeamLogo() {
                    return teamLogo;
                }

                public void setTeamLogo(String teamLogo) {
                    this.teamLogo = teamLogo;
                }

                public List<String> getGoodIntelligences() {
                    return goodIntelligences;
                }

                public void setGoodIntelligences(List<String> goodIntelligences) {
                    this.goodIntelligences = goodIntelligences;
                }

                public List<String> getHarmfulIntelligences() {
                    return harmfulIntelligences;
                }

                public void setHarmfulIntelligences(List<String> harmfulIntelligences) {
                    this.harmfulIntelligences = harmfulIntelligences;
                }
            }

            public static class AwayIntelligenceDTO implements Serializable {
                private String teamName;
                private String teamLogo;
                private List<String> goodIntelligences;
                private List<String> harmfulIntelligences;

                public String getTeamName() {
                    return teamName;
                }

                public void setTeamName(String teamName) {
                    this.teamName = teamName;
                }

                public String getTeamLogo() {
                    return teamLogo;
                }

                public void setTeamLogo(String teamLogo) {
                    this.teamLogo = teamLogo;
                }

                public List<String> getGoodIntelligences() {
                    return goodIntelligences;
                }

                public void setGoodIntelligences(List<String> goodIntelligences) {
                    this.goodIntelligences = goodIntelligences;
                }

                public List<String> getHarmfulIntelligences() {
                    return harmfulIntelligences;
                }

                public void setHarmfulIntelligences(List<String> harmfulIntelligences) {
                    this.harmfulIntelligences = harmfulIntelligences;
                }
            }

            public static class NeutralIntelligenceDTO implements Serializable {
                private List<String> neutralIntelligences;

                public List<String> getNeutralIntelligences() {
                    return neutralIntelligences;
                }

                public void setNeutralIntelligences(List<String> neutralIntelligences) {
                    this.neutralIntelligences = neutralIntelligences;
                }
            }
        }

        public static class LivesDTO implements Serializable {
            private String url;
            private String type;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
