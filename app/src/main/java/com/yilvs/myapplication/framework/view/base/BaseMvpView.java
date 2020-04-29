package com.yilvs.myapplication.framework.view.base;

/**
 * @description 所有View层接口的基类
 */
public interface BaseMvpView<T> {
    void showLoadingDialog();
    void dismissLoadingDialog();
    void resultFailure(String object);
    void resultSuccess(T result);
}
