package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.enums.ResponseCodeEnum;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import com.efiom.ecommerce.pojos.responses.CreateCategoryResponse;
import com.efiom.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;

    private final Category category;


    @PostMapping("/create-category")
    public ResponseEntity<CreateCategoryResponse> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CreateCategoryResponse categoryResponse = (CreateCategoryResponse) categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<Category> readCategory (@RequestBody CategoryDto categoryDto) {
        Category categoryResponse = categoryService.readCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
