package base.springmvc.aop;

import base.springmvc.User;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Package: base.springmvc.aop
 * Author: houzm
 * Date: Created in 2018/9/17 10:49
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public interface UserService {
    void addUser(User user) throws JsonProcessingException;
}
