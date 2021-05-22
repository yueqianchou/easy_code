package com.day.util;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

public class EprInfoUtil {
    /**
     * 字典转换通用方法
     */
    public static String commonDict(Map<String, Map<String, String>> eprDictMap, String code, String param) {
        return eprDictMap.get(code) != null
                ? eprDictMap.get(code).getOrDefault(param, "")
                : "";
    }

    /**
     * 日期转换 date to string
     */
    public static String transferDateToString(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Shanghai")));
    }

    /**
     * 日期转换 string to date
     */
    public static Date transferStringToDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Double 转 String
     */
    public static String double2String(Double num) {
        return String.valueOf(num == null ? "" : num);
    }

    /**
     * String 转 Double
     */
    public static Double string2Double(String str) {
        return Double.valueOf(StringUtils.isEmpty(str) ? "0.0" : str);
    }
}
