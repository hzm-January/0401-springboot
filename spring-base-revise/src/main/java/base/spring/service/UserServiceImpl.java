package base.spring.service;

import base.spring.dao.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: base.spring.service
 * Author: houzm
 * Date: Created in 2018/9/2 20:17
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;
    @Override
    public void queryById(String id) {
        userRespository.selectUserById(id);
    }
}
