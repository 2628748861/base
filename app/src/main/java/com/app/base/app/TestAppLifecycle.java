package com.app.base.app;

import android.content.Context;
import com.app.base.db.DbApiProxy;
import com.app.base.db.GreenDaoApi;
import com.app.base.request.HttpApiProxy;
import com.app.base.request.RetrofitApi;
import com.app.library.app.AppLifecycle;

public class TestAppLifecycle implements AppLifecycle {

    @Override
    public void onAttach(Context applicationContext) {
        HttpApiProxy.init(new RetrofitApi());
        DbApiProxy.init(new GreenDaoApi(applicationContext,"a.db"));
    }
}
