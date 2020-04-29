package com.yilvs.myapplication.http;

import com.yilvs.myapplication.entity.ImageEntity;
import com.yilvs.myapplication.entity.ResultParent;

import java.lang.annotation.Target;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * description: 网络接口
 */
public interface ApiService {

    /**
     * 获取图片列表
     * @param query   查询条件
     * @param cn
     * @param pn
     * @return
     */
    @GET("/j")
    Call<ResultParent<List<ImageEntity>>> getImageList(@Query("q") String query, @Query("cn") String cn, @Query("pn") String pn);

}
