package com.day.util;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * @ClassName: CommonUtils
 * @Description: 常用工具类
 * @Vsersion: 0.0.1
 */
public class CommonUtils {

    /**
     * 获取uuid 去除 -
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    /**
     * 判断数字返回相应的字符串
     */
    public static String getNumStr(int num) {
        String str = "";
        if (num < 10) {
            str = new StringBuilder("0").append(num).toString();
        } else {
            str = String.valueOf(num);
        }
        return str;
    }

    /**
     * 序号
     * @param seq
     * @return
     */
    public static String sequenceFormat(Integer seq){
        return new DecimalFormat("00000000").format(seq);
    }

    /**
     * 把字节数B转化为KB、MB、GB
     * @param size
     * @return
     */
    public static String getFileSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return size + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return size + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return (size / 100) + "."
                    + (size % 100) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return (size / 100) + "."
                    + (size % 100) + "GB";
        }
    }
    // 采用Stringbuilder.append()的方式追加
    public static String listToString(List<String> mList) {
        final String SEPARATOR = ",";
        // mList = Arrays.asList("AAA", "BBB", "CCC");
        StringBuilder sb = new StringBuilder();
        String convertedListStr = "";
        if (null != mList && mList.size() > 0) {
            for (String item : mList) {
                sb.append(item);
                sb.append(SEPARATOR);
            }
            convertedListStr = sb.toString();
            convertedListStr = convertedListStr.substring(0, convertedListStr.length()
                    - SEPARATOR.length());
            return convertedListStr;
        } else {
            return "List is null!!!";
        }
    }

    public static boolean isEmpty(Object aObj) {
        if (aObj instanceof String) {
            return isEmpty((String) aObj);
        } else if (aObj instanceof Long) {
            return isEmpty((Long) aObj);
        } else if (aObj instanceof Date) {
            return isEmpty((Date) aObj);
        } else if (aObj instanceof Collection) {
            return isEmpty((Collection) aObj);
        } else if (aObj instanceof Map) {
            return isEmpty((Map) aObj);
        } else if (aObj != null && aObj.getClass().isArray()) {
            return isEmptyArray(aObj);
        } else {
            return isNull(aObj);
        }
    }

    public static boolean isEmpty(Date aDate) {
        if (aDate == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Long aLong) {
        if (aLong == null) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isEmpty(Map m) {
        if (m == null || m.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection c) {
        if (c == null || c.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String aStr) {
        if (aStr == null || aStr.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isEmptyArray(Object array) {
        int length = 0;
        if (array instanceof int[]) {
            length = ((int[]) array).length;
        } else if (array instanceof byte[]) {
            length = ((byte[]) array).length;
        } else if (array instanceof short[]) {
            length = ((short[]) array).length;
        } else if (array instanceof char[]) {
            length = ((char[]) array).length;
        } else if (array instanceof float[]) {
            length = ((float[]) array).length;
        } else if (array instanceof double[]) {
            length = ((double[]) array).length;
        } else if (array instanceof long[]) {
            length = ((long[]) array).length;
        } else if (array instanceof boolean[]) {
            length = ((boolean[]) array).length;
        } else {
            length = ((Object[]) array).length;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Object oStr) {
        if (oStr == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * length  长度
     * number  数目
     *
     * @return
     */
    public static String generateSerival(Integer length, Integer number) {

        int len = length.intValue();
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMinimumIntegerDigits(len);
        return nf.format(number).toString();
    }

    /**
     * InputStream转化为byte[]数组
     *
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    /**
     * byte[]数组转化为InputStream
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    public static InputStream toInputStream(byte[] bytes) throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    //数字转字母 1-26 ： A-Z
    public static String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);

        return letter;
    }


    /**
     * 返回多选字典名称，逗号分隔
     * @param keys
     * @return
     */
    public static String multiChoiceTransform(String keys, Map<String, String> positionMap) {
        if (StringUtils.isBlank(keys)) {
            return "";
        }
        List<String> keyList = Arrays.asList(keys.split(","));
        List<String> resList = new ArrayList<>();
        keyList.forEach(key -> resList.add(isEmpty(positionMap.get(key))?"":positionMap.get(key)));
        return String.join(",", resList);
    }
}
