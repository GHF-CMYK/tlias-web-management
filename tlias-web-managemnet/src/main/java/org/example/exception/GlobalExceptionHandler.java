package org.example.exception;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理业务异常（如：部门下有员工、班级下有学生时不允许删除）
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e){
        return Result.error(e.getMessage());
    }

    //处理其他异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

}