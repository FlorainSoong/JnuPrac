package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.service.impl.CartServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.System.out;

//返回购物车内所有商品
public class CartController {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @RequestMapping(value = "/cartlist", method = RequestMethod.GET, produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String getCartList(@RequestBody JSONObject jsonCart){
        //接收JSON信号
        out.println(jsonCart.toJSONString());
        JSONObject result = new JSONObject();
        Cart cart = JSON.parseObject(jsonCart.toJSONString(),Cart.class);
        //使用List获取所有商品
        List<Cart> carts = cartServiceImpl.findByUid(cart.getUid());
        result.put("method", "json");
        //返回所有商品
        result.put("data",carts);

        return result.toJSONString();
    }


}