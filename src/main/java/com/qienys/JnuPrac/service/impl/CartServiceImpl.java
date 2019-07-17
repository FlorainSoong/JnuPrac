package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.CartRepository;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findByUid(Long uid){
        List<Cart> carts = cartRepository.findByUid(uid);
        return carts;
    }
}
