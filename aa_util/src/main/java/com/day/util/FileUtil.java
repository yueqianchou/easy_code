package com.day.util;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.InputStream;
import java.util.Arrays;

/**

* @Description:    文件工具类
* @Version:        1.0

*/
public class FileUtil {

    /**
     图片后缀
     */
    private static String[] IMG = {"bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
            "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf"};

    /**
     文档后缀
     */
    private static String[] DOCUMENT = {"txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt"};

    /**
     视频后缀
     */
    private static String[] VIDEO = { "mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm" };

    /**
     音乐后缀
     */
    private static String[] MUSIC = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg",
            "m4a", "vqf" };

    /**
     *
     * @Description:
     *
     * @Param suffix 后缀名
     * @Return: int 文件类型 0其他1图片2文档3视频4音乐
     * @Author: noahw
     * @Date: 2019-08-07 14:38
     * @Version 1.0
     */
    public static int getFileType(String suffix){
        suffix = suffix.toLowerCase();
        if(Arrays.asList(IMG).contains(suffix)){
            return 1;
        }
        else if(Arrays.asList(DOCUMENT).contains(suffix)){
            return 2;
        }
        else if(Arrays.asList(VIDEO).contains(suffix)){
            return 3;
        }
        else if(Arrays.asList(MUSIC).contains(suffix)){
            return 4;
        }
        return 0;
    }

    /**
     * 把字节数B转化为KB、MB、GB
     * @param size
     * @return
     */
    public static String getFileSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }

    /**
     * 获取指定文件的输入流
     *
     * @param logoPath 文件的路径
     * @return
     */
    public static InputStream getResourceAsStream(String logoPath) {
        return FileUtils.class.getResourceAsStream(logoPath);
    }
}
