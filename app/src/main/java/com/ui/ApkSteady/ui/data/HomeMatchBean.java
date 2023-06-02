package com.ui.ApkSteady.ui.data;

public class HomeMatchBean {
    /*球赛地点*/
    private String teamName;
    /*比赛进行状况*/
    private String playState;
    /*解说员*/
    private String expositor;
    /*观看人数*/
    private String viewNum;
    /*两队名字*/
    private String vsName;
    /*封面图片*/
    private int images;

    public HomeMatchBean(String teamName, String playState, String expositor, String viewNum, String vsName, int images) {
        this.teamName = teamName;
        this.playState = playState;
        this.expositor = expositor;
        this.viewNum = viewNum;
        this.vsName = vsName;
        this.images = images;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPlayState() {
        return playState;
    }

    public String getExpositor() {
        return expositor;
    }

    public String getViewNum() {
        return viewNum;
    }

    public String getVsName() {
        return vsName;
    }

    public int getImages() {
        return images;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayState(String playState) {
        this.playState = playState;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public void setVsName(String vsName) {
        this.vsName = vsName;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
