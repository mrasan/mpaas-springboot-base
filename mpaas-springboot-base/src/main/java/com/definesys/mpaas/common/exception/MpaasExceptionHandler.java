package com.definesys.mpaas.common.exception;

import com.definesys.mpaas.common.conf.MpaasConfig;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.common.util.MpaasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/8/27 下午2:50
 * @history: 1.2018/8/27 created by jianfeng.zheng
 */
@ControllerAdvice
public class MpaasExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MpaasConfig config;
    public static final String DEV = "DEV";
    public static final String PROD = "PROD";


    /**
     * 处理系统异常返回500
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {MpaasRuntimeException.class})
    protected ResponseEntity<Object> handleRuntimeException(
            RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        System.out.println(ex.getClass());
        String msg = config.getErrormsg() == null ? "系统出错请联系管理员" : config.getErrormsg();
        if (DEV.equalsIgnoreCase(config.getMode())) {
            msg = MpaasUtil.getThrowableDetail(ex);
        }
        return handleExceptionInternal(ex, Response.error(msg),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    /**
     * 处理业务异常返回200
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {MpaasBusinessException.class})
    protected ResponseEntity<Object> handleBusinessException(
            RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        return handleExceptionInternal(ex, Response.error(ex.getMessage()),
                new HttpHeaders(), HttpStatus.OK, request);
    }


}
