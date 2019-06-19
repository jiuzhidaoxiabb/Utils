package com.lyp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment继承公共类
 *
 * @author Lyp
 * @create 2019/3/12
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 解析布局
        View view = inflater.inflate(getLayout(), container, false);

        // 绑定初始化ButterKnife
        unbinder = ButterKnife.bind(this, view);

        // 方法调用
        initData();
        initView();

        return view;
    }

    /**
     * 设置ContentView
     *
     * @return 返回布局资源id
     */
    protected abstract int getLayout();

    /**
     * 实例化数据资源，设置数据的方法
     */
    protected abstract void initData();

    /**
     * 布局资源调用
     */
    protected abstract void initView();

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
