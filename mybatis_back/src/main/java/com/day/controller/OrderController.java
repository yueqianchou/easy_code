package com.day.controller;

import com.day.entity.Order;
import com.day.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-05-19 19:00:50
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public Order selectOne(@PathVariable Integer id) {
        return orderService.queryById(id);
    }

    @GetMapping("queryAllByLimit/{offset}/{limit}")
    public List<Order> queryAllByLimit(@PathVariable Integer offset, @PathVariable Integer limit) {
        return orderService.queryAllByLimit(offset,limit);
    }

}