package com.yilvs.myapplication.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * description:
 */
public class GlideUtil {

    public static void load(Context context, String url, ImageView imageView, RequestOptions options) {
        if (options != null) {
            Glide.with(context).load(url).apply(options).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    imageView.setImageDrawable(resource);
                }
            });
        } else {
            Glide.with(context).load(url).into(imageView);
        }
    }
}
