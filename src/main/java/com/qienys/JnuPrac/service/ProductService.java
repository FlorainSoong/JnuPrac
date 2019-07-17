package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Product;
import java.util.List;

public interface ProductService {
    Product findByName(String name);
    List<Product> findAll ();

}
