package com.app.library.frame.request.entity;

/**返回响应实体模型
 * @param <T>
 */
public class BaseResponseEntity<T> {
    private T data;
    private int code;
    private String msg;

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
