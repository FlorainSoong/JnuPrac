package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Orders;

import java.util.List;


public interface OrdersService {
    Orders findByUid(Long uid);
    List<Orders> findAllByUid(Long uid);
}


