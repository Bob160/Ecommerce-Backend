package com.efiom.ecommerce.services.serviceImpl;

import com.efiom.ecommerce.enums.ResponseCodeEnum;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import com.efiom.ecommerce.pojos.responses.CreateCategoryResponse;
import com.efiom.ecommerce.repositories.CategoryRepository;
import com.efiom.ecommerce.services.CategoryService;
import com.efiom.ecommerce.util.ResponseCodeUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    //public final CategoryService categoryService;
    private final ResponseCodeUtil responseCodeUtil = new ResponseCodeUtil();
//!categoryRepository.findByCategoryName(categoryName).isPresent()
    @Override
    public CreateCategoryResponse createCategory(CategoryDto categoryDto) {
        CreateCategoryResponse categoryResponse = CreateCategoryResponse.builder()
                .categoryName(categoryDto.getCategoryName())
                .build();
        if (categoryRepository.findByCategoryName(categoryDto.getCategoryName()) == null) {
            Category category = new Category();
            BeanUtils.copyProperties(categoryDto, category);
            categoryRepository.save(category);
            return responseCodeUtil.updateResponseData(categoryResponse, ResponseCodeEnum.SUCCESS, "New ${category} created");
            //return categoryService.createCategory(categoryDto);
            //categoryRepository.save(categoryName);

        }
        //return new ApiResponse(false,"Duplicate Category");

        return responseCodeUtil.updateResponseData(categoryResponse, ResponseCodeEnum.ERROR, "Category already exists");
    }

    @Override
    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);

    }
}
