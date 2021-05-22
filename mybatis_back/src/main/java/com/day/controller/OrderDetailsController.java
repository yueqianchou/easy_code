package com.day.controller;

import com.day.entity.OrderDetails;
import com.day.service.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderDetails)表控制层
 *
 * @author makejava
 * @since 2021-05-19 19:03:49
 */
@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderDetailsService orderDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public OrderDetails selectOne(@PathVariable Integer id) {
        return this.orderDetailsService.queryById(id);
    }



}