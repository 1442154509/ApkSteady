package baselibs.utils;

import android.text.TextUtils;

import com.orhanobut.hawk.Hawk;

import java.util.Date;

/**
 * <p>Title: SPUtils</p>
 * <p>Description: </p>
 * <p>Copyright: DS Technology Co.Ltd  Copyright (c) 2020</p>
 * <p>Company: www.ds.cn</p>
 *
 * @author gukeming@ds.cn
 * @version 1.0
 * @date 2020/10/27 3:12 PM
 */
public class SPUtils {
    public static <T> boolean put(String key, T value) {
        return Hawk.put(key, value);
    }

    /**
     * 保存数据多少秒
     * @param key
     * @param value
     * @param seconds
     * @param <T>
     * @return
     */
    public static <T> boolean put(String key, T value, int seconds) {
        String timeKey = key + "______time";
        try {
            Hawk.put(key, value);
            long nowTime = new Date().getTime();
            long saveTime = nowTime + seconds * 1000;
            Hawk.put(timeKey, saveTime);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取有缓存期限缓存
     * @param key
     * @param ignoreDelete 过期不删除缓存
     * @param ignoreTime 忽略过期时间。即使过期也能获取缓存
     * @param <T>
     * @return
     */
    public static <T> T get(String key, boolean ignoreDelete, boolean ignoreTime) {
        String timeKey = key + "______time";
        if (Hawk.contains(timeKey)) {
            Long saveTime = Hawk.get(timeKey);
            if (saveTime != null && saveTime > 0) {
                long nowTime = new Date().getTime();
                if (saveTime > nowTime ) {
                    return Hawk.get(key);
                } else {
                    if (ignoreDelete) {
                        Hawk.delete(key);
                        Hawk.delete(timeKey);
                    }
                    if (ignoreTime) {
                        return Hawk.get(key);
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public static <T> T get(String key) {
        return Hawk.get(key);
    }

    public static <T> T get(String key, T defaultValue){
        return Hawk.get(key, defaultValue);
    }

    public static long count() {
        return Hawk.count();
    }

    public static boolean deleteAll() {
        return Hawk.deleteAll();
    }

    public static boolean delete(String key) {
        return Hawk.delete(key);
    }

    public static boolean contains(String key) {
        return Hawk.contains(key);
    }


}
