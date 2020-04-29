package com.yilvs.myapplication.mvp.model;


import com.yilvs.myapplication.entity.ImageEntity;
import com.yilvs.myapplication.entity.ResultParent;
import com.yilvs.myapplication.http.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * description:ImageList
 */
public class ImageListModel {
    private Call<ResultParent<List<ImageEntity>>> call;

    public void interruptHttp() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

    public void getImageList(String query, String cn, String pn, Callback<ResultParent<List<ImageEntity>>> callback) {
        call = ApiClient.getApiAdapter().getImageList(query, cn, pn);
        call.enqueue(callback);
    }
}


