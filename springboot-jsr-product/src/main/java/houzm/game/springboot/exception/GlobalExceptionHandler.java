package houzm.game.springboot.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Package: houzm.game.springboot.exception
 * Author: houzm
 * Date: Created in 2018/10/23 7:52
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： Exception Handler
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public @ResponseBody
    String handleConstraintViolationException(ConstraintViolationException e) {
        logger.debug("========== constraint violation exception {} ========", e);
        String messageTemplate = e.getConstraintViolations().iterator().next().getMessageTemplate();
        return messageTemplate;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public @ResponseBody
    String handleBindException(BindException e) {
        logger.debug("========== bind exception {} ========", e);
        BindingResult bindingResult = e.getBindingResult();
        String className = bindingResult.getTarget().getClass().getName();
        FieldError next = bindingResult.getFieldErrors().iterator().next();
        String fieldName = next.getField();
        String defaultMessage = next.getDefaultMessage();
//        if (Pattern.compile("IllegalArgumentException: No enum").matcher(defaultMessage).find()) {
//            Matcher matcher = Pattern.compile("for value '(.*?)'").matcher(defaultMessage);
//            if (matcher.find()) {
//                defaultMessage = "找不到枚举类型【" + matcher.group(1) + "】";
//            }
//        }
        return defaultMessage;
    }

//    @ResponseStatus(value = HttpStatus.OK)
//    @ExceptionHandler(ValidError.class)
//    public @ResponseBody
//    Msg handleValidError(ValidError e) {
//        return Msg.error(e.getMessage());
//    }
}
