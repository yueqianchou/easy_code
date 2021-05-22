package com.day;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.day.pojo.Regional;
import com.day.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yd
 * @Date: 2021/5/22 17:32
 */
public class TreeTest {

    public static void main(String[] args) throws Exception {
        //将list转成树结构
        List<Regional> regionals = getRegional();
        List<Regional> rs = TreeUtil.listToTreeList(regionals, "pkid", "parent", "children");
        //查询树节点下的所有子节点 包括跨级节点
        List<Regional> regionals2 = getRegional();
        List<JSONObject> b2 = new ArrayList<>();
        List<JSONObject> aList = JSON.parseArray(JSON.toJSONString(regionals2), JSONObject.class);
        TreeUtil.getAllChildren(b2, aList, "3", "pkid", "parent");
        System.out.println(b2);
    }

    public static List<Regional> getRegional() {
        List<Regional> regionals = new ArrayList<>();
        Regional r1 = new Regional("1", "雅居乐", "300", "0");
        Regional r2 = new Regional("2", "一栋", "100", "1");
        Regional r3 = new Regional("3", "一单元", "20", "2");
        Regional r4 = new Regional("4", "101", "10", "3");
        Regional r5 = new Regional("5", "102", "10", "3");
        regionals.add(r1);
        regionals.add(r2);
        regionals.add(r3);
        regionals.add(r4);
        regionals.add(r5);
        Regional r6 = new Regional("6", "雅居乐2", "300", "0");
        Regional r7 = new Regional("7", "二栋", "100", "6");
        Regional r8 = new Regional("8", "二单元", "20", "7");
        Regional r9 = new Regional("9", "201", "10", "8");
        Regional r10 = new Regional("10", "202", "10", "8");
        regionals.add(r6);
        regionals.add(r7);
        regionals.add(r8);
        regionals.add(r9);
        regionals.add(r10);
        return regionals;
    }

}


//   mysql查询节点下的所有子节点
//        SELECT
//        t1.*,
//        IF
//        ( find_in_set( parent, @pids )> 0, @pids := concat( @pids, ',', pkid ), 0 ) AS ischild
//        FROM
//        ( SELECT * FROM regional_configuration_info t ) t1,
//        ( SELECT @pids := '2' ) t2
//
//
//        SELECT
//        t3.pkid,
//        t3.NAME,
//        t3.area,
//        t3.parent,
//        t3.area_type,
//        t3.node_type,
//        t3.LEVEL,
//        t3.order_no,
//        t3.max_level,
//        t3.area_num,
//        t3.unit_limit
//        FROM
//        (
//        SELECT
//        t1.*,
//        IF
//        ( find_in_set( parent, @pids )> 0, @pids := concat( @pids, ',', pkid ), 0 ) AS ischild
//        FROM
//        ( SELECT * FROM regional_configuration_info t ) t1,
//        ( SELECT @pids := 1 ) t2
//        ) t3
//        WHERE
//        ischild !=0