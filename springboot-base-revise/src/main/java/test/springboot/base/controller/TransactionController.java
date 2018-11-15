package test.springboot.base.controller;

import test.springboot.base.service.DemoTransactionService;
import test.springboot.base.service.DemoTransactionServiceBatch;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Package: test.springboot.base.controller
 * Author: houzm
 * Date: Created in 2018/9/29 13:41
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 测试springboot事务
 */
@RestController
@RequestMapping(value = "/api/transaction")
@Api(value = "/api/transaction")
public class TransactionController {

    @Resource(name = "tansactionServiceBatch")
    private DemoTransactionServiceBatch demoTransactionServiceBatch;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "/", notes = "批量查询测试")
    public List<String> queryBatch() {
        return demoTransactionServiceBatch.queryBatch();
    }

}
