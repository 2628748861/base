package com.app.library.frame.request;

/**
 * Created by cample on 2018/7/5.
 */

public interface IHttpApi {

    /**创建服务
     * @param clasz
     * @param <T>
     * @return
     */
    <T> T create(Class<T> clasz);
}
