package houzm.game.springboot.exception;

import houzm.game.springboot.common.Result;
import houzm.game.springboot.common.ResultGenerater;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Package: houzm.game.springboot.exception
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 18:18
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： CustomExceptionHandler
 *
 * 统一异常处理
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exception(HttpServletRequest req, Exception e) {
        return ResultGenerater.fail(e.toString());
    }
}
