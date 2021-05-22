package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Order controller
 *
 * @author duanww
 */
@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 分页查询订单信息
     *
     * @return
     */
    @RequestMapping(value = "/getOrderlist", method = RequestMethod.POST)
    public Map getOrderlist(@RequestBody Order order) {
        return orderService.listPageOrder(order);
    }


    /**
     * 修改订单是否删除的状态
     *
     * @param order_id 订单id
     */
    @RequestMapping(value = "/updateOrder/{order_id}", method = RequestMethod.GET)
    public void updateOrder(@PathVariable String order_id) {
        orderService.updateOrder(order_id);
    }

    /**
     * 根据订单id查询订单信息
     *
     * @param order_id
     */
    @RequestMapping(value = "/getOrderDetailById/{order_id}", method = RequestMethod.GET)
    public Map getOrderDetailById(@PathVariable String order_id) {
        return orderService.getOrderDetailById(order_id);
    }

    /**
     * 添加订单及订单商品
     *
     * @param order
     */
    @RequestMapping(value = "/addOrderAndOrderDetail", method = RequestMethod.POST)
    public void addOrderAndOrderDetail(@RequestBody Order order) {
        orderService.addOrderAndOrderDetail(order);
    }

    /**
     * 图片上传
     */
    @RequestMapping(value = "/uploadPictureOorderdetail")
    public String upload(@RequestParam("file") MultipartFile attach, HttpServletRequest request) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        if (!attach.isEmpty()) {
            try {
                InputStream in = attach.getInputStream();
                // 读取图片字节数组
                ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
                byte[] buff = new byte[100];
                int rc = 0;
                while ((rc = in.read(buff, 0, 100)) > 0) {
                    swapStream.write(buff, 0, rc);
                }
                data = swapStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "data:image/png;base64," + new String(Base64.encodeBase64(data));
    }

    /**
     * 获取项目根路径
     */
    @RequestMapping(value = "/getProjectRootUrl", method = RequestMethod.GET)
    public String deleteOrderDetail(HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort();
        return basePath;
    }
}