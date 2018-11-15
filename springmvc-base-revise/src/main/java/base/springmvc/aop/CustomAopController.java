package base.springmvc.aop;

import base.springmvc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc.aop
 * Author: houzm
 * Date: Created in 2018/9/17 10:46
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Controller
@RequestMapping(value = "api/testaop/")
@Api(value = "api/testaop/")
public class CustomAopController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    @ApiOperation(value = "/add/")
    @ResponseBody
    public void addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
