package com.day.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Utils - 日期/时间转换
 *
 * @version 1.0
 */
public final class DateTimeUtil {

    /**
     *  G    Era    标志符            Text    公元
     y    年                    Year    1996; 96
     M    年中的月份                Month    July; Jul; 07
     w    年中的周数                Number    27
     W    月份中的周数            Number    2
     D    年中的天数                Number    189
     d    月份中的天数            Number    10
     F    月份中的星期            Number    2
     E    星期中的天数            Text    Tuesday; Tue
     a    am/pm 标记            Text    PM
     H    一天中的小时数（0-23）    Number    0
     k    一天中的小时数（1-24）    Number    24
     K    am/pm 中的小时数（0-11）    Number    0
     h    am/pm 中的小时数（1-12）    Number    12
     m    小时中的分钟数            Number    30
     s    分钟中的秒数            Number    55
     S    毫秒数                Number    978
     z    时区    General time zone    Pacific Standard Time; PST; GMT-08:00
     Z    时区    RFC 822 time zone    -0800
     */


    /**
     * 中国时区
     */
    public final static String TIME_ZONE_CN = "GMT+8";

    /**
     * 把时间格式化成如：2002-08-03 8:26:30.400 am 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmmssSa_12 = "yyyy-MM-dd KK:mm:ss.S a";

    /**
     * 把时间格式化成如：2002-08-03 8:26:16 am 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmmssa_12 = "yyyy-MM-dd KK:mm:ss a";

    /**
     * 把时间格式化成如：2002-08-03 8:26 am 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmma_12 = "yyyy-MM-dd KK:mm a";

    /**
     * 把时间格式化成如：2002-08-03 8 am 格式的字符串
     */
    public final static String FMT_yyyyMMddHHa_12 = "yyyy-MM-dd KK a";

    /**
     * 把时间格式化成如：2002-08-03 08:26:30.400 am  格式的字符串
     */
    public final static String FMT_yyyyMMddHHmmssSa = "yyyy-MM-dd HH:mm:ss.S a";

    /**
     * 把时间格式化成如：2002-08-03 08:26:30.400 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 把时间格式化成如：2002-08-03 08:26:16 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 把时间格式化成如：2002-08-03 08:26 格式的字符串
     */
    public final static String FMT_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";

    /**
     * 把时间格式化成如：2002-08-03 08 格式的字符串
     */
    public final static String FMT_yyyyMMddHH = "yyyy-MM-dd HH";

    /**
     * 把时间格式化成如：2002-07-05 am 格式的字符串
     */
    public final static String FMT_yyyyMMdda = "yyyy-MM-dd a";

    /**
     * 把时间格式化成如：2002-07-05 格式的字符串
     */
    public final static String FMT_yyyyMMdd = "yyyy-MM-dd";

    /**
     * 把时间格式化成如：2002-07 格式的字符串
     */
    public final static String FMT_yyyyMM = "yyyy-MM";

    /**
     * 把时间格式化成如：20020803082630400格式的(17位)字符串
     */
    public final static String FMT_yyyyMMddHHmmssS_17 = "yyyyMMddHHmmssS";

    /**
     * 把时间格式化成如：20020803082630格式的(14位)字符串
     */
    public final static String FMT_yyyyMMddHHmmss_14 = "yyyyMMddHHmmss";

    /**
     * 把时间格式化成如：20020806 格式的(8位)字符串
     */
    public final static String FMT_yyyyMMdd_8 = "yyyyMMdd";

    /**
     * 把时间格式化成如：200208 格式的(6位)字符串
     */
    public final static String FMT_yyyyMM_6 = "yyyyMM";

    /**
     * 把时间格式化成如：12:08 PM(下午) 格式的字符串
     */
    public final static String FMT_HHmmA_12 = "KK:mm a";

    /**
     * 把时间格式化成如：0:55 AM上午，CST 格式的字符串
     */
    public final static String FMT_HHmmAz_12 = "KK:mm a,z";

    /**
     * 把时间格式化成如：0:56 AM上午，中国标准时间 格式的字符串
     */
    public final static String FMT_HHmmAzzzz_12 = "KK:mm a,zzzz";

    /**
     * 把时间格式化成如：12:08:23 am 格式的字符串
     */
    public final static String FMT_HHmmssA_12 = "KK:mm:ss a";

    /**
     * 把时间格式化成如：0:55:33 AM上午，CST 格式的字符串
     */
    public final static String FMT_HHmmssAz_12 = "KK:mm:ss a,z";

    /**
     * 把时间格式化成如：0:56:23 AM上午，中国标准时间 格式的字符串
     */
    public final static String FMT_HHmmssAzzzz_12 = "KK:mm:ss a,zzzz";

    /**
     * 把时间格式化成如：22:04:45 格式的字符串
     */
    public final static String FMT_HHmmss = "HH:mm:ss";

    /**
     * 把时间格式化成如：22:04:45.824 格式的字符串
     */
    public final static String FMT_HHmmssS = "HH:mm:ss.S";

    /**
     * 把时间格式化成如：22:04 格式的字符串
     */
    public final static String FMT_HHmm = "HH:mm";

    /**
     * 把时间格式化成如：22:04，CST 格式的字符串
     */
    public final static String FMT_HHmmz = "HH:mm,z";

    /**
     * 把时间格式化成如：22:04，中国标准时间 格式的字符串
     */
    public final static String FMT_HHmmzzzz = "HH:mm,zzzz";

