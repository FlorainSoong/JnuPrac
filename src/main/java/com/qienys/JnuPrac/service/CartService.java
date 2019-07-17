package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Cart;
import java.util.List;

public interface CartService {

    List<Cart> findByUid(Long uid);

}
