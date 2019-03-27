package com.lyp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 提示信息工具类集合
 *
 * @author Lyp
 * @create 2019/3/27
 */
public class ToastUtils {
    /**
     * 创建toast对象
     */
    private static Toast sToast = null;

    /**
     * 短时间提示
     *
     * @param context context
     * @param msg     提示信息
     */
    public static void showShort(Context context, String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }

        sToast.show();
    }

    /**
     * 长时间提示
     *
     * @param context context
     * @param msg     提示信息
     */
    public static void showLong(Context context, String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            sToast.setText(msg);
        }

        sToast.show();
    }
}
