package com.day.service.impl;

import com.day.pojo.OrderDetails;
import com.day.mapper.OrderDetailsMapper;
import com.day.service.IOrderDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author easy_code
 * @since 2021-05-19
 */
@Service
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements IOrderDetailsService {

}
