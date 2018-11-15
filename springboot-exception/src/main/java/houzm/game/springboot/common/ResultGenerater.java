package houzm.game.springboot.common;

/**
 * Package: houzm.game.springboot.common
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 18:11
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： ResultGenerater
 */
public class ResultGenerater {

    public static Result success(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS.getCode())
                .setSuccess(true)
                .setMessage("SUCCESS")
                .setData(data);
    }

    public static Result success() {
        return new Result()
                .setCode(ResultCode.SUCCESS.getCode())
                .setSuccess(true)
                .setMessage("SUCCESS");
    }

    public static Result fail(String message) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR.getCode())
                .setSuccess(false)
                .setMessage(message);
    }
}
