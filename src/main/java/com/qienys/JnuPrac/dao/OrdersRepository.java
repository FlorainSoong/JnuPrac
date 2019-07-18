package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

    Orders findByUid(Long uid);
    List<Orders> findAllByUid(Long uid);

}
