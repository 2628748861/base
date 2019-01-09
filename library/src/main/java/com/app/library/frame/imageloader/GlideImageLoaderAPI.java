package com.app.library.frame.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.io.File;



/**
 * Created by cample on 2018/3/21.
 */

public class GlideImageLoaderAPI implements ImageLoaderAPI
{
    @Override
    public void display(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    @Override
    public void display(Context context, Integer resource,  ImageView imageView) {
        Glide.with(context).load(resource).into(imageView);
    }

    @Override
    public void displaynogift(Context context, String url,  ImageView imageView) {
        Glide.with(context).asBitmap().load(url).into(imageView);
    }

    @Override
    public void display(final Context context, Integer resource, final int radius, final ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .load(resource)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(radius);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public void display(final Context context, String url,final int radius,final ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(radius);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public long getCacheSize(Context context) {
       return getFolderSize(new File(context.getCacheDir() + "/"+ InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR));
    }

    @Override
    public void clear(Context context) {
        Glide.get(context).clearMemory();
        Glide.get(context).clearDiskCache();
    }

    private long getFolderSize(File file)  {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                if (aFileList.isDirectory()) {
                    size = size + getFolderSize(aFileList);
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
