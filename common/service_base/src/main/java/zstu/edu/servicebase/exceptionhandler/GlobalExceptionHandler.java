package zstu.edu.servicebase.exceptionhandler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zstu.edu.commonutils.ExceptionUtil;
import zstu.edu.commonutils.R;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }

    // 特定异常处理 / by zero
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理...");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public R error(DuplicateKeyException e) {
        return R.error().message("用户已存在");
    }

    // 自定义异常处理
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
