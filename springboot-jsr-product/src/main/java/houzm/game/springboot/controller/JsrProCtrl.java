package houzm.game.springboot.controller;

import houzm.game.springboot.JsonUtil;
import houzm.game.springboot.module.User;
import houzm.game.springboot.validgroup.Create;
import houzm.game.springboot.validgroup.Update;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: houzm.game.springboot.controller
 * Author: houzm
 * Date: Created in 2018/10/22 13:25
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： jsr product
 *
 * @Validated({C.Insert.class}) 声明启用 bean 注解上的验证组，其他验证组不会进行验证，这样可以区别开来进行单独验证。

 *   而像没有实体，只有一个基础数据类型的，可以进行验证，但是需要满足三个条件：

 *   在启动类配置方法级别验证启用类
 *   在 Controller 类上注解 @Validated
 *   在方法参数里使用验证注解如 @Min，@NotNull 等等
 */
@Validated
@RestController
@RequestMapping(value = "/api/jsr/pro/")
@Api(tags = "/api/jsr/pro")
public class JsrProCtrl {

    private Logger logger = LoggerFactory.getLogger(JsrProCtrl.class);

    @ApiOperation(value = "/create")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Object jsrCreate(@Validated(value = {Create.class}) @RequestBody User user, BindingResult bindingResult) {
        logger.debug("=== api jsr create product request param {} ===", user);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            logger.debug("bindingResult : {}", JsonUtil.objectToJson(allErrors));
            ObjectError error = allErrors.get(0);
            throw new IllegalStateException(error.getDefaultMessage());
        }

        return user;
    }

    @ApiOperation(value = "/update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object jsrUpdate(@Validated(value = {Update.class}) @RequestBody User user) {
        logger.debug("=== api jsr update product request param {} ===", user);
        return user;
    }

    @ApiOperation(value = "delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object jsrDelete(@NotNull @Min(value = 10) @PathVariable Long id) {
        logger.debug("=== api jsr update product request param {} ===", id);
        return null;
    }
}
