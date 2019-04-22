package com.lyp.utils;

import android.os.Build;

import java.util.Locale;

/**
 * 系统工具类
 *
 * @author Lyp
 * @create 2019/4/22
 */
public class SystemUtils {

    /**
     * 获取当前手机系统语言
     *
     * @return 返回当前系统语言
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前手机上的语言列表
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.BRAND;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

}
