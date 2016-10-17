package com.example.lianghao.testtwo.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lianghao.testtwo.MainActivity;
import com.example.lianghao.testtwo.R;
import com.example.lianghao.testtwo.bean.MeiZi;
import com.example.lianghao.testtwo.bean.MeiziBean;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
        {
            Context mContext;
            List<MeiZi> mDatas;
            public HomeAdapter(Context context, List<MeiZi> mdatas) {
                this.mContext = context;
                this.mDatas = mdatas;
            }



@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
        mContext).inflate(R.layout.item_meizi, parent,
        false));
        return holder;
        }

@Override
public void onBindViewHolder(MyViewHolder holder, final int position)
        {
            MeiZi resultsBean = mDatas.get(position);
            System.out.println(resultsBean.get_id()+"--"+resultsBean.getUrl());
            holder.tv.setText(resultsBean.get_id());
            holder.mcontont.setText(resultsBean.getCreatedAt());

            Glide.with(mContext)
                    .load(resultsBean.getUrl())
                    .centerCrop()
                    .into(holder.mImageView);

            holder.tv.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
    System.out.println("urlF");
        }
        });
        }

@Override
public int getItemCount()
        {
        return mDatas.size();
        }


//缓存

class MyViewHolder extends RecyclerView.ViewHolder
{

    TextView tv;
    ImageView mImageView;
    TextView mcontont;

    public MyViewHolder(View view)
    {
        super(view);

        tv = (TextView) view.findViewById(R.id.item_title);
        mcontont = (TextView) view.findViewById(R.id.item_content);
        mImageView = (ImageView) view.findViewById(R.id.item_img);


    }
}
}

