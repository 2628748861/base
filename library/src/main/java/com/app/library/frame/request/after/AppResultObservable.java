package com.app.library.frame.request.after;


import com.app.library.frame.request.entity.BaseResponseEntity;

/**业务层处理观察者(上层)
 * Created by cample on 2017/7/31.
 */

public abstract class AppResultObservable<T> extends BaseResultObservable<T> {

    public abstract void onSuccess(T t);
    public abstract void onErrors(String msg);

    @Override
    protected void onHandlerSuccess(T t) {
        //处理服务器返回响应具体业务逻辑(如:登录过期,强制互踢...等).
        BaseResponseEntity entity=(BaseResponseEntity) t;
        AppHttpStatusCodeEnum statusCodeEnum=AppHttpStatusCodeEnum.getEnumByCode(entity.getCode());
        if(statusCodeEnum!=AppHttpStatusCodeEnum.SUCCESS){
            onErrors(statusCodeEnum.getMsg());
        }
        else
        {
            onSuccess(t);
        }

    }

    @Override
    protected void onHandlerErrors(String msg) {
        //继续往上抛给具体使用场景自行实现
        onErrors(msg);
    }
}
