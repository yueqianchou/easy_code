package com.day.util;

import java.util.UUID;

/**
 * @description:
 * @author: MoWenGe
 * @time: 2020/9/5 10:38
 */
public class UUIdUtil {

    public static String getUUId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-", "");
        return id;
    }
}
