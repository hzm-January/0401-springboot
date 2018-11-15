package houzm.game.springboot.pojo;

import org.springframework.stereotype.Component;

/**
 * Package: houzm.accumulation.springboot.pojo
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/8 10:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： DemoObj
 */
@Component
public class DemoObj {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DemoObj{" +
                "id='" + id + '\'' +
                '}';
    }
}
