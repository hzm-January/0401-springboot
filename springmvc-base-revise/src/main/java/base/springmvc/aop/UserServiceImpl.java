package base.springmvc.aop;

import base.springmvc.User;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package: base.springmvc.aop
 * Author: houzm
 * Date: Created in 2018/9/17 10:49
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： user 业务层
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(user));
    }
}
