package com.taxing.tliaswebmanagement.exception;

import lombok.Getter;

// 自定义业务异常类
public class BusinessException extends RuntimeException {
    // Getter 方法
    @Getter
    private int code; // 错误码（可选）
    @Getter
    private String message; // 错误信息

    // 构造方法
    public BusinessException(String message) {
        super(message);
        this.code = 500; // 默认错误码
        this.message = message;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
