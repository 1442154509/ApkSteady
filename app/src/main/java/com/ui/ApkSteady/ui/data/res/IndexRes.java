package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;
/*首页比赛数据*/
public class IndexRes implements Serializable {
    private String portraitUrl;
    private int matchId;
    private String matchName;
    private int sportsId;
    private int competitionId;
    private String competitionName;
    private int status;
    private String liveUrl;
    private String title;
    private String notice;
    private String coverUrl;
    private String playbackUrl;
    private String createTime;
    private String endTime;
    private String startTime;
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

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
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

    public static class MatchVediosInfoDTO implements Serializable {
        private int sportsId;
        private int matchId;
        private long matchTime;
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

        public long getMatchTime() {
            return matchTime;
        }

        public void setMatchTime(long matchTime) {
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

    @Override
    public String toString() {
        return "DataDTO{" +
                "portraitUrl='" + portraitUrl + '\'' +
                ", matchId=" + matchId +
                ", matchName='" + matchName + '\'' +
                ", sportsId=" + sportsId +
                ", competitionId=" + competitionId +
                ", competitionName='" + competitionName + '\'' +
                ", status=" + status +
                ", liveUrl='" + liveUrl + '\'' +
                ", title='" + title + '\'' +
                ", notice='" + notice + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", playbackUrl='" + playbackUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", matchVediosInfo=" + matchVediosInfo +
                ", id=" + id +
                ", homeLogo='" + homeLogo + '\'' +
                ", awayLogo='" + awayLogo + '\'' +
                ", competitionLogo='" + competitionLogo + '\'' +
                '}';
    }
}