    /**
     * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
     */
    public final static String FMT_WWMMDDYY_EN = "EEE,MMM d,''yyyy";

    /**
     * 把时间格式化成如：星期日，2004年十一月14号 格式的字符串
     */
    public final static String FMT_WWMMDDYY_CN = "EEE,yyyy年MMMd号";

    /**
     * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
     */
    public final static String FMT_MMDDYY_EN = "MMM d,''yyyy";

    /**
     * 把时间格式化成如：星期日，2004年十一月14号 格式的字符串
     */
    public final static String FMT_MMDDYY_CN = "yyyy年MMMd号";

    /**
     * 把时间格式化成如：星期几 格式的字符串，即可获得该日这个时间是星期几
     */
    public final static String FMT_WW = "EEE";

    /**
     * 常用的格式化时间的格式组，用于本类中格式化字符串成时间型
     */
    private final static String[] formatStr = {FMT_yyyyMMddHHmmssS, FMT_yyyyMMddHHmmss, FMT_yyyyMMddHHmm,
            FMT_yyyyMMddHH, FMT_yyyyMMdd, FMT_HHmmss, FMT_HHmmssS, FMT_HHmm, FMT_HHmmz, FMT_HHmmzzzz,
            FMT_yyyyMMddHHmmssSa_12, FMT_yyyyMMddHHmmssa_12, FMT_yyyyMMddHHmma_12, FMT_yyyyMMddHHa_12,
            FMT_yyyyMMdda, FMT_HHmmA_12, FMT_HHmmAz_12, FMT_HHmmAzzzz_12, FMT_HHmmssA_12, FMT_HHmmssAz_12,
            FMT_HHmmssAzzzz_12, FMT_yyyyMMddHHmmssSa};

    /**
     * 私有化构造器，使得不能产生该类对象，类中所有的方法均为静态方法
     */
    private DateTimeUtil() {
    }

    /**
     * 根据给出的Date值和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
     *
     * @param date      日期对象
     * @param formatStr 日期格式
     * @return 如果为null，返回字符串""
     */
    public static String formatDateTimetoString(Date date, String formatStr) {
        String reStr = "";
        if (date == null || formatStr == null || formatStr.trim().length() < 1) {
            return reStr;
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        sdf.applyPattern(formatStr);
        reStr = sdf.format(date);
        return reStr == null ? "" : reStr;
    }

    /**
     * 获取系统时间
     *
     * @param fmtstr 日期格式
     * @return 系统时间
     */
    public static Date getSystemDate(String fmtstr) {
        try {
            return parseToDate(formatDateTimetoString(getSystemDate(), fmtstr));
        } catch (Exception e) {
            e.printStackTrace();
            return getSystemDate();
        }

    }

    /**
     * 根据给出的Date值和格式串采用给定的国家所在的国家风格来格式化时间，并返回相应的字符串
     *
     * @param date      日期对象
     * @param formatStr 日期格式
     * @param locale    日期格式符号要被使用的语言环境
     * @return 如果为null，返回字符串""
     */
    public static String formatDateTimetoString(Date date, String formatStr, Locale locale) {
        String reStr = "";
        if (date == null || formatStr == null || locale == null || formatStr.trim().length() < 1) {
            return reStr;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
        reStr = sdf.format(date);
        return reStr == null ? "" : reStr;
    }

    /**
     * 根据给出的Date值字符串和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
     *
     * @param dateStr   日期字符串
     * @param formatStr 日期格式
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDateTimetoString(String dateStr, String formatStr) throws Exception {
        String dStr = "";
        if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0) {
            dStr = formatDateTimetoString(parseToDate(dateStr), formatStr);
        }
        return dStr;
    }

    /**
     * 根据给出的Date值字符串和格式串采用指定国家的风格来格式化时间，并返回相应的字符串
     *
     * @param dateStr   日期字符串
     * @param formatStr 日期格式
     * @param locale    日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDateTimetoString(String dateStr, String formatStr, Locale locale) throws Exception {
        String dStr = "";
        if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0
                && locale != null) {
            dStr = formatDateTimetoString(parseToDate(dateStr, locale), formatStr, locale);
        }
        return dStr;
    }

    /**
     * 按指定的格式和操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr 日期毫秒字符串
     * @param formatStr   日期格式
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr, String formatStr) throws Exception {
        if (dateTimeStr == null || formatStr == null || dateTimeStr.trim().length() < 1
                || formatStr.trim().length() < 1) {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * 按指定的格式和指定国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr 日期字符串
     * @param formatStr   日期格式
     * @param locale      日期格式符号要被使用的语言环境
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr, String formatStr, Locale locale) throws Exception {
        if (dateTimeStr != null && formatStr != null && locale != null && dateTimeStr.trim().length() > 0
                && formatStr.trim().length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
            try {
                return sdf.parse(dateTimeStr);
            } catch (ParseException e) {
                throw new Exception(e);
            }
        } else {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr、locale不能是null或空格串！");
        }

    }

    /**
     * 按操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr 日期字符串
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr) throws Exception {
        if (dateTimeStr == null || dateTimeStr.trim().length() < 1) {
            throw new IllegalArgumentException("参数dateTimeSt不能是null或空格串！");
        }
        int formatStrLength = formatStr.length;
        int i = 0;

        for (i = 0; i < formatStrLength; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i]);
            try {
                return sdf.parse(dateTimeStr);
            } catch (ParseException e) {
            }
        }
        throw new Exception("日期格式不正确！");
    }

    /**
     * 根据给出的年月和日返回一个日期型的对象
     *
     * @param year  年
     * @param month 月 ，1到12
     * @param day   日 ，1到31
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(int year, int month, int day) throws Exception {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("参数不正确！");
        }
        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);
        String dayStr = String.valueOf(day);

        return parseToDate(yearStr + "-" + monthStr + "-" + dayStr);

    }

    /**
     * 根据给出的年月日、时分秒、返回一个对应的Date型对象
     *
     * @param year  年
     * @param month 月 ，1到12
     * @param day   日 ，1到31
     * @param h     小时，从0到23
     * @param m     分，从0到60
     * @param s     秒，从0到60
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(int year, int month, int day, int h, int m, int s) throws Exception {
        if (month < 1 || month > 12 || day < 1 || day > 31 || h < 0 || h > 23 || m < 0 || m > 60 || s < 0 || s > 60) {
            throw new IllegalArgumentException("参数不正确！");
        }
        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);
        String dayStr = String.valueOf(day);
        String hStr = String.valueOf(h);
        String mStr = String.valueOf(m);
        String sStr = String.valueOf(s);

        return parseToDate(yearStr + "-" + monthStr + "-" + dayStr + " " + hStr + ":" + mStr + ":" + sStr);

    }

    /**
     * 按指定国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr 日期字符串
     * @param locale      日期格式符号要被使用的语言环境
     * @return java.util.Date类型对象
     * @throws Exception 可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr, Locale locale) throws Exception {
        if (dateTimeStr == null || dateTimeStr.trim().length() < 1 || locale == null) {
            throw new IllegalArgumentException("参数dateTimeSt、locale不能是null或空格串！");
        }
        int formatStrLength = formatStr.length;
        int i = 0;
        SimpleDateFormat sdf = null;
        for (i = 0; i < formatStrLength; i++) {
            sdf = new SimpleDateFormat(formatStr[i], locale);
            try {
                return sdf.parse(dateTimeStr);
            } catch (ParseException e) {
            }
        }
        throw new Exception("日期格式不正确！");
    }

    /**
     * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串
     *
     * @param dateTimeStr 日期字符串
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDateTimetoString(String dateTimeStr) throws Exception {
        return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss);
    }

    /**
     * 将给定的日期时间字符串按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串
     *
     * @param dateTimeStr 日期字符串
     * @param locale      日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDateTimetoString(String dateTimeStr, Locale locale) throws Exception {
        return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss, locale);
    }

    /**
     * 将给定的日期时间按操作系统默认的国家内格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串
     *
     * @param dateTime 日期对象
     * @return 如果为null，返回""
     */
    public static String formatDateTimetoString(Date dateTime) {
        return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss);
    }

    /**
     * 将给定的日期时间按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串
     *
     * @param dateTime 日期对象
     * @param locale   日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     */
    public static String formatDateTimetoString(Date dateTime, Locale locale) {
        return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss, locale);
    }

