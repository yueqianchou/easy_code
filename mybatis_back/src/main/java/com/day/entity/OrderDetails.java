package com.day.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (OrderDetails)实体类
 *
 * @author makejava
 * @since 2021-05-19 19:03:49
 */
@Data
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 735393866072751690L;
    /**
    * 订单详情ID
    */
    private Integer orderDetailsId;
    /**
    * 订单ID
    */
    private Integer orderId;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 单价
    */
    private Object unitPrice;
    /**
    * 件
    */
    private Integer piece;
    /**
    * 商品图片
    */
    private Object image;
    /**
    * 金额
    */
    private Object money;

}