package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

        Product findByName (String name);
        List<Product> findAll ();
}
