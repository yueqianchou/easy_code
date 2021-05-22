package com.day.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: solar
 * @description: 验签工具
 * @author: noahw
 * @create: 2020-07-21 13:32
 **/
public class LicenseUtil {

    public static final String LICENSE_REGULER = "license@hedian";

    public static final String LICENSE_PREFIX = "LICENSE_";

    /*
     * @description 签发license
     * @param [date] 到期时间
     * @return license
     * @author noahw
     * @date 2020/7/21
     */
    public static String sign(Date lastDate){
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            String origin = sf.format(lastDate);
            return LICENSE_PREFIX + AesUtil.AESEncode(LICENSE_REGULER, origin);
        }
        catch (Exception e){
            System.out.println("license签发失败");
            e.printStackTrace();
            return "";
        }
    }

    /*
     * @description 根据mac地址签发license
     * @param [date, mac] 到期时间
     * @return license
     * @author noahw
     * @date 2020/7/27
     */
    public static String sign(Date lastDate, String mac){
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            String origin = sf.format(lastDate);
            return LICENSE_PREFIX + AesUtil.AESEncode(mac, origin);
        }
        catch (Exception e){
            System.out.println("license签发失败");
            e.printStackTrace();
            return "";
        }
    }

    /*
     * @description 根据license判断是否过期
     * @param [license]
     * @return 0已过期 1未过期
     * @author noahw
     * @date 2020/7/21
     */
    public static int judgeExpire(String license){
        try{
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            license = license.replaceFirst(LICENSE_PREFIX, "");
            Date lastDate = sf.parse(AesUtil.AESDncode(LICENSE_REGULER, license));
            if(DateTimeUtil.compareTwoDate(new Date(), lastDate) > 0){
                return 1;
            }
            return 0;
        }
        catch (Exception e){
            //解析错误或其他异常,返回0
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * @description 根据license和mac地址判断是否过期
     * @param [license, mac]
     * @return 0已过期 1未过期
     * @author noahw
     * @date 2020/7/27
     */
    public static int judgeExpire(String license, String mac){
        try{
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            license = license.replaceFirst(LICENSE_PREFIX, "");
            Date lastDate = sf.parse(AesUtil.AESDncode(mac, license));
            if(DateTimeUtil.compareTwoDate(new Date(), lastDate) > 0){
                return 1;
            }
            return 0;
        }
        catch (Exception e){
            //解析错误或其他异常,返回0
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        //这里默认配置2021年的年底,可根据需要修改
        Date date = DateTimeUtil.getDateByLastDayOfYear(2021);
        System.out.println(sign(date));

        //校验是否过期
        System.out.println(judgeExpire("LICENSE_bU7IJBYSr78CcdzxQCs4tw=="));
    }
}
