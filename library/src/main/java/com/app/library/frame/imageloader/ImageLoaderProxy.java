package com.app.library.frame.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by cample on 2018/6/26.
 */

public final class ImageLoaderProxy implements ImageLoaderAPI {
    private static ImageLoaderAPI iImageLoaderAPI;
    private ImageLoaderProxy(){}
    public static void init(ImageLoaderAPI imageLoaderAPI)
    {
        ImageLoaderProxy.iImageLoaderAPI=imageLoaderAPI;
    }
    public static ImageLoaderProxy getInstance()
    {
       return IImageLoaderProxyHolder.instance;
    }

    static class IImageLoaderProxyHolder
    {
        private static ImageLoaderProxy instance = new ImageLoaderProxy();
    }
    @Override
    public void display(Context context, String url, ImageView imageView) {
        if (context==null) return;
        iImageLoaderAPI.display(context, url, imageView);
    }

    @Override
    public void display(Context context, Integer resource,  ImageView imageView) {
        if (context==null) return;
        iImageLoaderAPI.display(context, resource,  imageView);
    }

    @Override
    public void displaynogift(Context context, String url,  ImageView imageView) {
        if (context==null) return;
        iImageLoaderAPI.displaynogift(context, url,  imageView);
    }

    @Override
    public void display(Context context, Integer resource, int radius,  ImageView imageView) {
        if (context==null) return;
        iImageLoaderAPI.display(context, resource,radius,  imageView);
    }

    @Override
    public void display(Context context, String url, int radius,  ImageView imageView) {
        if (context==null) return;
        iImageLoaderAPI.display(context, url,radius,  imageView);
    }

    @Override
    public long getCacheSize(Context context) {
        return iImageLoaderAPI.getCacheSize(context);
    }

    @Override
    public void clear(Context context) {
        if (context==null) return;
        iImageLoaderAPI.clear(context);
    }
}
