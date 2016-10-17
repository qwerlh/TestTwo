package com.example.lianghao.testtwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lianghao.testtwo.adapter.HomeAdapter;
import com.example.lianghao.testtwo.api.ApiManage;
import com.example.lianghao.testtwo.bean.MeiZi;
import com.example.lianghao.testtwo.bean.MeiziBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by LiangHao on 2016/10/10.
 */

public class TwoActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    HomeAdapter mHomeAdapter;
    int count = 1;
    List<MeiZi> mlistdat ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twolayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mlistdat  = new ArrayList<>();

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                System.out.println(newState+"----");
//            }
//        });
//
        getData(count);
    }
    public void onClick(View view){
        count ++;
        getData(count);
    }
    public void getData(int count){
        System.out.println(count);
        Call<MeiziBean> meizhiData = ApiManage.getInstence().getGankService().getMeizhiData(count);
               meizhiData.enqueue(new Callback<MeiziBean>() {
                   @Override
                   public void onResponse(Call<MeiziBean> call, Response<MeiziBean> response) {
                       MeiziBean body = response.body();
                       List<MeiZi> results = body.getResults();
                       mHomeAdapter = new HomeAdapter(TwoActivity.this,results);
                       mRecyclerView.setAdapter(mHomeAdapter);

                   }

                   @Override
                   public void onFailure(Call<MeiziBean> call, Throwable t) {

                   }
               });
        //请求成功

    }

}
