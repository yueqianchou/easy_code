package com.day.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author easy_code
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 前后台分离测试
     */
    @RequestMapping(value = "/getBackDatas", method = RequestMethod.GET)
    public Map getBackDatas() {
        Map result = new HashMap();
        result.put("msg","进来了");
        return result;
    }

}
