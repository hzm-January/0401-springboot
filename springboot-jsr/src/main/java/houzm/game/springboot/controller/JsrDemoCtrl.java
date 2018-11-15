package houzm.game.springboot.controller;

import houzm.game.springboot.module.Person;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/**
 * Package: houzm.game.springboot.controller
 * Author: houzm
 * Date: Created in 2018/10/20 16:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： jsr demo
 */
@RestController
@RequestMapping("/api/jsr")
@Api(tags = "/api/jsr")
public class JsrDemoCtrl {

    @RequestMapping(value = "/binding/result", method = RequestMethod.POST)
    @ApiOperation(value = "/binding/result", httpMethod = "POST")
    public Map<String, Object> jsr(@Valid @RequestBody Person person, BindingResult bindingResult, HttpServletResponse httpResponse) {
        Map<String, Object> map = new HashMap<>(10);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<String> errorMsgs = new LinkedList<>();
            for (ObjectError allError : allErrors) {
                errorMsgs.add(allError.getDefaultMessage());
            }
            map.put("status", false);
            map.put("error", errorMsgs);
        } else {
            map.put("status", true);
            map.put("msg", "添加成功");
        }
        return map;
    }
}

