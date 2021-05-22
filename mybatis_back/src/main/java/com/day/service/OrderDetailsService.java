package com.day.service;

import com.day.entity.OrderDetails;
import java.util.List;

/**
 * (OrderDetails)表服务接口
 *
 * @author makejava
 * @since 2021-05-19 19:03:49
 */
public interface OrderDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailsId 主键
     * @return 实例对象
     */
    OrderDetails queryById(Integer orderDetailsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderDetails 实例对象
     * @return 实例对象
     */
    OrderDetails insert(OrderDetails orderDetails);

    /**
     * 修改数据
     *
     * @param orderDetails 实例对象
     * @return 实例对象
     */
    OrderDetails update(OrderDetails orderDetails);

    /**
     * 通过主键删除数据
     *
     * @param orderDetailsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderDetailsId);

}