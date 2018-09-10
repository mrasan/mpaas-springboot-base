package com.definesys.mpaas.infra.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/9/9 下午5:55
 * @history: 1.2018/9/9 created by jianfeng.zheng
 */
public class LoginRequest {
    private String uid;
    private String password;
    private Map<String,String> attributes;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String key,String value){
        if(this.attributes==null){
            this.attributes=new HashMap<String,String>();
        }
        this.attributes.put(key,value);
    }
}
