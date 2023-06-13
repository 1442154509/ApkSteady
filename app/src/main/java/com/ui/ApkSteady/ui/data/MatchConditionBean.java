package com.ui.ApkSteady.ui.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 赛事详情Bean
 */
public class MatchConditionBean extends MatchItemBean {
    // 球种类型
    private int sportsId;
    //赛事id
    private int matchId;
    // 开赛时间
    private int matchTime;
    // 联赛名称
    private String leagueName;
    // 联赛logo
    private String leagueLogo;
    // 赛事状态 ， 0.为开赛，1.开赛中，3.完赛
    private int matchStatus;
    // 赛事状态title 足球：上半场，下半场，中场休息。篮球： 第一节，第二节... 等赛事进行状态
    private String matchType;
    // 跑时 （比赛进行的时间单位s eg：足球进行了 3600s= 60:00分钟 ）
    private int runTime;
    // 主队名称
    private String home;
    // 客队名称
    private String away;
    // 主队logo
    private String aLogo;
    // 客队logo
    private String bLogo;
    // 主队红牌
    private int aRed;
    // 客队红牌
    private int bRed;
    // 主队黄牌
    private int aYellow;
    // 客队黄牌
    private int bYellow;
    // 是否有直播视频源
    private int isLive;
    // 直播地址
    private String liveUrl;
    // 主队角球
    private int aCorner;
    // 客队角球
    private int bCorner;
    // 主队比分
    private int aScore;
    // 客队比分
    private int bScore;

    public static class SportType {
        //足球
        public static final int FOOTBALL = 1;
        //篮球
        public static final int BASKETBALL = 2;
    }


    public static class MatchStatus {
        //未开始
        public static final int NOT_START = 0;
        //进行中
        public static final int IN_PROGRESS = 1;
        //已结束
        public static final int FINISH = 2;
    }


    public void setSportsId(int sportsId) {
        this.sportsId = sportsId;
    }

    public int getSportsId() {
        return this.sportsId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getMatchId() {
        return this.matchId;
    }

    public void setMatchTime(int matchTime) {
        this.matchTime = matchTime;
    }

    public int getMatchTime() {
        return this.matchTime;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueName() {
        return this.leagueName;
    }

    public void setLeagueLogo(String leagueLogo) {
        this.leagueLogo = leagueLogo;
    }

    public String getLeagueLogo() {
        return this.leagueLogo;
    }

    public void setMatchStatus(int matchStatus) {
        this.matchStatus = matchStatus;
    }

    public int getMatchStatus() {
        return this.matchStatus;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getRunTime() {
        return this.runTime;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHome() {
        return this.home;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getAway() {
        return this.away;
    }

    public void setALogo(String aLogo) {
        this.aLogo = aLogo;
    }

    public String getALogo() {
        return this.aLogo;
    }

    public void setBLogo(String bLogo) {
        this.bLogo = bLogo;
    }

    public String getBLogo() {
        return this.bLogo;
    }

    public void setARed(int aRed) {
        this.aRed = aRed;
    }

    public int getARed() {
        return this.aRed;
    }

    public void setBRed(int bRed) {
        this.bRed = bRed;
    }

    public int getBRed() {
        return this.bRed;
    }

    public void setAYellow(int aYellow) {
        this.aYellow = aYellow;
    }

    public int getAYellow() {
        return this.aYellow;
    }

    public void setBYellow(int bYellow) {
        this.bYellow = bYellow;
    }

    public int getBYellow() {
        return this.bYellow;
    }

    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }

    public int getIsLive() {
        return this.isLive;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public String getLiveUrl() {
        return this.liveUrl;
    }

    public void setACorner(int aCorner) {
        this.aCorner = aCorner;
    }

    public int getACorner() {
        return this.aCorner;
    }

    public void setBCorner(int bCorner) {
        this.bCorner = bCorner;
    }

    public int getBCorner() {
        return this.bCorner;
    }

    public void setAScore(int aScore) {
        this.aScore = aScore;
    }

    public int getAScore() {
        return this.aScore;
    }

    public void setBScore(int bScore) {
        this.bScore = bScore;
    }

    public int getBScore() {
        return this.bScore;
    }
}
