package com.definesys.mpaas.common.adapter;

import com.definesys.mpaas.common.exception.MpaasBusinessException;

import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午7:57
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
public interface IMpaasAuthentication {


    /**
     * 中台认证服务
     * @param userName      用户名
     * @param password      密码
     * @param attributes    额外属性
     * @return
     */
    public UserProfile auth(String userName, String password, Map<String, String> attributes)throws MpaasBusinessException;
}
