package base.springmvc.serversend;

import java.util.Random;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc.serversend
 * Author: houzm
 * Date: Created in 2018/9/10 11:58
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 * 基于server send event服务端发送事件的服务端推送
 */
@RestController
@RequestMapping(value = "api/")
@Api(value = "api/")
public class ServerSendEventController {

    @RequestMapping(value = "/serversend", method = RequestMethod.GET, produces = "text/event-stream")
    @ApiOperation(value = "/serversend")
    public @ResponseBody String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3 "+r.nextInt()+"\n\n";
    }

}
