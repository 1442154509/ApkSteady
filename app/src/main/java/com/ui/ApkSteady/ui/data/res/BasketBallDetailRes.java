package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;

public class BasketBallDetailRes implements Serializable {

    private String gameInfoId;
    private int matchId;
    private int matchTime;
    private String leagueName;
    private String leagueLogo;
    private String homeTeamName;
    private String homeTeamLogo;
    private String awayTeamName;
    private String awayTeamLogo;
    private int leagueId;
    private int homeTeamId;
    private int awayTeamId;
    private boolean hasIntelligence;
    private IntelligencesDTO intelligences;
    private TeamStatisticsDTO teamStatistics;
    private LineupsDTO lineups;
    private HistoryMatchesDTO historyMatches;
    private BestDTO best;
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

    public boolean isHasIntelligence() {
        return hasIntelligence;
    }

    public void setHasIntelligence(boolean hasIntelligence) {
        this.hasIntelligence = hasIntelligence;
    }

    public IntelligencesDTO getIntelligences() {
        return intelligences;
    }

    public void setIntelligences(IntelligencesDTO intelligences) {
        this.intelligences = intelligences;
    }

    public TeamStatisticsDTO getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatisticsDTO teamStatistics) {
        this.teamStatistics = teamStatistics;
    }

    public LineupsDTO getLineups() {
        return lineups;
    }

    public void setLineups(LineupsDTO lineups) {
        this.lineups = lineups;
    }

    public HistoryMatchesDTO getHistoryMatches() {
        return historyMatches;
    }

    public void setHistoryMatches(HistoryMatchesDTO historyMatches) {
        this.historyMatches = historyMatches;
    }

    public BestDTO getBest() {
        return best;
    }

    public void setBest(BestDTO best) {
        this.best = best;
    }

    public List<LivesDTO> getLives() {
        return lives;
    }

    public void setLives(List<LivesDTO> lives) {
        this.lives = lives;
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

        public static class NeutralIntelligenceDTO {
            private List<String> neutralIntelligences;

            public List<String> getNeutralIntelligences() {
                return neutralIntelligences;
            }

            public void setNeutralIntelligences(List<String> neutralIntelligences) {
                this.neutralIntelligences = neutralIntelligences;
            }
        }
    }

    public static class TeamStatisticsDTO implements Serializable {
        private HomeDTO home;
        private AwayDTO away;

        public HomeDTO getHome() {
            return home;
        }

        public void setHome(HomeDTO home) {
            this.home = home;
        }

        public AwayDTO getAway() {
            return away;
        }

        public void setAway(AwayDTO away) {
            this.away = away;
        }

        public static class HomeDTO implements Serializable {
            private int twoPointsScored;
            private int twoPointsTotal;
            private int threePointsScored;
            private int threePointsTotal;
            private int freeThrowsScored;
            private int freeThrowsTotal;
            private int points;
            private int rebounds;
            private int defensiveRebounds;
            private int offensiveRebounds;
            private int assists;
            private int turnovers;
            private int steals;
            private int blocks;
            private int totalFouls;

            public int getTwoPointsScored() {
                return twoPointsScored;
            }

            public void setTwoPointsScored(int twoPointsScored) {
                this.twoPointsScored = twoPointsScored;
            }

            public int getTwoPointsTotal() {
                return twoPointsTotal;
            }

            public void setTwoPointsTotal(int twoPointsTotal) {
                this.twoPointsTotal = twoPointsTotal;
            }

            public int getThreePointsScored() {
                return threePointsScored;
            }

            public void setThreePointsScored(int threePointsScored) {
                this.threePointsScored = threePointsScored;
            }

            public int getThreePointsTotal() {
                return threePointsTotal;
            }

            public void setThreePointsTotal(int threePointsTotal) {
                this.threePointsTotal = threePointsTotal;
            }

            public int getFreeThrowsScored() {
                return freeThrowsScored;
            }

            public void setFreeThrowsScored(int freeThrowsScored) {
                this.freeThrowsScored = freeThrowsScored;
            }

            public int getFreeThrowsTotal() {
                return freeThrowsTotal;
            }

            public void setFreeThrowsTotal(int freeThrowsTotal) {
                this.freeThrowsTotal = freeThrowsTotal;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public int getRebounds() {
                return rebounds;
            }

            public void setRebounds(int rebounds) {
                this.rebounds = rebounds;
            }

            public int getDefensiveRebounds() {
                return defensiveRebounds;
            }

            public void setDefensiveRebounds(int defensiveRebounds) {
                this.defensiveRebounds = defensiveRebounds;
            }

            public int getOffensiveRebounds() {
                return offensiveRebounds;
            }

            public void setOffensiveRebounds(int offensiveRebounds) {
                this.offensiveRebounds = offensiveRebounds;
            }

            public int getAssists() {
                return assists;
            }

            public void setAssists(int assists) {
                this.assists = assists;
            }

            public int getTurnovers() {
                return turnovers;
            }

            public void setTurnovers(int turnovers) {
                this.turnovers = turnovers;
            }

            public int getSteals() {
                return steals;
            }

            public void setSteals(int steals) {
                this.steals = steals;
            }

            public int getBlocks() {
                return blocks;
            }

            public void setBlocks(int blocks) {
                this.blocks = blocks;
            }

            public int getTotalFouls() {
                return totalFouls;
            }

            public void setTotalFouls(int totalFouls) {
                this.totalFouls = totalFouls;
            }
        }

        public static class AwayDTO implements Serializable {
            private int twoPointsScored;
            private int twoPointsTotal;
            private int threePointsScored;
            private int threePointsTotal;
            private int freeThrowsScored;
            private int freeThrowsTotal;
            private int points;
            private int rebounds;
            private int defensiveRebounds;
            private int offensiveRebounds;
            private int assists;
            private int turnovers;
            private int steals;
            private int blocks;
            private int totalFouls;

            public int getTwoPointsScored() {
                return twoPointsScored;
            }

            public void setTwoPointsScored(int twoPointsScored) {
                this.twoPointsScored = twoPointsScored;
            }

            public int getTwoPointsTotal() {
                return twoPointsTotal;
            }

            public void setTwoPointsTotal(int twoPointsTotal) {
                this.twoPointsTotal = twoPointsTotal;
            }

            public int getThreePointsScored() {
                return threePointsScored;
            }

            public void setThreePointsScored(int threePointsScored) {
                this.threePointsScored = threePointsScored;
            }

            public int getThreePointsTotal() {
                return threePointsTotal;
            }

            public void setThreePointsTotal(int threePointsTotal) {
                this.threePointsTotal = threePointsTotal;
            }

            public int getFreeThrowsScored() {
                return freeThrowsScored;
            }

            public void setFreeThrowsScored(int freeThrowsScored) {
                this.freeThrowsScored = freeThrowsScored;
            }

            public int getFreeThrowsTotal() {
                return freeThrowsTotal;
            }

            public void setFreeThrowsTotal(int freeThrowsTotal) {
                this.freeThrowsTotal = freeThrowsTotal;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public int getRebounds() {
                return rebounds;
            }

            public void setRebounds(int rebounds) {
                this.rebounds = rebounds;
            }

            public int getDefensiveRebounds() {
                return defensiveRebounds;
            }

            public void setDefensiveRebounds(int defensiveRebounds) {
                this.defensiveRebounds = defensiveRebounds;
            }

            public int getOffensiveRebounds() {
                return offensiveRebounds;
            }

            public void setOffensiveRebounds(int offensiveRebounds) {
                this.offensiveRebounds = offensiveRebounds;
            }

            public int getAssists() {
                return assists;
            }

            public void setAssists(int assists) {
                this.assists = assists;
            }

            public int getTurnovers() {
                return turnovers;
            }

            public void setTurnovers(int turnovers) {
                this.turnovers = turnovers;
            }

            public int getSteals() {
                return steals;
            }

            public void setSteals(int steals) {
                this.steals = steals;
            }

            public int getBlocks() {
                return blocks;
            }

            public void setBlocks(int blocks) {
                this.blocks = blocks;
            }

            public int getTotalFouls() {
                return totalFouls;
            }

            public void setTotalFouls(int totalFouls) {
                this.totalFouls = totalFouls;
            }
        }
    }

    public static class LineupsDTO implements Serializable {
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

        public static class AwayDTOX implements Serializable {
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

    public static class HistoryMatchesDTO implements Serializable {
        private List<HistoryBattlesDTO> historyBattles;
        private List<HomeRecentBattlesDTO> homeRecentBattles;
        private List<AwayRecentBattlesDTO> awayRecentBattles;
        private List<HomeFutureBattlesDTO> homeFutureBattles;
        private List<AwayFutureBattlesDTO> awayFutureBattles;

        public List<HistoryBattlesDTO> getHistoryBattles() {
            return historyBattles;
        }

        public void setHistoryBattles(List<HistoryBattlesDTO> historyBattles) {
            this.historyBattles = historyBattles;
        }

        public List<HomeRecentBattlesDTO> getHomeRecentBattles() {
            return homeRecentBattles;
        }

        public void setHomeRecentBattles(List<HomeRecentBattlesDTO> homeRecentBattles) {
            this.homeRecentBattles = homeRecentBattles;
        }

        public List<AwayRecentBattlesDTO> getAwayRecentBattles() {
            return awayRecentBattles;
        }

        public void setAwayRecentBattles(List<AwayRecentBattlesDTO> awayRecentBattles) {
            this.awayRecentBattles = awayRecentBattles;
        }

        public List<HomeFutureBattlesDTO> getHomeFutureBattles() {
            return homeFutureBattles;
        }

        public void setHomeFutureBattles(List<HomeFutureBattlesDTO> homeFutureBattles) {
            this.homeFutureBattles = homeFutureBattles;
        }

        public List<AwayFutureBattlesDTO> getAwayFutureBattles() {
            return awayFutureBattles;
        }

        public void setAwayFutureBattles(List<AwayFutureBattlesDTO> awayFutureBattles) {
            this.awayFutureBattles = awayFutureBattles;
        }

        public static class HistoryBattlesDTO implements Serializable {
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
            private int awayScoreH1;

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

            public int getAwayScoreH1() {
                return awayScoreH1;
            }

            public void setAwayScoreH1(int awayScoreH1) {
                this.awayScoreH1 = awayScoreH1;
            }
        }

        public static class HomeRecentBattlesDTO implements Serializable {
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
            private int awayScoreH1;

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

            public int getAwayScoreH1() {
                return awayScoreH1;
            }

            public void setAwayScoreH1(int awayScoreH1) {
                this.awayScoreH1 = awayScoreH1;
            }
        }

        public static class AwayRecentBattlesDTO implements Serializable {
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
            private int awayScoreH1;

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

            public int getAwayScoreH1() {
                return awayScoreH1;
            }

            public void setAwayScoreH1(int awayScoreH1) {
                this.awayScoreH1 = awayScoreH1;
            }
        }

        public static class HomeFutureBattlesDTO implements Serializable {
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
            private int awayScoreH1;

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

            public int getAwayScoreH1() {
                return awayScoreH1;
            }

            public void setAwayScoreH1(int awayScoreH1) {
                this.awayScoreH1 = awayScoreH1;
            }
        }

        public static class AwayFutureBattlesDTO implements Serializable {
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
            private int awayScoreH1;

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

            public int getAwayScoreH1() {
                return awayScoreH1;
            }

            public void setAwayScoreH1(int awayScoreH1) {
                this.awayScoreH1 = awayScoreH1;
            }
        }
    }

    public static class BestDTO implements Serializable {
        private HomePointsDTO homePoints;
        private AwayPointsDTO awayPoints;
        private HomeReboundsDTO homeRebounds;
        private AwayReboundsDTO awayRebounds;
        private HomeAssistsDTO homeAssists;
        private AwayAssistsDTO awayAssists;

        public HomePointsDTO getHomePoints() {
            return homePoints;
        }

        public void setHomePoints(HomePointsDTO homePoints) {
            this.homePoints = homePoints;
        }

        public AwayPointsDTO getAwayPoints() {
            return awayPoints;
        }

        public void setAwayPoints(AwayPointsDTO awayPoints) {
            this.awayPoints = awayPoints;
        }

        public HomeReboundsDTO getHomeRebounds() {
            return homeRebounds;
        }

        public void setHomeRebounds(HomeReboundsDTO homeRebounds) {
            this.homeRebounds = homeRebounds;
        }

        public AwayReboundsDTO getAwayRebounds() {
            return awayRebounds;
        }

        public void setAwayRebounds(AwayReboundsDTO awayRebounds) {
            this.awayRebounds = awayRebounds;
        }

        public HomeAssistsDTO getHomeAssists() {
            return homeAssists;
        }

        public void setHomeAssists(HomeAssistsDTO homeAssists) {
            this.homeAssists = homeAssists;
        }

        public AwayAssistsDTO getAwayAssists() {
            return awayAssists;
        }

        public void setAwayAssists(AwayAssistsDTO awayAssists) {
            this.awayAssists = awayAssists;
        }

        public static class HomePointsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
            }
        }

        public static class AwayPointsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
            }
        }

        public static class HomeReboundsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
            }
        }

        public static class AwayReboundsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
            }
        }

        public static class HomeAssistsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
            }
        }

        public static class AwayAssistsDTO implements Serializable {
            private String nameZh;
            private String logo;
            private int value;
            private String shirtNumber;

            public String getNameZh() {
                return nameZh;
            }

            public void setNameZh(String nameZh) {
                this.nameZh = nameZh;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public void setShirtNumber(String shirtNumber) {
                this.shirtNumber = shirtNumber;
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
