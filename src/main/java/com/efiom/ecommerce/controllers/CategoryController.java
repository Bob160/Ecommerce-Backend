package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.repositories.CategoryRepository;
import com.efiom.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
//    @Autowired
//    private CategoryRepository categoryRepository;
}
