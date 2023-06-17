package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
/*比赛详情查询，详情页头部结果轮询*/
public class CompetionRes implements Serializable {

    private int sportsId;
    private int matchId;
    private int matchTime;
    private String leagueName;
    private String leagueLogo;
    private int matchStatus;
    private String matchType;
    private int runTime;
    private String home;
    private String away;
    private String aLogo;
    private String bLogo;
    private int aRed;
    private int bRed;
    private int aYellow;
    private int bYellow;
    private boolean isLive;
    private String liveUrl;
    private int aCorner;
    private int bCorner;
    private int aScore;
    private int bScore;

    public int getSportsId() {
        return sportsId;
    }

    public void setSportsId(int sportsId) {
        this.sportsId = sportsId;
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

    public int getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(int matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getALogo() {
        return aLogo;
    }

    public void setALogo(String aLogo) {
        this.aLogo = aLogo;
    }

    public String getBLogo() {
        return bLogo;
    }

    public void setBLogo(String bLogo) {
        this.bLogo = bLogo;
    }

    public int getARed() {
        return aRed;
    }

    public void setARed(int aRed) {
        this.aRed = aRed;
    }

    public int getBRed() {
        return bRed;
    }

    public void setBRed(int bRed) {
        this.bRed = bRed;
    }

    public int getAYellow() {
        return aYellow;
    }

    public void setAYellow(int aYellow) {
        this.aYellow = aYellow;
    }

    public int getBYellow() {
        return bYellow;
    }

    public void setBYellow(int bYellow) {
        this.bYellow = bYellow;
    }

    public boolean isIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public int getACorner() {
        return aCorner;
    }

    public void setACorner(int aCorner) {
        this.aCorner = aCorner;
    }

    public int getBCorner() {
        return bCorner;
    }

    public void setBCorner(int bCorner) {
        this.bCorner = bCorner;
    }

    public int getAScore() {
        return aScore;
    }

    public void setAScore(int aScore) {
        this.aScore = aScore;
    }

    public int getBScore() {
        return bScore;
    }

    public void setBScore(int bScore) {
        this.bScore = bScore;
    }
}
