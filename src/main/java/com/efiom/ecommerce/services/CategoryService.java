package com.efiom.ecommerce.services;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import java.util.List;


public interface CategoryService {

    BaseResponse createCategory(CategoryDto categoryDto);
    Category readCategory(CategoryDto categoryDto);

    List<Category> listOfCategories();

    BaseResponse updateCategory(Long categoryId);
}
