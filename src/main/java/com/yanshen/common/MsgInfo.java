package com.yanshen.common;

/**
 * @BelongsProject: Spring-Boot
 * @BelongsPackage: com.yanshen.common
 * @Author: cuiyanchao
 * @CreateTime: 2019-06-06 17:00
 * @Description: ${Description}
 */
public class MsgInfo<T> {
    private String message = "success";
    private String code = "000000"; // 服务号 + 编号, 000000表示成功, 100000表示提示, 200000 表示数据库查询信息提示，300000表示接口异常
    private T      data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MsgInfo{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}