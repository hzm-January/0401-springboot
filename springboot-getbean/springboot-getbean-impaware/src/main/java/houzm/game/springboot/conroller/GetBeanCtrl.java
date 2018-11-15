package houzm.game.springboot.conroller;

import houzm.game.springboot.holder.SpringContextHolder;
import houzm.game.springboot.pojo.DemoObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.accumulation.springboot.conroller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/8 10:36
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： GetBeanCtrl
 */
@RestController
@RequestMapping("/api/get-bean/")
@DependsOn(value = "springContextHolder")
public class GetBeanCtrl {

    @GetMapping("")
    public void getBean() {
        method5();
    }

    private void method5() {
        DemoObj bean = SpringContextHolder.getApplicationContext().getBean(DemoObj.class);
        System.out.println(bean);
    }
}
