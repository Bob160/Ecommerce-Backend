package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public ResponseEntity<BaseResponse> readCategory(String categoryName) {
        return null;
    }

}
