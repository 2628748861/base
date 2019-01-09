package com.app.library.frame.request.after;

/**
 * App接口请求内部业务码
 */
public enum AppHttpStatusCodeEnum
{
    UN_KNOW(-1,"无法解析的请求"),
    SUCCESS(1000,"请求成功"),
    INVALID_PARAMS(1001,"无效的请求参数"),
    SERVER_INNER_ERROR(1006,"内部自定义错误"),
    UNAUTHORIZED(1007,"请求未授权"),
    SESSION_EXPIRE(1008,"请求会话已过期"),
    SERVER_ERROR(1010,"服务器内部错误");
    private final String msg;
    private final int code;
    AppHttpStatusCodeEnum(int code, String msg)
    {
        this.msg=msg;
        this.code=code;
    }
    public static AppHttpStatusCodeEnum getEnumByCode(int code){
        for(AppHttpStatusCodeEnum temp:AppHttpStatusCodeEnum.values()){
            if(temp.getCode()==code){
                return temp;
            }
        }
        return UN_KNOW;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
