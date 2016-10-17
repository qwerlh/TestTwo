/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

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
import com.example.lianghao.testtwo.R;
import com.example.lianghao.testtwo.bean.MeiZi;

import java.util.List;


/**
 * Created by drakeet on 6/20/15.
 */
public class MeizhiListAdapter
        extends RecyclerView.Adapter<MeizhiListAdapter.ViewHolder> {

    public static final String TAG = "MeizhiListAdapter";

    private List<MeiZi> mList;
    private Context mContext;


    public MeizhiListAdapter(Context context, List<MeiZi> meizhiList) {
        mList = meizhiList;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.item_meizi, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        MeiZi meizhi = mList.get(position);
        int limit = 48;
        String text = meizhi.getDesc().length() > limit ? meizhi.getDesc().substring(0, limit) +
                "..." : meizhi.getDesc();
        viewHolder.meizhi = meizhi;
        viewHolder.tv.setText(text);
        viewHolder.mcontont.setTag(meizhi.getDesc());

        Glide.with(mContext)
             .load(meizhi.getUrl())
             .centerCrop()
                .into(viewHolder.mImageView);

    }


    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView tv;
        ImageView mImageView;
        TextView mcontont;
        MeiZi meizhi;

        public ViewHolder(View view)
        {
            super(view);

            tv = (TextView) view.findViewById(R.id.item_title);
            mcontont = (TextView) view.findViewById(R.id.item_content);
            mImageView = (ImageView) view.findViewById(R.id.item_img);

            mImageView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            System.out.println("hello word");
        }
    }
}
