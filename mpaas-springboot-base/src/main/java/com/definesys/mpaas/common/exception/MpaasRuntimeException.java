package com.definesys.mpaas.common.exception;


/**
 * @Copyright: Shanghai Mitsubishi Elevator Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/8/27 下午2:43
 * @history: 1.2018/8/27 created by jianfeng.zheng
 */
public class MpaasRuntimeException extends RuntimeException {

    public MpaasRuntimeException(Throwable cause) {
        super(cause);
        cause.printStackTrace();
    }

    public MpaasRuntimeException(Object owner, Throwable cause) {
        super(cause);
        cause.printStackTrace();
    }

    public MpaasRuntimeException(String message) {
        super(message);
    }
}
