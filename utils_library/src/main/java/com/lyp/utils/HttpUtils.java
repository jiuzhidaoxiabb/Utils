package com.lyp.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.lyp.connector.ResultCallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 封装Http请求工具类
 *
 * @author Lyp
 * @create 2019/3/27
 */
public class HttpUtils {
    private static final String TAG = "HttpUtils";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static Handler handler = new Handler();

    /**
     * 封装OkHttp（不含有请求体）
     *
     * @param url      请求地址
     * @param callback 接口
     */
    public static void sendHttpRequest(String url, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 封装OkHttp（含有RequestBody请求体）
     *
     * @param url      请求地址
     * @param callback 接口
     */
    public static void sendHttpRequest(String url, RequestBody body, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 向服务端请求数据
     *
     * @param url            URL地址
     * @param resultCallBack 结果处理接口
     */
    public static void sendRequestToServer(String url, ResultCallBack resultCallBack) {
        // 发送异步请求
        sendHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(() -> resultCallBack.onFailure(TAG, e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();

                //请求成功之后解析，通过回调接口将数据传输回去
                handler.post(() -> {
                    String str;
                    // 如果是空的话
                    if (TextUtils.isEmpty(result)) {
                        str = null;
                        Log.i(TAG, "请求到的结果为空");
                    } else {
                        str = result;
                        Log.i(TAG, "请求到的结果是" + str);
                    }
                    resultCallBack.onSuccess(TAG, str);
                });
            }
        });
    }

    /**
     * 向服务端发送数据（带数据资源）
     *
     * @param url            URL地址
     * @param json           数据资源
     * @param resultCallBack 结果处理接口
     */
    public static void sendRequestToServer(String url, String json, ResultCallBack resultCallBack) {
        // 请求方法名、传递的数据资源
        RequestBody body = RequestBody.create(JSON, json);
        // 发送异步请求
        sendHttpRequest(url, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(() -> resultCallBack.onFailure(TAG, e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();

                //请求成功之后解析，通过回调接口将数据传输回去
                handler.post(() -> {
                    String str;
                    // 如果是空的话
                    if (TextUtils.isEmpty(result)) {
                        str = null;
                        Log.i(TAG, "请求到的结果为空");
                    } else {
                        str = result;
                        Log.i(TAG, "请求到的结果是" + str);
                    }
                    resultCallBack.onSuccess(TAG, str);
                });
            }
        });
    }
}
