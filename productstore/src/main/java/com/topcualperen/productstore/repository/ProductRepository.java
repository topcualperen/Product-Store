package com.topcualperen.productstore.repository;

import com.topcualperen.productstore.dtos.ProductDto;
import com.topcualperen.productstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
