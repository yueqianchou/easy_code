package com.day.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: yd
 * @Date: 2021/5/22 17:33
 */
@Data
public class Regional {
    //主键
    private String pkid;
    //区域名称
    private String name;
    //区域面积
    private String area;
    //父级
    private String parent;
    private List<Regional> children;
    public Regional(String pkid, String name, String area, String parent) {
        this.pkid = pkid;
        this.name = name;
        this.area = area;
        this.parent = parent;
    }

    public Regional() {
    }

}
