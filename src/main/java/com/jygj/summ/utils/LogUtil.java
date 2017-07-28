package com.jygj.summ.utils;


import org.apache.log4j.Logger;

/**
 * Created by M.c on 2015/12/26.
 */
public class LogUtil {

    public static Logger getLogger() {
        return Logger.getLogger(new Throwable().getStackTrace()[2].getClass());
    }

    public static void i(String msg) {
        System.out.println(msg);
    }

    public static void e(String msg) {
        LogUtil.getLogger().error(msg);
    }

}
