package com.app.base.request;

import com.app.library.frame.request.IHttpApi;

/**
 * Created by cample on 2018/3/21.
 */

public final class HttpApiProxy implements IHttpApi
{
    private static IHttpApi iHttpAPI;
    private HttpApiProxy(){
    }
    public static void init(IHttpApi iHttpAPI)
    {
        HttpApiProxy.iHttpAPI=iHttpAPI;
    }
    public static HttpApiProxy getInstance()
    {
        return IHttpProxyHolder.instance;
    }
    private static class IHttpProxyHolder
    {
        private static HttpApiProxy instance = new HttpApiProxy();
    }


    @Override
    public <T> T create(Class<T> clasz) {
        return iHttpAPI.create(clasz);
    }
}
