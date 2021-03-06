package com.day.dao;

import com.day.entity.OrderDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OrderDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-19 19:03:49
 */
public interface OrderDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailsId 主键
     * @return 实例对象
     */
    OrderDetails queryById(Integer orderDetailsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderDetails 实例对象
     * @return 对象列表
     */
    List<OrderDetails> queryAll(OrderDetails orderDetails);

    /**
     * 新增数据
     *
     * @param orderDetails 实例对象
     * @return 影响行数
     */
    int insert(OrderDetails orderDetails);

    /**
     * 修改数据
     *
     * @param orderDetails 实例对象
     * @return 影响行数
     */
    int update(OrderDetails orderDetails);

    /**
     * 通过主键删除数据
     *
     * @param orderDetailsId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderDetailsId);

}