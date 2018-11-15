package houzm.game.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package: houzm.game.springboot.controller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 16:54
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： view controller
 */
@Controller
public class ViewController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
