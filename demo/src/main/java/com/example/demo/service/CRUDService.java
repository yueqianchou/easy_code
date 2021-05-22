package com.example.demo.service;

import com.example.demo.dao.CRUDDao;
import com.example.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CRUDService {

    @Autowired
    private CRUDDao crudDao;


    public List<Order> listPageOrderByResultMap(Order order) {
        return crudDao.listPageOrderByResultMap(order);
    }

    public List<Order> listPageOrderByResultMap2(Order order) {
        return crudDao.listPageOrderByResultMap2(order);
    }
}
