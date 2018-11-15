package base.spring.controller;

import base.spring.dao.UserRespository;
import base.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: base.spring.controller
 * Author: houzm
 * Date: Created in 2018/9/2 20:12
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public void query(@PathVariable String id) {
        userService.queryById(id);
    }
}
