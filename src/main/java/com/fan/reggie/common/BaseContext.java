package com.fan.reggie.common;

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户ID
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
