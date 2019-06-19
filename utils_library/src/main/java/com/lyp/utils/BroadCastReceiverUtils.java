package com.lyp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.io.Serializable;

/**
 * 注册广播，发送广播，注销广播
 *
 * @author Lyp
 * @create 2019/3/22
 */
public class BroadCastReceiverUtils {
    public interface OnReceiveBroadcast {
        /**
         * 广播注册接口
         *
         * @param context
         * @param intent
         */
        void onReceive(Context context, Intent intent);
    }

    private static class CustomBroadcastReceiver extends BroadcastReceiver {
        private OnReceiveBroadcast onReceiveBroadcast;

        public CustomBroadcastReceiver(OnReceiveBroadcast onReceiveBroadcast) {
            this.onReceiveBroadcast = onReceiveBroadcast;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (onReceiveBroadcast != null) {
                onReceiveBroadcast.onReceive(context, intent);
            }
        }

    }

    /**
     * 广播注册
     *
     * @param context
     * @param filters
     * @param onReceiveBroadcast
     * @return
     */
    public static BroadcastReceiver registerBroadcastReceiver(Context context, String[] filters,
                                                              OnReceiveBroadcast onReceiveBroadcast) {
        BroadcastReceiver broadcastReceiver = new CustomBroadcastReceiver(
                onReceiveBroadcast);
        IntentFilter filter = new IntentFilter();
        for (String filterStr : filters) {
            filter.addAction(filterStr);
        }
        context.registerReceiver(broadcastReceiver, filter);
        return broadcastReceiver;
    }

    /**
     * 发送广播
     *
     * @param context
     * @param filter
     */
    public static void sendBroadcast(Context context, String filter) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param bundle
     */
    public static void sendBroadcast(Context context, String filter, Bundle bundle) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(filter);
        intent.putExtras(bundle);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param bundleName
     * @param bundle
     */
    public static void sendBroadcast(Context context, String filter,
                                     String bundleName, Bundle bundle) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(filter);
        intent.putExtra(bundleName, bundle);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param name
     * @param serializable
     */
    public static void sendBroadcast(Context context, String filter, String name, Serializable serializable) {
        Intent intent = new Intent();
        intent.putExtra(name, serializable);
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param name
     * @param value
     */
    public static void sendBroadcast(Context context, String filter, String name, String value) {
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param name
     * @param value
     */
    public static void sendBroadcast(Context context, String filter, String name, long value) {
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param name
     * @param value
     */
    public static void sendBroadcast(Context context, String filter, String name, int value) {
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 发送广播(带参数的)
     *
     * @param context
     * @param filter
     * @param name
     * @param value
     * @param name1
     * @param value1
     */
    public static void sendBroadcast(Context context, String filter, String name, String value, String name1, String value1) {
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.putExtra(name1, value1);
        intent.setAction(filter);
        context.sendBroadcast(intent);
    }

    /**
     * 广播注销
     *
     * @param context
     * @param broadcastReceiver
     */
    public static void unRegisterBroadcastReceiver(Context context,
                                                   BroadcastReceiver broadcastReceiver) {
        if (context != null && broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
