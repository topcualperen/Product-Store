package com.topcualperen.productstore.controller;


import com.topcualperen.productstore.dtos.ProductDto;
import com.topcualperen.productstore.model.Product;
import com.topcualperen.productstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@CrossOrigin

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product_name){
        ProductDto resultProduct = productService.createProduct(product_name);
        return ResponseEntity.ok(resultProduct);
    }

    @DeleteMapping("/delete/{product_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("product_id") int product_id){
        productService.deleteProduct(product_id);
    }

}
