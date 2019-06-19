package com.lyp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lyp.utils.HideActionBarUtils;

import butterknife.ButterKnife;

/**
 * Activity继承公共类
 *
 * @author Lyp
 * @create 2019/3/12
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        // 导航栏隐藏
        HideActionBarUtils.hideActionBar(this);

        // 绑定初始化ButterKnife
        ButterKnife.bind(this);

        // 方法调用
        findView();
        initData();
        initView();
    }

    /**
     * 设置ContentView
     *
     * @return 返回布局资源id
     */
    protected abstract int getLayoutId();

    /**
     * 实例化布局资源方法
     */
    protected abstract void findView();

    /**
     * 实例化数据资源，设置数据的方法
     */
    protected abstract void initData();

    /**
     * 布局资源调用
     */
    protected abstract void initView();
}
