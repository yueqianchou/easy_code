package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CRUDDao {


    public List<Order> listPageOrderByResultMap(Order order);
    public List<Order> listPageOrderByResultMap2(Order order);
}
