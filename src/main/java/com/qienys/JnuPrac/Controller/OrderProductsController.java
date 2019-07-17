package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.OrderProducts;
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

    @RequestMapping(value = "/orderproducts", method = RequestMethod.GET, produces = "application/json;UTF=8")
    @ResponseBody
    public String getOrderProductsList(@RequestBody JSONObject jsonOrderProducts){
        out.println(jsonOrderProducts.toJSONString());
        JSONObject result = new JSONObject();
        OrderProducts orderProducts = JSON.parseObject(jsonOrderProducts.toJSONString(),OrderProducts.class);
        List<OrderProducts> orderProductsList = orderProductsServiceImpl.findByOrderId(orderProducts.getOrderId());
        result.put("method", "json");
        result.put("data",orderProductsList);

        return result.toJSONString();
    }
}
