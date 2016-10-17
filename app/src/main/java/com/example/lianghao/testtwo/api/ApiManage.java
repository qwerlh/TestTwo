package com.example.lianghao.testtwo.api;


import com.example.lianghao.testtwo.bean.MeiziBean;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xinghongfei on 16/8/12.
 */
public class ApiManage {


    public static ApiManage apiManage;

    public ZhihuApi zhihuApi;
    public TopNews topNews;
    private Object zhihuMonitor = new Object();

    public static ApiManage getInstence() {
        if (apiManage == null) {
            synchronized (ApiManage.class) {
                if (apiManage == null) {
                    apiManage = new ApiManage();
                }
            }
        }
        return apiManage;
    }

    public ZhihuApi getZhihuApiService() {
        if (zhihuApi == null) {
            synchronized (zhihuMonitor) {
                if (zhihuApi == null) {
                    zhihuApi = new Retrofit.Builder()
                            .baseUrl("http://news-at.zhihu.com")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(ZhihuApi.class);
                }
            }
        }

        return zhihuApi;
    }

    public TopNews getTopNewsService() {
        if (topNews == null) {
            synchronized (zhihuMonitor) {
                if (topNews == null) {
                    topNews = new Retrofit.Builder()
                            .baseUrl("http://c.m.163.com")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(TopNews.class);

                }
            }
        }

        return topNews;
    }

    public GankApi ganK;
    public GankApi getGankService(){
        if (ganK==null){
            synchronized (zhihuMonitor){
                if (ganK==null){
                    ganK=new Retrofit.Builder()
                            .baseUrl("http://gank.io")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(GankApi.class);


                }


            }


        }
        return ganK;
    }

}
