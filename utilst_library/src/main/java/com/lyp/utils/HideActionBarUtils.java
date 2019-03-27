package com.lyp.utils;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * 隐藏导航栏的
 *
 * @author Lyp
 * @create 2019/3/12
 */
public class HideActionBarUtils {
    /**
     * 实现隐藏导航栏
     *
     * @param activity 当前Activity
     */
    public static void hideActionBar(AppCompatActivity activity) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
