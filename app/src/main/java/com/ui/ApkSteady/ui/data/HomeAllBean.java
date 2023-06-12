package com.ui.ApkSteady.ui.data;

import java.io.Serializable;
//首页数据
public class HomeAllBean implements Serializable {
    // 背景图
    private String portraitUrl;
    //赛事id
    private int matchId;
    // 比赛title
    private String matchName;
    //0.所有 1.足球 2.篮球
    private int sportsId;
    private int competitionId;
    // 联赛名称
    private String competitionName;
    // 赛事状态 ： 0未开始,1直播中,2直播结束
    private int status;
    // 直播地址
    private String liveUrl;
    private String title;
    private Object notice;
    // 封面图片
    private String coverUrl;
    // 回放地址
    private String playbackUrl;
    // 创建时间
    private String createTime;
    // 结束时间
    private String endTime;
    // 开始时间
    private String startTime;
    // 赛事相关信息
    private MatchVediosInfoDTO matchVediosInfo;
    private int id;
    private String homeLogo;
    private String awayLogo;
    private String competitionLogo;

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public int getSportsId() {
        return sportsId;
    }

    public void setSportsId(int sportsId) {
        this.sportsId = sportsId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPlaybackUrl() {
        return playbackUrl;
    }

    public void setPlaybackUrl(String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public MatchVediosInfoDTO getMatchVediosInfo() {
        return matchVediosInfo;
    }

    public void setMatchVediosInfo(MatchVediosInfoDTO matchVediosInfo) {
        this.matchVediosInfo = matchVediosInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeLogo() {
        return homeLogo;
    }

    public void setHomeLogo(String homeLogo) {
        this.homeLogo = homeLogo;
    }

    public String getAwayLogo() {
        return awayLogo;
    }

    public void setAwayLogo(String awayLogo) {
        this.awayLogo = awayLogo;
    }

    public String getCompetitionLogo() {
        return competitionLogo;
    }

    public void setCompetitionLogo(String competitionLogo) {
        this.competitionLogo = competitionLogo;
    }

    public static class MatchVediosInfoDTO {
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
        // 	主队名称
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
        // 是否有直播
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

        public int getIsLive() {
            return isLive;
        }

        public void setIsLive(int isLive) {
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
}
