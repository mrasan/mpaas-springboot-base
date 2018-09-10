package com.definesys.mpaas.common.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/8/27 下午3:59
 * @history: 1.2018/8/27 created by jianfeng.zheng
 */
@Component
@ConfigurationProperties(prefix = "spring.mpaas")
public class MpaasConfig {
    private String mode;
    private String errormsg;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
