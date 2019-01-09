package com.app.library.app;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application {

    List<AppLifecycle> delegates=new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        delegates.add(new ApplicationDelegate(this));
        for (AppLifecycle delegate:delegates)
        {
            delegate.onAttach(this);
        }
    }
}