    /**
     * 将给定的日期字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd"格式的日期串
     *
     * @param dateStr 日期字符串
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDatetoString(String dateStr) throws Exception {
        return formatDateTimetoString(dateStr, FMT_yyyyMMdd);
    }

    /**
     * 将给定的日期字符串按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串
     *
     * @param dateStr 日期字符串
     * @param locale  日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatDatetoString(String dateStr, Locale locale) throws Exception {
        return formatDateTimetoString(dateStr, FMT_yyyyMMdd, locale);
    }

    /**
     * 将给定的日期按指定操作系统默认国家的风格格式化成"yyyy-MM-dd"格式的日期串
     *
     * @param d 日期对象
     * @return 如果为null，返回""
     */
    public static String formatDatetoString(Date d) {
        return formatDateTimetoString(d, FMT_yyyyMMdd);
    }

    /**
     * 将给定的日期按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串
     *
     * @param d      日期对象
     * @param locale 日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     */
    public static String formatDatetoString(Date d, Locale locale) {
        return formatDateTimetoString(d, FMT_yyyyMMdd, locale);
    }

    /**
     * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"HH:mm:ss"格式的时间串
     *
     * @param dateTimeStr 日期字符串
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatTimetoString(String dateTimeStr) throws Exception {
        return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
    }

    /**
     * 将给定的日期时间字符串按指定国家的风格格式化成"HH:mm:ss"格式的时间串
     *
     * @param dateTimeStr 日期字符串
     * @param locale      日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     * @throws Exception 可能抛出的异常
     */
    public static String formatTimetoString(String dateTimeStr, Locale locale) throws Exception {
        return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
    }

    /**
     * 将给定的日期时间按指定操作系统默认国家的风格格式化成"HH:mm:ss"格式的时间串
     *
     * @param dateTimeStr 日期字符串
     * @return 如果为null，返回""
     */
    public static String formatTimetoString(Date dateTimeStr) {
        return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
    }

    /**
     * 将给定的日期时间按指定国家的风格格式化成"HH:mm:ss"格式的时间串
     *
     * @param dateTimeStr 日期字符串
     * @param locale      日期格式符号要被使用的语言环境
     * @return 如果为null，返回""
     */
    public static String formatTimetoString(Date dateTimeStr, Locale locale) {
        return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
    }

