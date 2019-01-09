package com.app.library.frame.request.after;

import android.net.ParseException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**网络层处理观察者(下层)
 * Created by cample on 2017/7/31.
 */

public abstract class BaseResultObservable<T> extends ResourceObserver<T> {
    protected abstract void onHandlerSuccess(T t);
    protected abstract void onHandlerErrors(String msg);


    @Override
    public void onNext(T t) {
        onHandlerSuccess(t);
    }

    @Override
    public void onError(Throwable error) {

        String msg = "未知错误";
        if (error instanceof UnknownHostException) {
            msg = "网络不可用";
        } else if (error instanceof SocketTimeoutException) {
            msg = "请求网络超时";
        } else if (error instanceof HttpException) {
            HttpException httpException = (HttpException) error;
            msg = convertStatusCode(httpException);
        } else if (error instanceof JsonParseException || error instanceof ParseException || error instanceof JSONException || error instanceof JsonIOException) {
            msg = "数据解析错误";
        }
        onHandlerErrors(msg);
    }

    @Override
    public void onComplete() {
    }

    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }

}
