package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.OrderProductsRepository;
import com.qienys.JnuPrac.pojo.OrderProducts;
import com.qienys.JnuPrac.service.OrderProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductsServiceImpl implements OrderProductsService {
    @Autowired
    private OrderProductsRepository orderProductsRepository;

    @Override
    public List<OrderProducts> findByOrderId(Long orderId){
        List<OrderProducts> orderProducts = orderProductsRepository.findByOrderId(orderId);
        return orderProducts;
    }
}
