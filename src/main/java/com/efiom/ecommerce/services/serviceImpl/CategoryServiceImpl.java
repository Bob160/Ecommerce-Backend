package com.efiom.ecommerce.services.serviceImpl;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.enums.ResponseCodeEnum;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.pojos.requests.CategoryDto;
import com.efiom.ecommerce.pojos.responses.CreateCategoryResponse;
import com.efiom.ecommerce.repositories.CategoryRepository;
import com.efiom.ecommerce.services.CategoryService;
import com.efiom.ecommerce.util.ResponseCodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    //private CreateCategoryResponse categoryResponse;
    private final ResponseCodeUtil responseCodeUtil = new ResponseCodeUtil();

    @Override
    public CreateCategoryResponse createCategory(String categoryName, String categoryDescription, String categoryImage) {
            CreateCategoryResponse createCategoryResponse = CreateCategoryResponse.builder()
                    .categoryName(categoryName)
                    .build();
//        if (categoryRepository.findByCategoryName(categoryName) != null) {
           Optional <Category> category = categoryRepository.findByCategoryName(createCategoryResponse.getCategoryName());
            //category = categoryRepository.findByCategoryName(categoryName);
            if (category.isPresent()) {
            createCategoryResponse = CreateCategoryResponse.builder()
                    .description(categoryDescription)
                    .categoryName(categoryName)
                    .imageUrl(categoryImage)
                    .build();
            return responseCodeUtil.updateResponseData(createCategoryResponse, ResponseCodeEnum.ERROR, "Category already exists");
        } else {
            Category category1 = Category.builder()
                    .categoryName(categoryName)
                    .description(categoryDescription)
                    .imageUrl(categoryImage)
                    .build();
            categoryRepository.save(category1);
        CreateCategoryResponse categoryResponse = CreateCategoryResponse.builder()
                .description(categoryDescription)
                .categoryName(categoryName)
                .imageUrl(categoryImage)
                .build();
//        if (categoryRepository.findByCategoryName(categoryDto.getCategoryName()) == null) {
//            Category category = new Category();
//            BeanUtils.copyProperties(categoryDto, category);
            //categoryRepository.save(category);
//            BaseResponse baseResponse = new BaseResponse();
//            baseResponse.setCode(0);
//            baseResponse.setDescription("New category created successfully");
            return responseCodeUtil.updateResponseData(categoryResponse, ResponseCodeEnum.SUCCESS, "New category created successfully");
        }
        //return responseCodeUtil.updateResponseData(categoryResponse, ResponseCodeEnum.ERROR, "Category already exists");
    }

    @Override
    public Category readCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {

            return null;
        }

    }

    @Override
    public List<Category> listOfCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public BaseResponse updateCategory(Long categoryId) {
//        BaseResponse baseResponse = new BaseResponse();
//        Category category = categoryRepository.findById(categoryId).get();
//        CategoryDto categoryDto = new CategoryDto();
//        category.setCategoryName(categoryDto.getCategoryName());
//        category.setDescription(categoryDto.getDescription());
//        category.setImageUrl(categoryDto.getImageUrl());
//        categoryRepository.save(category);
//        categoryResponse.setCategoryName(category.getCategoryName());
//        categoryResponse.setDescription(category.getDescription());
//        categoryResponse.setImageUrl(category.getImageUrl());
//
//        return responseCodeUtil.updateResponseData(categoryResponse,ResponseCodeEnum.SUCCESS, "Category updated successfully");

        return null;
    }

}
