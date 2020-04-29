package com.yilvs.myapplication.http;

import android.util.Log;


import com.yilvs.myapplication.http.converter.GsonConverterFactory;
import com.yilvs.myapplication.utils.Constants;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSink;
import retrofit2.Retrofit;

/**
 * description: Http Client
 */
public class ApiClient {
    private static Retrofit imAdapter;
    private static ApiService apiService;

    private static int timeout = 30;

    private static OkHttpClient client;
    static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.e("RetrofitLog", "retrofitBack = " + message);
        }
    });

    public static ApiService getApiAdapter() {
        if (imAdapter == null) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder()
                    .connectTimeout(timeout, TimeUnit.SECONDS)
                    .readTimeout(timeout, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();
            imAdapter = new Retrofit.Builder()
                    .baseUrl(Constants.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        apiService = imAdapter.create(ApiService.class);
        return apiService;
    }
}
