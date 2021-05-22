package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CRUDController {

    @Autowired
    private CRUDService crudService;

    /**
     * 分页查询订单信息  collection 之select
     * @param order
     * @return
     */
    @RequestMapping(value ="listPageOrder", method = RequestMethod.POST)
    public List<Order> listPageOrderByResultMap(@RequestBody Order order){
        return  crudService.listPageOrderByResultMap(order);

    }

    /**
     * 分页查询订单信息  collection 之一般形式
     * @param order
     * @return
     */
    @RequestMapping(value ="listPageOrder2", method = RequestMethod.POST)
    public List<Order> listPageOrderByResultMap2(@RequestBody Order order){
        return  crudService.listPageOrderByResultMap2(order);

    }


}
