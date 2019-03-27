package com.lyp.connector;

/**
 * http请求返回结果集合
 *
 * @author lyp
 */
public interface ResultCallBack {
    /**
     * 回调异步请求的结果集合
     *
     * @param tag  TAG
     * @param json 获取到的结果
     */
    void onSuccess(String tag, String json);

    /**
     * 网络请求失败处理接口
     *
     * @param tag TAG
     * @param e   返回异常
     */
    void onFailure(String tag, Exception e);
}
