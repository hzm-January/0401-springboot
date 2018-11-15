package base.springmvc.base;

import base.springmvc.UserForCustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc.base
 * Author: houzm
 * Date: Created in 2018/9/8 21:15
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@RestController
@RequestMapping("api/converter")
public class CustomConverterController {

    private Logger logger = LoggerFactory.getLogger(CustomConverterController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/x-houzm;charset=UTF-8")
    @ApiOperation(value = "/", notes = "测试自定义转换器，自定义媒体类型")
    public UserForCustomConverter hh(@RequestBody UserForCustomConverter user) {
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
