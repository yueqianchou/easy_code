package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  dao
 *
 * @author duanww
 */
@Mapper
@Repository
public interface OrderDao {


    void updateOrder(@Param("order_id") String order_id);

    Order getOrderById(@Param("order_id")String order_id);

    List<OrderDetail> getOrderDetailByOrderId(@Param("order_id") String order_id);

    int addOrder(Order order);

    int selectMaxId();

    int getOrderCount(Order order);

    List<Order> listPageOrder(Order order);

    void addOrderDetailList(@Param("orderDetails") List<OrderDetail> orderDetails);

}
