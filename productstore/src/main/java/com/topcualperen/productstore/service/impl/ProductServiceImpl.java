package com.topcualperen.productstore.service.impl;

import com.topcualperen.productstore.dtos.ProductDto;
import com.topcualperen.productstore.exception.ProductNotFoundException;
import com.topcualperen.productstore.model.Product;
import com.topcualperen.productstore.repository.ProductRepository;
import com.topcualperen.productstore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    public ProductDto createProduct(ProductDto product_name){
        Product product = modelMapper.map(product_name, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    public void deleteProduct(int product_id){
        Optional<Product> product = productRepository.findById(product_id);
        if (product.isPresent()){
            productRepository.deleteById(product_id);
        }else {
            throw new ProductNotFoundException("product cannot be deleted !");
        }
    }

}
