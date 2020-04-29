package com.yilvs.myapplication.framework.factory;


import com.yilvs.myapplication.framework.presenter.BaseMvpPresenter;
import com.yilvs.myapplication.framework.view.base.BaseMvpView;

/**
 * @description Presenter工厂接口
 */
public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {

    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
