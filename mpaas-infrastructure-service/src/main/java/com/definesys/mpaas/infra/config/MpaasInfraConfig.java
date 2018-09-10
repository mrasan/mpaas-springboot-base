package com.definesys.mpaas.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午6:34
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
@Configuration
public class MpaasInfraConfig {
    @Value("${mpaas.infra.jwt.secret}")
    public String JWT_SECRET;

    @Value("${mpaas.infra.ldap.principal:}")
    public String ldap_principal;

    @Value("${mpaas.infra.ldap.url:}")
    public String ldap_url;

    @Value("${mpaas.infra.ldap.port:}")
    public String ldap_port;

}
