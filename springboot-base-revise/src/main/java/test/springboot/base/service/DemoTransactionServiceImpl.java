package test.springboot.base.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Package: test.springboot.base.service
 * Author: houzm
 * Date: Created in 2018/9/29 13:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 事务测试类
 */
@Service(value = "demoTransactionService")
public class DemoTransactionServiceImpl implements DemoTransactionService {
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String querySingle(Integer key) {
//        if (key % 2 == 0) {
//            throw new IllegalStateException("测试异常");
//        }
        return String.valueOf(key);
    }
}
