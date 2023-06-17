package com.ui.ApkSteady.ui.utils;

public class ConstantsUtils {
    public static final String BASEURL = "https://34.80.205.147:12300/Api/";
    public static final String VERSION = BASEURL + "Version";
    public static final String INDEX = BASEURL + "Index";
    public static final String COMPETITIONLIST = BASEURL + "CompetitionList";
    public static final String COMPETITION = BASEURL + "Competition";
    public static final String DETAIL = BASEURL + "Detail";
    /*历史交锋胜利*/
    public static int his_battler_won = 0;
    /*历史交锋平局*/
    public static int his_battler_drawn = 0;
    /*历史交锋失败*/
    public static int his_battler_lost = 0;
    /*历史交锋列表长度*/
    public static int his_battler_size = 0;

    public static void cleanHisBattlerData() {
        his_battler_won = 0;
        his_battler_drawn = 0;
        his_battler_lost = 0;
        his_battler_size = 0;
    }
}
