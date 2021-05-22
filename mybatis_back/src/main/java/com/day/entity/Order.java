package com.day.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-05-19 19:00:42
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 513354170626638953L;
    /**
    * 订单ID
    */
    private Integer orderId;
    /**
    * 订单名称
    */
    private String orderName;
    /**
    * 付款方式（0：货到付款，1：线上付款 ）'
    */
    private String payMode;
    /**
    * 下单时间
    */
    private Date orderTime;
    /**
    * 订单状态（0：已下单，1：已发货，2：已签收，3：已完成）
    */
    private String orderStatus;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 是否删除（0：未删除，1：已删除）
    */
    private String delFlag;

    private List<OrderDetails> orderDetails;
}