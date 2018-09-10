package com.definesys.mpaas.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * 接口返回规范
 * 主要考虑之前code过于简单无法描述更多信息因此这里采用http标准响应编码和业务错误编码结合的方式
 * 规定:
 * 如果是系统级别错误,code使用http标准编码表示具体见code字段定义
 * 如果是业务级别错误,如数据验证不通过使用业务错误编码表示,具体见code字段定义
 * 项目组需要维护业务错误编码和错误描述关系,类似ora错误,做到任何一个业务错误编码都能找到具体原因
 * 对象类型数据和列表类型数据用不同字段表示
 * 开发人员根据接口逻辑选择存放数据字段,前端开发人员根据接口文档从特定的字段取数据
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/8/26 下午6:18
 * @history: 1.2018/8/26 created by jianfeng.zheng
 */
public class Response implements Serializable{
    /**
     * http规范：
     * 200:调用成功
     * 404:资源未找到
     * 500:系统出错
     * 401:未授权
     * ok:成功
     * error:失败
     */
    private String code = CODE_OK;
    private String message; //记录错误信息或者需要提示给用户的信息
    private Long total; //记录总数
    private Object data; //非列表数据
    private List<Object> table; //列表数据


    public static final String CODE_OK = "ok";
    public static final String CODE_ERR = "error";
    public static final Response OK = new Response(CODE_OK, null);

    public Response() {
        this.code = CODE_OK;
    }


    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response error(String message) {
        return new Response(CODE_ERR,message);
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public Response addListItem(Object item) {
        if (this.table == null) {
            this.table = new ArrayList<Object>();
            this.total = 0L;
        }
        this.table.add(item);
        this.total = this.total + 1;
        return this;
    }

    public Response setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Response setTotal(Integer total) {
        this.total = Long.valueOf(total);
        return this;
    }

    public static Response ok() {
        return new Response();
    }

    public Response set(String field, String value) {
        if (this.data == null || !(this.data instanceof Map)) {
            this.data = new HashMap<String, Object>();
        }
        ((Map) this.data).put(field, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public Object getData() {
        return data;
    }

    public List<Object> getTable() {
        return table;
    }

    public void setTable(List table) {
        this.total = Long.valueOf(table.size());
        this.table = table;
    }
}
