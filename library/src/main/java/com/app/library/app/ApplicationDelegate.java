package com.app.library.app;

import android.content.Context;

import com.app.library.util.ManifestParser;

import java.util.List;

public class ApplicationDelegate implements AppLifecycle {
    public Context context;

    public ApplicationDelegate(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(Context applicationContext) {
        ManifestParser parser=new ManifestParser(applicationContext);
        List<AppLifecycle> configs=parser.parse();
        if(!configs.isEmpty())
        {
            for (AppLifecycle config:configs)
            {
                config.onAttach(applicationContext);
            }
        }
    }
}
