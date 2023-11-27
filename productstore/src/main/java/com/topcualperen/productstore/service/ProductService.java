package com.topcualperen.productstore.service;

import com.topcualperen.productstore.dtos.ProductDto;
import com.topcualperen.productstore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto product_name);
    void deleteProduct(int product_id);
}
