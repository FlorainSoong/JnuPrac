package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.ProductRepository;
import com.qienys.JnuPrac.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

}