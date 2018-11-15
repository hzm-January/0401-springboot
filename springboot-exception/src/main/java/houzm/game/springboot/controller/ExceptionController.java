package houzm.game.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.game.springboot.controller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 18:01
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： ExceptionController
 */
@RestController
@RequestMapping(value = "/api/exception/")
public class ExceptionController {

    @RequestMapping(value = "/error")
    public String show() {
        return "request success";
    }

    @RequestMapping(value = "/success/serviceerror")
    public void showServiceError() {
        int b = 1/0;
    }
}
