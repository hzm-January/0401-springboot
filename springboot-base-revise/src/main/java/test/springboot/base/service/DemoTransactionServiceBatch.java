package test.springboot.base.service;

import java.util.List;

/**
 * Package: test.springboot.base.service
 * Author: houzm
 * Date: Created in 2018/9/29 13:45
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 事务测试接口
 */
public interface DemoTransactionServiceBatch {
    List<String> queryBatch();
}
