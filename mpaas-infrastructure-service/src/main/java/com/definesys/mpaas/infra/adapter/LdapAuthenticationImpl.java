package com.definesys.mpaas.infra.adapter;

import com.definesys.mpaas.common.adapter.IMpaasAuthentication;
import com.definesys.mpaas.common.adapter.UserProfile;
import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.common.util.MpaasUtil;
import com.definesys.mpaas.infra.config.MpaasInfraConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午8:08
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
@Service
@Primary
public class LdapAuthenticationImpl implements IMpaasAuthentication {

    @Autowired
    private MpaasInfraConfig config;

    @Override
    public UserProfile auth(String uid, String password, Map<String, String> attributes) throws MpaasBusinessException {
        if (MpaasUtil.strEmpty(config.ldap_principal)) {
            throw new MpaasBusinessException("mpaas.infra.ldap.principal config lost");
        }
        String udn = config.ldap_principal;
        udn = udn.replaceAll("\\{uid\\}", uid);

        Hashtable ldapEnv = new Hashtable();

        ldapEnv.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");

        ldapEnv.put("java.naming.provider.url", "ldap://" + config.ldap_url + ":" + config.ldap_port);
        ldapEnv.put("java.naming.security.authentication", "simple");
        ldapEnv.put("java.naming.security.principal", udn);
        ldapEnv.put("java.naming.security.credentials", password);
        ldapEnv.put("com.sun.jndi.ldap.connect.timeout", "5000");
        try {
            LdapContext context = new InitialLdapContext(ldapEnv, null);
            context.close();
        } catch (NamingException e) {
            throw new MpaasBusinessException("用户不存在或者密码错误");
        } catch (Exception ex) {
            throw new MpaasRuntimeException(ex.getMessage());
        }
        UserProfile profile = new UserProfile();
        profile.setUserName(uid);
        profile.setUid(uid);
        return profile;
    }
}
