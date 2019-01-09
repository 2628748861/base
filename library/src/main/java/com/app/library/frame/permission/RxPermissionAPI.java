package com.app.library.frame.permission;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

/**
 * Created by cample on 2018/6/22.
 */

public final class RxPermissionAPI implements IPermissionAPI {

    @Override
    public Observable<Boolean> request(Activity activity, String... permissions) {
         return new RxPermissions(activity)
                 .request(permissions);
    }
}
