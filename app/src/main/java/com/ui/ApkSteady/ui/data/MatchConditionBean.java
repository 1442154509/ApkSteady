package com.ui.ApkSteady.ui.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MatchConditionBean implements MultiItemEntity {
    private int sportId;

    @Override
    public int getItemType() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public static class SportType {
        //足球
        public static final int FOOTBALL = 1;
        //篮球
        public static final int BASKETBALL = 2;
    }
}
