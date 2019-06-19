package com.lyp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * sp工具类
 *
 * @author Lyp
 * @create 2019/3/27
 */
public class PreferencesUtils {
    public static final String PREFERENCE_NAME = "PreferencesUtils";

    private PreferencesUtils() {
        throw new AssertionError();
    }

    /**
     * 存入字符串
     *
     * @param context context
     * @param key     关键字
     * @param value   参数值
     * @return 返回true（存储成功）
     */
    public static boolean putString(Context context, String key, String value) {
        SharedPreferences preferences = context
                .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 获取存入的字符串
     *
     * @param context context
     * @param key     关键字
     * @return 返回参数值
     */
    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    /**
     * 获取存入的字符串（含有默认值）
     *
     * @param context      context
     * @param key          关键字
     * @param defaultValue 默认值
     * @return 返回参数值，或defaultValue
     */
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences settings = context
                .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    /**
     * 存入数值
     *
     * @param context context
     * @param key     关键字
     * @param value   参数值
     * @return 返回true（存储成功）
     */
    public static boolean putInt(Context context, String key, int value) {
        SharedPreferences preferences = context
                .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * 获取存入的数值
     *
     * @param context context
     * @param key     关键值
     * @return 返回参数值
     */
    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    /**
     * 获取存入的数值（含有默认值）
     *
     * @param context      context
     * @param key          关键字
     * @param defaultValue 默认值
     * @return 返回参数值
     */
    public static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences settings = context
                .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }
}
