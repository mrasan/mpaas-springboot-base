package com.definesys.mpaas.common.util;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2018/8/27 下午2:52
 * @history: 1.2018/8/27 created by jianfeng.zheng
 */
public class MpaasUtil {

    public static String getThrowableDetail(Throwable s) {
        final String NEW_LINE = System.getProperty("line.separator");
        if (s == null) {
            return NEW_LINE;
        }
        StringBuffer result = new StringBuffer();
        result.append(s.toString());
        result.append(NEW_LINE);
        for (StackTraceElement element : s.getStackTrace()) {
            result.append(element);
            result.append(NEW_LINE);
        }
        result.append("Caused by:");
        result.append(NEW_LINE);
        result.append(s.getCause());
        return result.toString();
    }

    public static boolean strEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }
}
