package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.ProductDto;
import com.efiom.ecommerce.pojos.responses.ProductResponse;
import com.efiom.ecommerce.services.CategoryService;
import com.efiom.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductResponse> createNewProduct(@RequestBody ProductDto productDto) {
    ProductResponse productResponse = productService.addProduct(productDto);
    return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
}
