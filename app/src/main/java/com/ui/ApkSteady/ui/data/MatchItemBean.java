package com.ui.ApkSteady.ui.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MatchItemBean implements MultiItemEntity {
    private int itemType;
    @Override
    public int getItemType() {
        return itemType;
    }

    public MatchItemBean setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public static class ItemType {
        public static final int TYPE_HEADER_UNSTART = 0;
        public static final int TYPE_HEADER_IN_PROGRESS = 1;
        public static final int TYPE_HEADER_FINISH = 2;
        public static final int TYPE_MATCH_FOOTBALL = 11;
        public static final int TYPE_MATCH_BASKETBALL = 12;
    }
}
