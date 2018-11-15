package base.springmvc.base;

import base.springmvc.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package: base.springmvc
 * Author: houzm
 * Date: Created in 2018/9/5 11:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Controller
@RequestMapping("/api/base")
public class BaseDemoController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User queryUserById(@PathVariable(value = "id", required = true) String id) {
        System.out.println(id);
        return new User(id, "houzm", 12, "山西临汾", new Date());
    }

    /**
     * 演示json
     * @param age
     * @return
     */
    @RequestMapping(value = "/age", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<User> queryUserByAge(@RequestParam(value = "age", required = true, defaultValue = "12") Integer age) {
        return new ArrayList<>(Arrays.asList(
                new User("1", "zhang", age, "赵城", new Date()),
                new User("2", "lisi", age, "洪洞", new Date())
        ));
    }

    /**
     * 演示xml
     * @param age
     * @return
     */
    @RequestMapping(value = "/age/xml", method = RequestMethod.GET, produces = "application/xml;charset=UTF-8")
    public @ResponseBody List<User> queryUserByAgeXML(@RequestParam(value = "age", required = true, defaultValue = "12") Integer age) {
        return new ArrayList<>(Arrays.asList(
                new User("1", "zhang", age, "赵城", new Date()),
                new User("2", "lisi", age, "洪洞", new Date())
        ));
    }

    @RequestMapping(value = "addr/{id}",  method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String queryAddrById(@PathVariable(value = "id", required = true) String id) {
        return "上海万象城";
    }

}
