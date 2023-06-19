package com.ui.ApkSteady.ui.data.req;

import java.io.Serializable;
import java.util.List;

public class CompetitionReq implements Serializable {

    private int sportsId;
    private List<String> matchId;

    public int getSportsId() {
        return sportsId;
    }

    public void setSportsId(int sportsId) {
        this.sportsId = sportsId;
    }

    public List<String> getMatchId() {
        return matchId;
    }

    public void setMatchId(List<String> matchId) {
        this.matchId = matchId;
    }
}
