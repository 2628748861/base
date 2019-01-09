package com.app.library.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.app.library.app.AppLifecycle;
import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {
    private static final String MODULE_VALUE = "com.config.app";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    public List<AppLifecycle> parse() {
        List<AppLifecycle> modules = new ArrayList<AppLifecycle>();
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                for (String key : appInfo.metaData.keySet()) {
                    if (MODULE_VALUE.equals(appInfo.metaData.get(key))) {
                        modules.add(parseModule(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse ConfigModule", e);
        }

        return modules;
    }

    private static AppLifecycle parseModule(String className) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to find ConfigModule implementation", e);
        }

        Object module;
        try {
            module = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + clazz, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + clazz, e);
        }

        if (!(module instanceof AppLifecycle)) {
            throw new RuntimeException("Expected instanceof ConfigModule, but found: " + module);
        }
        return (AppLifecycle) module;
    }
}
