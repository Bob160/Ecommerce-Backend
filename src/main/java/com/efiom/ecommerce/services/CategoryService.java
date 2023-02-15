package com.efiom.ecommerce.services;

import com.efiom.ecommerce.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    Category createCategory(String categoryName);
    Category readCategory(String categoryName);


}
