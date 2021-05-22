package com.day.util;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @program: solar
 * @description: mac地址获取
 * @author: noahw
 * @create: 2020-07-27 13:35
 **/
public class MacUtil {

    /*
     * @description 获取本机器mac地址
     * @param []
     * @return String mac地址
     * @author noahw
     * @date 2020/7/27
     */
    public static String getLocalMac() {

        StringBuilder sb = new StringBuilder();

        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface != null) {

                    String name = networkInterface.getName();

                    if(!name.equals("en0")){
                        continue;
                    }

                    byte[] bytes = networkInterface.getHardwareAddress();
                    if (bytes != null) {
                        for (int i = 0; i < bytes.length; i++) {
                            if (i != 0) {
                                sb.append(":");
                            }
                            int tmp = bytes[i] & 0xff; // 字节转换为整数
                            String str = Integer.toHexString(tmp);
                            if (str.length() == 1) {
                                sb.append("0").append(str);
                            } else {
                                sb.append(str);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().toLowerCase();

    }

    public static void main(String[] args) {
        //测试获取本机mac地址
        getLocalMac();
    }
}