    /**
     * 返回一个时间的年份整数
     *
     * @param d 日期对象
     * @return 年份
     */
    public static int getYearOfDate(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回一个时间的月份整数
     *
     * @param d 日期对象
     * @return 月份
     */
    public static int getMonthOfYear(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定日期的1号0点0分0秒
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    public static Date getDateByFirstDayOfMonth(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的最后一天23点59分59秒
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    public static Date getDateByLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month);
        //获取某月最大天数
        int lastDayNumOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDayNumOfMonth);
        Date tmp = cal.getTime();
        return DateTimeUtil.getLastDate(tmp);
    }

    /**
     * 返回一个时间的天份整数，是这个月的第几天
     *
     * @param d 日期对象
     * @return 天份
     */
    public static int getDayOfMonth(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回一个时间的天份整数，是这个半年的第几天
     *
     * @param d 日期对象
     * @return 天份
     */
    public static int getDayOfHalfYear(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        Date time1 = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.MONTH, 5);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        Date time2 = calendar2.getTime();
        return (int) DateTimeUtil.getDaysOfTwoDate(time1, time2) + 1;
    }

    /**
     * 返回一个时间的天份整数，是这个年份的第几天
     *
     * @param d 日期对象
     * @return 天份
     */
    public static int getDayOfYear(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 返回一个时间的天份整数，是这个周的第几天
     *
     * @param d 日期对象
     * @return 天份
     */
    public static int getDayOfWeek(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 返回一个时间的周的整数，是这个月的第几周
     *
     * @param d 日期对象
     * @return 周
     */
    public static int getWeekOfMonth(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 返回一个时间的周的整数，是这个年份的第几周
     *
     * @param d 日期对象
     * @return 周
     */
    public static int getWeekOfYear(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 返回该时间所对应的在一天中的小时数的整数，如当前(Date now)是下午3点，返回为15
     *
     * @param d 日期对象
     * @return 小时
     */
    public static int getHoursOfDay(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        return hours;
    }

    /**
     * 返回该时间所对应的在一天中的小时数的整数(采用12小时制)，如当前(Date now)是下午3点，返回为3
     *
     * @param d 日期对象
     * @return 小时
     */
    public static int getHoursOfDay12(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int hours = calendar.get(Calendar.HOUR);
        return hours;
    }

    /**
     * 返回该时间所对应的分钟数中的整数，如now是15点14分，则返回14
     *
     * @param d 日期对象
     * @return 分钟
     */
    public static int getMinutesOfHour(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int minutes = calendar.get(Calendar.MINUTE);

        return minutes;
    }

    /**
     * 返回该时间所对应的秒数中的整数，如now是15点14分34秒，则返回34
     *
     * @param d 日期对象
     * @return 秒
     */
    public static int getSecondsOfMinute(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int seconds = calendar.get(Calendar.SECOND);

        return seconds;
    }

    /**
     * 返回该时间所对应的毫秒数中的整数，如now是15点14分34秒470毫秒，则返回470
     *
     * @param d 日期对象
     * @return 毫秒
     */
    public static int getMillisecondsOfSecond(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        return millisecond;
    }

    /**
     * 返回该时间相对于1970年1月1日开始计算的对应的毫秒数
     *
     * @param d 日期对象
     * @return 毫秒数
     */
    public static long getTime(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        return d.getTime();
    }

    /**
     * 比较两个时间的先后顺序。 如果时间d1在d2之前，返回1，如果时间d1在d2之后，返回-1，如果二者相等，返回0
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 如果时间d1在d2之前，返回1，如果时间d1在d2之后，返回-1，如果二者相等，返回0
     */
    public static int compareTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }

        long dI1 = d1.getTime();
        long dI2 = d2.getTime();

        if (dI1 > dI2) {
            return -1;
        } else if (dI1 < dI2) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * 返回两个日期之间的毫秒数的差距
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 二者至1970年1.1后的毫秒数的差值
     */
    public static long getMillisecondsOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        long dI1 = d1.getTime();
        long dI2 = d2.getTime();
        return (dI1 - dI2);
    }

    /**
     * 获得两个日期之间相差的秒数
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 两日期之间相差的秒数
     */
    public static double getSecondsOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        long i = getMillisecondsOfTwoDate(d1, d2);

        return (double) i / 1000;
    }

    /**
     * 获得两个日期之间相差的分钟数
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 两日期之间相差的分钟数
     */
    public static double getMinutesOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        long millions = getMillisecondsOfTwoDate(d1, d2);
        return (double) millions / 60 / 1000;
    }

