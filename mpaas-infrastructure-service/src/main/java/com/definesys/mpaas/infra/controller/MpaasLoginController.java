package com.definesys.mpaas.infra.controller;

import com.definesys.mpaas.common.adapter.UserProfile;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.infra.model.LoginRequest;
import com.definesys.mpaas.infra.service.MpaasLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午5:53
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
@RestController
public class MpaasLoginController {

    @Autowired
    private MpaasLoginService service;


    /**
     * 登陆接口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/infra/login", method = RequestMethod.POST)
    public Response login(@RequestBody Map<String, String> request,HttpServletResponse response) {
        LoginRequest lg = new LoginRequest();
        for (String key : request.keySet()) {
            if ("uid".equalsIgnoreCase(key)) {
                lg.setUid(request.get("uid"));
            }
            if ("password".equalsIgnoreCase(key)) {
                lg.setPassword(request.get("password"));
            }
            lg.addAttribute(key, request.get(key));
        }
        UserProfile user=service.login(lg);
        response.addCookie(new Cookie("MPAASID",user.getToken()));
        response.addHeader("token",user.getToken());
        return Response.ok().setData(user);
    }
}
