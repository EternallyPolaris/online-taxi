package com.polaris.internalcommon.dto;

import com.polaris.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
/**
 * 返回当前对象，支持链式调用
 */
@Accessors(chain = true)
/**
 * 抑制所有异常
 */
@SuppressWarnings("all")
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -1691160636710872789L;

    private int code;
    private String message;
    private T data;

    /**
     * 返回成功数据(status: 1)
     * @param data 数据内容
     * @return ResponseResult实例
     * @param <T> 数据类型
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage("success").setData(data);
    }

    /**
     * 返回错误数据（status：500）
     *
     * @param data 错误内容
     * @param <T>  数据类型
     * @return ResponseResult实例
     */
    public static <T> ResponseResult fail(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.INTERNAL_SERVER_EXCEPTION.getCode()).setMessage(CommonStatusEnum.INTERNAL_SERVER_EXCEPTION.getValue()).setData(data);
    }

    /**
     * 自定义返回错误数据
     *
     * @param code    错误代码
     * @param message 错误消息
     * @return ResponseResult实例
     */
    public static <T> ResponseResult fail(int code, String message) {
        return new ResponseResult().setCode(CommonStatusEnum.FAIL.getCode()).setMessage(message);
    }

    /**
     * @param code    错误代码
     * @param message 错误消息
     * @param data    错误内容
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int code, String message, String data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }
}