    /**
     * 获得两个日期之间相差的小时数
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 两日期之间相差的小时数
     */
    public static double getHoursOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        long millions = getMillisecondsOfTwoDate(d1, d2);
        return (double) millions / 60 / 60 / 1000;
    }

    /**
     * 获得两个日期之间相差的天数
     *
     * @param d1 日期对象
     * @param d2 日期对象
     * @return 两日期之间相差的天数
     */
    public static double getDaysOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        long millions = getMillisecondsOfTwoDate(d1, d2);
        return (double) millions / 24 / 60 / 60 / 1000;
    }

    /**
     * 把给定的时间加上指定的时间值，可以为负
     *
     * @param d     需要设定的日期对象
     * @param times 时间值
     * @param type  类型，Calendar.MILLISECOND，毫秒<BR>
     *              Calendar.SECOND，秒<BR>
     *              Calendar.MINUTE，分钟<BR>
     *              Calendar.HOUR，小时<BR>
     *              Calendar.DATE，日<BR>
     * @return 如果d为null，返回null
     */
    public static Date addTime(Date d, double times, int type) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        long qv = 1;
        switch (type) {
            case Calendar.MILLISECOND:
                qv = 1;
                break;
            case Calendar.SECOND:
                qv = 1000;
                break;
            case Calendar.MINUTE:
                qv = 1000 * 60;
                break;
            case Calendar.HOUR:
                qv = 1000 * 60 * 60;
                break;
            case Calendar.DATE:
                qv = 1000 * 60 * 60 * 24;
                break;
            default:
                throw new RuntimeException("时间类型不正确!type＝" + type);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        long milliseconds = (long) Math.round(Math.abs(times) * qv);
        if (times > 0) {
            for (; milliseconds > 0; milliseconds -= 2147483647) {
                if (milliseconds > 2147483647) {
                    calendar.add(Calendar.MILLISECOND, 2147483647);
                } else {
                    calendar.add(Calendar.MILLISECOND, (int) milliseconds);
                }
            }
        } else {
            for (; milliseconds > 0; milliseconds -= 2147483647) {
                if (milliseconds > 2147483647) {
                    calendar.add(Calendar.MILLISECOND, -2147483647);
                } else {
                    calendar.add(Calendar.MILLISECOND, -(int) milliseconds);
                }
            }
        }
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的年份，可以为负，返回新的被加上了年份的日期对象，不影响参数日期对象值
     *
     * @param d     需要设定的日期对象
     * @param years 年份
     * @return 新日期对象
     */
    public static Date addYears(Date d, int years) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的月份，可以为负
     *
     * @param d      需要设定的日期对象
     * @param months 月份
     * @return 新日期对象
     */
    public static Date addMonths(Date d, int months) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的天数，可以为负
     *
     * @param d    需要设定的日期对象
     * @param days 天数
     * @return 新日期对象
     */
    public static Date addDays(Date d, int days) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR, days * 24);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的小时，可以为负
     *
     * @param d     需要设定的日期对象
     * @param hours 小时
     * @return 新日期对象
     */
    public static Date addHours(Date d, int hours) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的分钟，可以为负
     *
     * @param d       需要设定的日期对象
     * @param minutes 分钟
     * @return 新日期对象
     */
    public static Date addMinutes(Date d, int minutes) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的秒数，可以为负
     *
     * @param d       需要设定的日期对象
     * @param seconds 秒
     * @return 新日期对象
     */
    public static Date addSeconds(Date d, int seconds) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     * 把给定的时间加上指定的毫秒数，可以为负
     *
     * @param d            需要设定的日期对象
     * @param milliseconds 毫秒
     * @return 新日期对象
     */
    public static Date addMilliseconds(Date d, int milliseconds) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MILLISECOND, milliseconds);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的年份是新的给定的年份
     *
     * @param d    需要设定的日期对象
     * @param year 新的年份
     * @return 新日期对象
     */
    public static Date setYearOfDate(Date d, int year) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的月份是新的给定的月份
     *
     * @param d     需要设定的日期对象
     * @param month 新的月份
     * @return 新日期对象
     */
    public static Date setMonthOfDate(Date d, int month) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的天是新的给定的天
     *
     * @param d   需要设定的日期对象
     * @param day 新的天
     * @return 新日期对象
     */
    public static Date setDayOfDate(Date d, int day) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的小时是新的给定的小时
     *
     * @param d    需要设定的日期对象
     * @param hour 新的小时数
     * @return 新日期对象
     */
    public static Date setHourOfDate(Date d, int hour) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的分钟是新的给定的分钟数
     *
     * @param d      需要设定的日期对象
     * @param minute 新的分钟数
     * @return 新日期对象
     */
    public static Date setMinuteOfDate(Date d, int minute) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的秒数是新的给定的分钟数
     *
     * @param d      需要设定的日期对象
     * @param second 新的秒数
     * @return 新日期对象
     */
    public static Date setSecondOfDate(Date d, int second) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 设置一个日期对象的毫秒数是新的给定的分钟数
     *
     * @param d           需要设定的日期对象
     * @param millisecond 新的毫秒数
     * @return 新日期对象
     */
    public static Date setMillisecondOfDate(Date d, int millisecond) {
        if (d == null) {
            throw new IllegalArgumentException("参数d不能是null对象！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月份的天数量
     *
     * @param d 日期对象
     * @return 天数
     */
    public static int getDaysOfMonth(Date d) {
        int year = getYearOfDate(d);
        int month = getMonthOfYear(d);
        return getDaysOfMonth(year, month);
    }

    /**
     * 返回指定日期的月份的天数量
     *
     * @param year  年
     * @param month 月
     * @return 天数
     */
    public static int getDaysOfMonth(int year, int month) {
        int days = 0;
        if (month == 2) {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                days = 29;
            } else {
                days = 28;
            }
        }
        if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
            days = 30;
        }
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)
                || (month == 12)) {
            days = 31;
        }
        return days;
    }

    /**
     * 返回系统时间，以日期对象形式返回
     *
     * @return 系统时间
     */
    public static Date getSystemDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 返回系统时间，以毫秒形式返回
     *
     * @return 毫秒数
     */
    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    /**
     * 返回24小时前的时间
     *
     * @param date 指定日期
     * @return 新日期对象
     */
    public static Date getLastDay(Date date) {
        long day = date.getTime();
        long lastDay = day - 24 * 60 * 60 * 1000;
        return new Date(lastDay);
    }

    /**
     * 返回24小时后的时间
     *
     * @param date 指定日期
     * @return 新日期对象
     */
    public static Date getTomorrow(Date date) {
        long day = date.getTime();
        long tomorrow = day + 24 * 60 * 60 * 1000;
        return new Date(tomorrow);
    }

    /**
     * 取得30天前的这个时间
     *
     * @return 新日期对象
     */
    public static Date getDayLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getTime();
    }

    /**
     * 取得30天后的这个时间
     *
     * @return 新日期n对象
     */
    public static Date getDayNextMonth() {
        long day = new Date().getTime();
        long dayNextMonth = day + 20 * 24 * 60 * 60 * 1000;
        return new Date(dayNextMonth);
    }

    /**
     * 取得n天前的这个时间
     *
     * @return 新日期对象
     */
    public static Date getTimeMinusDayCount(Date date, int dayCount) {
        long day = date == null ? new Date().getTime() : date.getTime();
        long dayLastMonth = day - 24 * 60 * 60 * 1000 * dayCount;
        return new Date(dayLastMonth);
    }

    /**
     * 取得这个月的最后一天的23点59分59s
     *
     * @return 新日期对象
     */
    public static Date getLastDayOfThisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, month + 1);
        Date time = calendar.getTime();
        Date lastDate = DateTimeUtil.getLastDate(time);
        return DateTimeUtil.getTimeMinusDayCount(lastDate, 1);
    }

    /**
     * 计算两个时间见得月份差，可为负数
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return 月份差
     */
    public static int getMonthCount(Date sDate, Date eDate) {
        String sDateStr = DateTimeUtil.formatDateTimetoString(sDate, "MM");
        String eDateStr = DateTimeUtil.formatDateTimetoString(eDate, "MM");
        int monthCount = Integer.parseInt(eDateStr) - Integer.parseInt(sDateStr) + 1;
        return monthCount;
    }

    /**
     * 计算两个时间见得年份差，可为负数
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return 年份差
     */
    public static int getYearCount(Date sDate, Date eDate) {
        String sDateStr = DateTimeUtil.formatDateTimetoString(sDate, "yyyy");
        String eDateStr = DateTimeUtil.formatDateTimetoString(eDate, "yyyy");
        return Integer.parseInt(eDateStr) - Integer.parseInt(sDateStr);
    }

    /**
     * 取得下个月的这天，比如2月1日可取得3月1日，此方法有很大局限性，不能用于月末的天数
     *
     * @param date 指定日期
     * @return 新日期对象
     */
    public static Date getDayNextMonth(Date date) {
        String yearStr = DateTimeUtil.formatDateTimetoString(date, "yyyy");
        String monthStr = DateTimeUtil.formatDateTimetoString(date, "MM");
        String dayStr = DateTimeUtil.formatDateTimetoString(date, "dd");
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        if (month == 12) {
            month = 1;
            year = year + 1;
            yearStr = String.valueOf(year);
            monthStr = String.valueOf(month);
        }

        String dateStr = yearStr + "-" + monthStr + "-" + dayStr;
        try {
            date = DateTimeUtil.parseToDate(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 获取当月开始时0点0分0秒
     *
     * @return 日期对象
     */
    public static Date getCurrentMouthStart() {
        Date d = getSystemDate();
        d = setDayOfDate(d, 1);
        d = setHourOfDate(d, 0);
        d = setMinuteOfDate(d, 0);
        d = setSecondOfDate(d, 0);
        return d;
    }

    /**
     * 返回下月的这天
     *
     * @param date 指定日期
     * @return 日期对象
     */
    public static Date getDateNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, +1);
        return cal.getTime();
    }

    /**
     * 默认方法，计算指定时间与当前时间之间的相差的天数
     *
     * @param date 指定日期
     * @return 所差天数
     */
    public static Integer daysDifference(Date date) {
        long l1 = get24HourMill(date);
        long l2 = get24HourMill(new Date());
        return (int) ((l2 - l1) / 86400 / 1000);
    }

    /**
     * 获取指定日期的 0点0分0秒
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    private static long get24HourMill(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定日期的 0点0分0秒
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    public static Date getZeroDate(Date d) {
        if (d == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的 23点59分59秒
     *
     * @param
     * @return 指定日期的0点0分0秒
     */
    public static Date getLastDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 不确定表示方式的时间差函数
     *
     * @param startDate 指定时间
     * @param endDate   结束时间
     * @return 时间差指定格式字符串
     */
    private static String otherDiff(Date startDate, Date endDate) {
        String[] type = new String[]{"年", "个月", "星期", "天", "小时", "分钟", "秒", "秒"};
        Object[] obj = timeDifference(startDate, endDate);
        String value = "1秒前";
        for (int i = 0; i < obj.length; i++) {
            if (!"0".equals(obj[i].toString())) {
                value = obj[i].toString() + type[i] + "前";
                break;
            }
        }
        return value;
    }

    /**
     * 动态表示方式的时间差函数
     *
     * @param startDate 指定时间
     * @param endDate   结束时间
     * @return 时间差指定格式字符串
     */
    public static String dynDiff(Date startDate, Date endDate) {

        String startDay = DateFormatUtils.format(startDate, "dd");
        String endtDay = DateFormatUtils.format(endDate, "dd");
        String value = "";
        if (startDay.equals(endtDay)) {
            value = DateFormatUtils.format(startDate, " HH:mm");
        } else {
            value = otherDiff(startDate, endDate);
        }
        return value;
    }

    /**
     * 资源表示方式的时间差函数
     *
     * @param startDate 指定时间
     * @param endDate   结束时间
     * @return 时间差指定格式字符串
     */
    public static String resDiff(Date startDate, Date endDate) {
        Object[] obj = timeDifference(startDate, endDate);
        String value = "";
        if (Long.parseLong(obj[3].toString()) > 7) {
            value = DateFormatUtils.format(startDate, "yyyy-MM-dd HH:mm");
        } else {
            value = otherDiff(startDate, endDate);
        }
        return value;
    }

    /**
     * 时间差
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 返回时间差数组：(年，月，周，天，时，分，秒，毫秒)
     */
    private static Object[] timeDifference(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return new Object[]{0, 0, 0, 0, 0, 0, 0};
        } else {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(startTime);
            end.setTime(endTime);

            long startMs = start.getTimeInMillis();
            long endMs = end.getTimeInMillis();
            long l_differ = endMs - startMs;// 毫秒数
            long ll_differ = l_differ / 1000;// 秒

            long second_differ = l_differ / 1000;// 秒

            long year_differ = second_differ / (60 * 60 * 24 * 365);// 得到年数
            long month_differ = second_differ / (60 * 60 * 24 * 30);// 得到月数
            long week_differ = second_differ / (60 * 60 * 24 * 7);// 得到周数

            long day_differ = second_differ / (60 * 60 * 24);// 得到天数
            second_differ = second_differ - day_differ * 60 * 60 * 24;// 天
            long hour_differ = second_differ / (60 * 60);// 时
            second_differ = second_differ - hour_differ * 60 * 60;
            long minute_differ = second_differ / 60;// 分
            second_differ = second_differ - minute_differ * 60;

            return new Object[]{year_differ, month_differ, week_differ, day_differ, hour_differ, minute_differ,
                    second_differ, ll_differ};
        }
    }

    /**
     * 流逝时间
     *
     * @return 时间
     * @throws Exception
     */
    public static String getPastDate(Date date) throws Exception {
        String timeStr;
        Date currDate = getSystemDate();
        // 今天以前
        if (date.before(getZeroDate(currDate))) {
            timeStr = DateTimeUtil.formatDatetoString(date);
        } else {
            // 时
            double hours = DateTimeUtil.getHoursOfTwoDate(currDate, date);
            if (hours < 24 && hours >= 1) {
                timeStr = String.valueOf((int) hours) + "小时前";
            } else {
                // 分
                double minutes = DateTimeUtil.getMinutesOfTwoDate(currDate, date);
                if (minutes < 60 && minutes >= 1) {
                    timeStr = String.valueOf((int) minutes) + "分钟前";
                } else {
                    // 秒
                    double seconds = DateTimeUtil.getSecondsOfTwoDate(currDate, date);
                    if (seconds < 60 && seconds >= 1) {
                        // timeStr = String.valueOf(seconds)+"秒前";
                        timeStr = "刚刚";
                    } else {
                        timeStr = "-";
                    }
                }
            }
        }
        return timeStr;
    }

    // 时间戳转为时间
    public static String getDateToString(Object value, String pattern) {
        Date d = new Date(Long.parseLong(String.valueOf(value)));
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd hh:mm:ss";
        }
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(d);
    }

    // 时间转为时间戳
    public static long getStringToDate(Object value) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sf.parse(String.valueOf(value));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static Date getDayBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//0点
        cal.set(Calendar.MINUTE, 0);//0分
        cal.set(Calendar.SECOND, 0);//0秒
        cal.set(Calendar.MILLISECOND, 0);//0毫秒
        return cal.getTime();
    }


    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static Date getDayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);//23点
        cal.set(Calendar.MINUTE, 59);//59分
        cal.set(Calendar.SECOND, 59);//59秒
        return cal.getTime();
    }


    /**
     * 获取昨天开始时间
     *
     * @return
     */
    public static Date getBeginDayOfYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取昨天结束时间
     *
     * @return
     */
    public static Date getEndDayOfYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取明天开始时间
     *
     * @return
     */
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取明天结束时间
     *
     * @return
     */
    public static Date getEndDayOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取某个日期的开始时间
     *
     * @param d
     * @return
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取某个日期的结束时间
     *
     * @param d
     * @return
     */
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取本周的开始时间
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayOfWeek);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本周的结束时间
     *
     * @return
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取上周开始时间
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - 7);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取上周的结束时间
     *
     * @return
     */
    public static Date getEndDayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取今年是哪一年
     *
     * @return
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }


    /**
     * 获取本月是哪一月
     *
     * @return
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /**
     * 获取本月是哪一月
     *
     * @return
     */
    public static int getLastMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return (gc.get(2) <= 0) ? (gc.get(2) + 12) : (gc.get(2));
    }


    /**
     * 获取本月的开始时间
     *
     * @return
     */
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取本月的结束时间
     *
     * @return
     */
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取上月的开始时间
     *
     * @return
     */
    public static Date getBeginDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 2, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取上月的结束时间
     *
     * @return
     */
    public static Date getEndDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 2, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 2, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取本年的开始时间
     *
     * @return
     */
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本年的结束时间
     *
     * @return
     */
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }


    /**
     * 两个日期相减得到的天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDiffDays(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }
        long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
        int days = new Long(diff).intValue();
        return days;
    }

    /**
     * 两个日期相减得到的天数,<1day算一天, >0d2在d1之后
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }


    /**
     * 两个日期相减得到的毫秒数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }


    /**
     * 两个日期相减得到的秒数 绝对值
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDiff(Date beginDate, Date endDate, boolean isAbs) {
        long date1ms = beginDate.getTime() / 1000L;
        long date2ms = endDate.getTime() / 1000L;
        if (isAbs) {
            return Math.abs(date2ms - date1ms);
        } else {
            return date2ms - date1ms;
        }
    }

    /*
     * 将时间戳转换为时间(yyyy-MM-dd HH:mm:ss)
     */
    public static String stampToDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }

    /**
     * 获取两个日期中的最大日起
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {//beginDate日期大于endDate
            return beginDate;
        }
        return endDate;
    }


    /**
     * 获取两个日期中的最小日期
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }

    /**
     * 获取某月该季度的第一个月
     *
     * @param date
     * @return
     */
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }


    /**
     * 返回某个日期下几天的日期
     *
     * @param date
     * @param i
     * @return
     */
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }


    /**
     * 返回某个日期前几天的日期
     *
     * @param date
     * @param i
     * @return
     */
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }


    /**
     * 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     *
     * @param beginYear
     * @param beginMonth
     * @param k
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }


    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的集合）
     *
     * @param beginYear
     * @param beginMonth
     * @param endYear
     * @param endMonth
     * @param k
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));
            }
        } else {
            {
                for (int j = beginMonth; j < 12; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }
                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < 12; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }

    /**
     * @Description: 将Date转换为LocalDateTime
     * @Param: * @param date
     * @return: java.time.LocalDateTime
     * @Author: noahw
     * @date: 2020/4/22
     */
    public static LocalDateTime getLocalDateTimeByDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime
     * @return
     */
    public static Date getDateByLocalDateTime(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * 获得两个日期之间相差的月份
     *
     * @param d1 日期对象 d1较大
     * @param d2 日期对象
     * @return 两日期之间相差的天数
     */
    public static double getMonthsOfTwoDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        if (d2.getTime() > d1.getTime()) {
            throw new IllegalArgumentException("d2应该小于d1");
        }
        int year1 = DateTimeUtil.getYearOfDate(d1);
        int year2 = DateTimeUtil.getYearOfDate(d2);
        int month1 = DateTimeUtil.getMonthOfYear(d1);
        int month2 = DateTimeUtil.getMonthOfYear(d2);
        int i = (year1 > year2 ? (year1 - year2) * 12 + (month1 - month2) : (month1 - month2)) + 1;
        return i;
    }

    /**
     * 获得两个日期之间相差的月份
     *
     * @param d1 日期对象 d1较大
     * @param d2 日期对象
     * @return 两日期之间相差的天数
     */
    public static double getMonthsOfTwoDateByMonth(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("参数d1或d2不能是null对象！");
        }
        if (d2.getTime() > d1.getTime()) {
            throw new IllegalArgumentException("d2应该小于d1");
        }
        int year1 = DateTimeUtil.getYearOfDate(d1);
        int year2 = DateTimeUtil.getYearOfDate(d2);
        int month1 = DateTimeUtil.getMonthOfYear(d1);
        int month2 = DateTimeUtil.getMonthOfYear(d2);
        int i = (year1 > year2 ? (year1 - year2) * 12 + (month1 - month2) : (month1 - month2));
        return i;
    }

    /**
     * 获取指定年的第一天
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    public static Date getDateByFirstDayOfYear(Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定年的最后一天
     *
     * @param d 指定日期
     * @return 指定日期的0点0分0秒
     */
    public static Date getDateByLastDayOfYear(Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public static boolean isBefore(Date first, Date second) {
        if (second == null) {
            return false;
        }

        if (first.getTime() == second.getTime()) {
            return true;
        }

        Calendar firstC = Calendar.getInstance();
        firstC.setTime(first);


        Calendar secondC = Calendar.getInstance();
        secondC.setTime(second);

        if (firstC.before(secondC)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAfter(Date first, Date second) {
        if (second == null) {
            return false;
        }

        if (first.getTime() == second.getTime()) {
            return true;
        }

        Calendar firstC = Calendar.getInstance();
        firstC.setTime(first);


        Calendar secondC = Calendar.getInstance();
        secondC.setTime(second);

        if (firstC.after(secondC)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBeforeByDay(Date first, Date second,boolean equalFlag) {
        if (second == null) {
            return false;
        }
        if (first.getTime() == second.getTime()) {
            return true;
        }
        first = DateTimeUtil.getZeroDate(first);
        second = DateTimeUtil.getZeroDate(second);
        if (equalFlag && first.getTime() <= second.getTime()) {
            return true;
        } else if (first.getTime() < second.getTime()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isAfterByDay(Date first, Date second,boolean equalFlag) {
        if (second == null) {
            return false;
        }
        if (first.getTime() == second.getTime()) {
            return true;
        }
        first = DateTimeUtil.getZeroDate(first);
        second = DateTimeUtil.getZeroDate(second);
        if (equalFlag && first.getTime() >= second.getTime()) {
            return true;
        } else if (first.getTime() > second.getTime()) {
            return true;
        } else {
            return false;
        }
    }

}