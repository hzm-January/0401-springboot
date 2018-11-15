package houzm.game.springboot.controller;

import houzm.game.springboot.entity.TSystemUser;
import houzm.game.springboot.service.TSystemUserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.game.springboot.controller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 17:40
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@RestController
@RequestMapping("/")
public class JpaController {

    @Autowired
    private TSystemUserJPA systemUserJPA;
    @RequestMapping("/getbyname")
    public TSystemUser getByName(@RequestParam(name = "username") String username) {
        return systemUserJPA.findByUsername(username);
    }
}
