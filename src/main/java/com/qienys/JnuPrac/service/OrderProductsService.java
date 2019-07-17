package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.OrderProducts;

import java.util.List;

public interface OrderProductsService  {
    List<OrderProducts> findByOrderId(Long orderId);
}
