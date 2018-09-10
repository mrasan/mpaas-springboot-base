package com.definesys.mpaas.infra.service;

import com.definesys.mpaas.common.adapter.IMpaasAuthentication;
import com.definesys.mpaas.common.adapter.UserProfile;
import com.definesys.mpaas.infra.config.MpaasInfraConfig;
import com.definesys.mpaas.infra.model.LoginRequest;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午5:53
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
@Component
public class MpaasLoginService {

    @Autowired
    private MpaasInfraConfig config;


    @Autowired
    private IMpaasAuthentication authentication;

    /**
     * 登陆服务
     *
     * @param request
     */
    public UserProfile login(LoginRequest request) {
        UserProfile user  = authentication.auth(request.getUid(), request.getPassword(), request.getAttributes());
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date(System.currentTimeMillis());
        Key signingKey = new SecretKeySpec(config.JWT_SECRET.getBytes(), signatureAlgorithm.getJcaName());
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        JwtBuilder builder = Jwts.builder().setId(user.getUid())
                .setIssuedAt(now)
                .setIssuer(user.getUid())
                .setSubject(user.getUserName())
                .setHeader(header)
                .signWith(signatureAlgorithm, signingKey);
        user.setToken(builder.compact());
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
        return user;
    }
}
