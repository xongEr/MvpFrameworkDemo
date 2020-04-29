package com.yilvs.myapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yilvs.myapplication.R;
import com.yilvs.myapplication.entity.ImageEntity;
import com.yilvs.myapplication.utils.GlideUtil;
import com.yilvs.myapplication.view.TransformationUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yilv on 2020/4/9.
 */

public class ImageListAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ImageEntity> mDataList;

    public ImageListAdapter(Context context, List<ImageEntity> dataList) {
        this.context = context;
        this.mDataList = dataList;
    }

    public void addList(List<ImageEntity> dataList) {
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public List<ImageEntity> getData(){
        if (mDataList != null){
            return mDataList;
        }
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_image_list, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).bindView(context,mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_bg)
        ImageView imgBg;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindView(Context context, ImageEntity imageEntity){
            if (!TextUtils.isEmpty(imageEntity.getTitle())){
                tvTitle.setText(imageEntity.getTitle());
            }else {
                tvTitle.setText("");
            }

            if (!TextUtils.isEmpty(imageEntity.getThumb())){
                RequestOptions options = new RequestOptions().dontAnimate();
                GlideUtil.load(context,imageEntity.getThumb(),imgBg,options);
            }
        }
    }
}