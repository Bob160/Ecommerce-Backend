package com.efiom.ecommerce.controllers;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import com.efiom.ecommerce.pojos.responses.CreateCategoryResponse;
import com.efiom.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create-category")
    public ResponseEntity<CreateCategoryResponse> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CreateCategoryResponse categoryResponse = (CreateCategoryResponse) categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<Category> readCategory (@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.readCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/all-category")
    public ResponseEntity<List<Category>> getAllCategories () {
        List<Category> allCategory = categoryService.listOfCategories();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<BaseResponse> updateCategory (@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
        BaseResponse baseResponse = categoryService.updateCategory(categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
