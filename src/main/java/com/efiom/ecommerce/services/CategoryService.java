package com.efiom.ecommerce.services;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import java.util.List;


public interface CategoryService {

    BaseResponse createCategory(String categoryName, String categoryDescription, String categoryImage);
    Category readCategory(Long id);

    List<Category> listOfCategories();

    BaseResponse updateCategory(Long categoryId);
}
