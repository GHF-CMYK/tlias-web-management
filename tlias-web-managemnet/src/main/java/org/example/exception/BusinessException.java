package org.example.exception;

/**
 * 业务异常：用于向全局异常处理器传递需要提示给用户的错误信息
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
