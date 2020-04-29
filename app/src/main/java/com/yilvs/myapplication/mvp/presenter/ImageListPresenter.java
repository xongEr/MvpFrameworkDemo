package com.yilvs.myapplication.mvp.presenter;

import com.yilvs.myapplication.entity.ImageEntity;
import com.yilvs.myapplication.entity.ResultParent;
import com.yilvs.myapplication.framework.presenter.BaseMvpPresenter;
import com.yilvs.myapplication.framework.view.base.BaseMvpView;
import com.yilvs.myapplication.mvp.model.ImageListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * description:ImageList
 *
 * @autour yilv & version: v1.0 & date: ----/--/--
 */
public class ImageListPresenter extends BaseMvpPresenter<BaseMvpView> {

    private final ImageListModel imageListModel;

    public ImageListPresenter(){
        imageListModel = new ImageListModel();
    }

    public void getImageList(String query, String cn, String pn){
        imageListModel.getImageList(query, cn, pn, new Callback<ResultParent<List<ImageEntity>>>() {
            @Override
            public void onResponse(Call<ResultParent<List<ImageEntity>>> call, Response<ResultParent<List<ImageEntity>>> response) {
                if (response.body() == null ){
                    getMvpView().resultFailure("获取数据失败");
                }else {
                    if (response.body().getList() == null && response.body().getList().size() == 0){
                        getMvpView().resultFailure("数据为空");
                    }else {
                        getMvpView().resultSuccess(response.body());
                    }
                }

            }

            @Override
            public void onFailure(Call<ResultParent<List<ImageEntity>>> call, Throwable t) {
                getMvpView().resultFailure("获取数据失败");
            }
        });
    }
}





