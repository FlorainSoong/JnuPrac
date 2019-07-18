package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Orders;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.impl.OrdersServiceImpl;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.lang.System.out;

public class OrderController {

    @Autowired
    private OrdersServiceImpl ordersServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/orderslist", method = RequestMethod.GET, produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String getOrdersList(@RequestBody JSONObject jsonOrders){
        User loginUser = userServiceImpl.findByUserName("user");
        JSONArray jsonArray = new JSONArray();
        out.println(jsonOrders.toJSONString());
        JSONObject jsonObject = new JSONObject();
        List<Orders> ordersList = ordersServiceImpl.findAllByUid(loginUser.getId());
        jsonObject.put("method", "json");
        jsonArray.add(jsonObject);
        jsonArray.add(ordersList);

        return jsonObject.toJSONString();
    }
}
