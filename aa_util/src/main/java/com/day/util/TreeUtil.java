package com.day.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 树形工具类
 * @author: MoWenGe
 * @time: 2020/5/27 21:22
 */
public class TreeUtil {
    /**
     * 把列表转换为树结构
     *
     * @param originalList      原始list数据
     * @param idFieldName       作为唯一标示的字段名称
     * @param pidFieldName      父节点标识字段名
     * @param childrenFieldName 子节点（列表）标识字段名
     * @return 树结构列表
     */
    public static <T> List<T> listToTreeList(List<T> originalList, String idFieldName, String pidFieldName,
                                             String childrenFieldName) {
        // 获取根节点，即找出父节点为空的对象
        List<T> rootNodeList = new ArrayList<>();
        for (T t : originalList) {
            String parentId = null;
            try {
                parentId = BeanUtils.getProperty(t, pidFieldName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (StringUtil.isEmpty(parentId) || parentId.equals("0")) {
                rootNodeList.add(t);
            }
        }

        // 将根节点从原始list移除，减少下次处理数据
        originalList.removeAll(rootNodeList);

        // 递归封装树
        try {
            packTree(rootNodeList, originalList, idFieldName, pidFieldName, childrenFieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootNodeList;
    }

    /**
     * 封装树（向下递归）
     *
     * @param parentNodeList    要封装为树的父节点对象集合
     * @param originalList      原始list数据
     * @param keyName           作为唯一标示的字段名称
     * @param pidFieldName      父节点标识字段名
     * @param childrenFieldName 子节点（列表）标识字段名
     */
    private static <T> void packTree(List<T> parentNodeList, List<T> originalList, String keyName,
                                     String pidFieldName, String childrenFieldName) throws Exception {
        for (T parentNode : parentNodeList) {
            // 找到当前父节点的子节点列表
            List<T> children = packChildren(parentNode, originalList, keyName, pidFieldName, childrenFieldName);
            if (children.isEmpty()) {
                continue;
            }

            // 将当前父节点的子节点从原始list移除，减少下次处理数据
            originalList.removeAll(children);

            // 开始下次递归
            packTree(children, originalList, keyName, pidFieldName, childrenFieldName);
        }
    }

    /**
     * 封装子对象
     *
     * @param parentNode        父节点对象
     * @param originalList      原始list数据
     * @param keyName           作为唯一标示的字段名称
     * @param pidFieldName      父节点标识字段名
     * @param childrenFieldName 子节点（列表）标识字段名
     */
    private static <T> List<T> packChildren(T parentNode, List<T> originalList, String keyName, String pidFieldName,
                                            String childrenFieldName) throws Exception {
        // 找到当前父节点下的子节点列表
        List<T> childNodeList = new ArrayList<>();
        String parentId = BeanUtils.getProperty(parentNode, keyName);
        for (T t : originalList) {
            String childNodeParentId = BeanUtils.getProperty(t, pidFieldName);
            if (parentId.equals(childNodeParentId)) {
                childNodeList.add(t);
            }
        }

        // 将当前父节点下的子节点列表写入到当前父节点下（给子节点列表字段赋值）
        if (!childNodeList.isEmpty()) {
            FieldUtils.writeDeclaredField(parentNode, childrenFieldName, childNodeList, true);
        }

        return childNodeList;
    }


    /**
     * @param cList        存放子节点
     * @param aList        需要递归的数据
     * @param id           父节点ID
     * @param idFieldName  主键的名字
     * @param pidFieldName 父级的名字
     * @return List<JSONObject>
     * @Description 递归父节点，获取所有子节点包括跨级节点
     */
    public static List<JSONObject> getAllChildren(List<JSONObject> cList, List<JSONObject> aList, String id,
                                                  String idFieldName, String pidFieldName) {
        for (int i = 0; i < aList.size(); i++) {
            JSONObject aMap = aList.get(i);
            if (aMap.getString(pidFieldName).equals(id)) {
                cList.add(aMap);
                //这个ID 不是父节点ID，而是数据的ID
                getAllChildren(cList, aList, aList.get(i).getString(idFieldName), idFieldName, pidFieldName);
            }
        }
        return cList;
    }
}
