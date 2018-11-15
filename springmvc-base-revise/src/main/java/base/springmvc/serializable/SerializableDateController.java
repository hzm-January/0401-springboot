package base.springmvc.serializable;

import base.springmvc.User;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc.serializable
 * Author: houzm
 * Date: Created in 2018/9/7 12:08
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 序列化date
 */
@RestController
@RequestMapping(value = "/api/serializable")
@Api(value = "/api/serializable")
public class SerializableDateController {

    private Logger logger = LoggerFactory.getLogger(SerializableDateController.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "/", notes = "根据id查询用户")
    public User queryUserById(@PathVariable(value = "id") String id) {
        return new User("2", "hozm", 12, "东胜神洲",
                DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("1991-08-09").toDate());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "/", notes = "新增用户")
    public User insertUser(@RequestBody User user) {
//        try {
//            logger.debug(new ObjectMapper().writeValueAsString(user));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        logger.debug("user: {}", user);
        System.out.println(user);
        return user;
    }

}
