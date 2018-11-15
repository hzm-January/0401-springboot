package houzm.game.springboot.common;

import java.io.Serializable;

/**
 * Package: houzm.game.springboot.common
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 18:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： Result
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -6463450523447330081L;
    private int code;
    private Boolean success;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Result setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
