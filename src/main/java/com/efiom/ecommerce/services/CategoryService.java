package com.efiom.ecommerce.services;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CategoryService {

    BaseResponse createCategory(CategoryDto categoryDto);
    Category readCategory(CategoryDto categoryDto);


}
