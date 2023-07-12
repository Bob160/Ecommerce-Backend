package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.models.Product;
import com.efiom.ecommerce.pojos.requests.ProductDto;
import com.efiom.ecommerce.pojos.responses.ProductResponse;
import com.efiom.ecommerce.services.CategoryService;
import com.efiom.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/get-product-id")
    public ResponseEntity<ProductResponse> getProductById (@RequestParam ("id") long id) {
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<List<Product>> listProducts() {
    List<Product> products = productService.allProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
