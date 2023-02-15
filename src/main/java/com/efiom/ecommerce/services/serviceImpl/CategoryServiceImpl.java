package com.efiom.ecommerce.services.serviceImpl;

import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.repositories.CategoryRepository;
import com.efiom.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;
    public CategoryService categoryService;
//!categoryRepository.findByCategoryName(categoryName).isPresent()
    @Override
    public Category createCategory(String categoryName) {
        if (categoryRepository.findByCategoryName(categoryName) == null) {
            return categoryService.createCategory(categoryName);
            //categoryRepository.save(categoryName);
        }
        return new ApiResponse(false,"Duplicate Category");
    }

    @Override
    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);

    }
}
