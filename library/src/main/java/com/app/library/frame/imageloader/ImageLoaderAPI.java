package com.app.library.frame.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by cample on 2018/3/21.
 */

public interface ImageLoaderAPI {

    /**拥有placeHolder,error的指定(w,h)的图片加载过程
     * @param url
     * @param imageView
     */
    void display(Context context, String url,  ImageView imageView);

    /**加载本地
     * @param context
     * @param resource
     * @param imageView
     */
    void display(Context context, Integer resource,  ImageView imageView);

    /**拥有placeHolder,error的指定(w,h)的图片加载过程
     * @param url
     * @param imageView
     */
    void displaynogift(Context context, String url,  ImageView imageView);

    /**圆角
     * @param context
     * @param resource
     * @param imageView
     */
    void display(Context context, Integer resource, int radius,  ImageView imageView);
    /**圆角
     * @param context
     * @param url
     * @param imageView
     */
    void display(Context context, String url, int radius,  ImageView imageView);

    /**获取缓存大小
     * @param context
     * @return
     */
    long getCacheSize(Context context);

    /**
     * 清除图片缓存
     */
    void clear(Context context);

}
