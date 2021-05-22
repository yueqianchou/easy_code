package com.day.service.impl;

import com.day.entity.OrderDetails;
import com.day.dao.OrderDetailsDao;
import com.day.service.OrderDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-05-19 19:03:49
 */
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Resource
    private OrderDetailsDao orderDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailsId 主键
     * @return 实例对象
     */
    @Override
    public OrderDetails queryById(Integer orderDetailsId) {
        return this.orderDetailsDao.queryById(orderDetailsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderDetails> queryAllByLimit(int offset, int limit) {
        return this.orderDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetails insert(OrderDetails orderDetails) {
        this.orderDetailsDao.insert(orderDetails);
        return orderDetails;
    }

    /**
     * 修改数据
     *
     * @param orderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetails update(OrderDetails orderDetails) {
        this.orderDetailsDao.update(orderDetails);
        return this.queryById(orderDetails.getOrderDetailsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderDetailsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderDetailsId) {
        return this.orderDetailsDao.deleteById(orderDetailsId) > 0;
    }
}