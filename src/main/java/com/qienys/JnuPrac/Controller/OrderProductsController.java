package com.qienys.JnuPrac.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.OrderProducts;
import com.qienys.JnuPrac.pojo.Orders;
import com.qienys.JnuPrac.service.impl.OrderProductsServiceImpl;
import com.qienys.JnuPrac.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.lang.System.out;

public class OrderProductsController {
    @Autowired
    private OrderProductsServiceImpl orderProductsServiceImpl;
    //根据订单ID返回商品
    @Autowired
    private OrdersServiceImpl ordersServiceImpl;

    @RequestMapping(value = "/orderProductsList", method = RequestMethod.GET, produces = "application/json;UTF=8")
    @ResponseBody
    public String getOrderProductsList(@RequestBody JSONObject jsonOrderProducts){
        Orders order= JSON.parseObject(jsonOrderProducts.toJSONString(),Orders.class);
        Orders orders = ordersServiceImpl.findByUid(order.getUid());
        JSONArray jsonArray = new JSONArray();
        out.println(jsonOrderProducts.toJSONString());
        JSONObject jsonObject = new JSONObject();
        List<OrderProducts> orderProductsList = orderProductsServiceImpl.findByOrderId(orders.getUid());
        jsonObject.put("method", "json");
        jsonArray.add(jsonObject);
        jsonArray.add((orderProductsList));

        return jsonArray.toJSONString();
    }
}
