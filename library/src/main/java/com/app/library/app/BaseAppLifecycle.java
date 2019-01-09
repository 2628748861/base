package com.app.library.app;

import android.content.Context;
import android.util.Log;

import com.app.library.frame.imageloader.GlideImageLoaderAPI;
import com.app.library.frame.imageloader.ImageLoaderProxy;
import com.app.library.frame.permission.PermissionAPIProxy;
import com.app.library.frame.permission.RxPermissionAPI;

public class BaseAppLifecycle implements AppLifecycle {
    @Override
    public void onAttach(Context applicationContext) {
        Log.e("TAG","初始化basemoudle");
        ImageLoaderProxy.init(new GlideImageLoaderAPI());
        PermissionAPIProxy.init(new RxPermissionAPI());
    }
}
