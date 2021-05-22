package com.day.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Description: 项目路径工具
 * @Version: 1.0
 */
@Slf4j
public class PathUtil {

    /**
     * 获取jar包所在绝对路径
     *
     * @return String
     */
    public static String getProjectPath() {
        ApplicationHome home = new ApplicationHome(PathUtil.class);
        File jarFile = home.getSource();
        return jarFile == null ? "" : jarFile.getParentFile().toString();
    }

    /**
     * 获取classes所在绝对路径
     *
     * @return String
     */
    public static String getClassesPath() {
        try {
            return ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            log.error("error",e);
            return "";
        }
    }
}
