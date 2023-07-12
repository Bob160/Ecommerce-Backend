package com.efiom.ecommerce.services.serviceImpl;

import com.efiom.ecommerce.enums.ResponseCodeEnum;
import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.models.Product;
import com.efiom.ecommerce.pojos.requests.ProductDto;
import com.efiom.ecommerce.pojos.requests.UpdateProductDto;
import com.efiom.ecommerce.pojos.responses.ProductResponse;
import com.efiom.ecommerce.pojos.responses.UpdatedProductResponse;
import com.efiom.ecommerce.repositories.CategoryRepository;
import com.efiom.ecommerce.repositories.ProductRepository;
import com.efiom.ecommerce.services.ProductService;
import com.efiom.ecommerce.util.ResponseCodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ResponseCodeUtil responseCodeUtil;

    @Override
    public ProductResponse addProduct(ProductDto productDto) {

        ProductResponse productResponse = ProductResponse.builder()
                .name(productDto.getName())
                .build();
        Optional<Category> category1 = categoryRepository.findByCategoryName(productDto.getCategoryName());
                if (category1.isEmpty()) {
                    return responseCodeUtil.updateResponseData(productResponse, ResponseCodeEnum.ERROR, productDto.getCategoryName() + " does not exist");
                }
        Optional<Product>newProduct = productRepository.findByName(productDto.getName());
                if (newProduct.isPresent()) {
                    return responseCodeUtil.updateResponseData(productResponse, ResponseCodeEnum.ERROR,newProduct.get().getName() + " already exist!");
                }
                Product product = Product.builder()
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                        .category(category1.get())
                        .quantity(productDto.getQuantity())
                        .imageUrl(productDto.getImageUrl())
                        .description(productDto.getDescription())
                        .build();
                productRepository.save(product);
                productResponse = ProductResponse.builder()
                        .name(productDto.getName())
                        .category(category1.get())
                        .description(productDto.getDescription())
                        .imageUrl(productDto.getImageUrl())
                        .build();
                return responseCodeUtil.updateResponseData(productResponse, ResponseCodeEnum.SUCCESS, productDto.getName() + " has been created successfully!");
    }

    @Override
    public List<Product> allProducts() {
        List<Product> products = productRepository.findAll();
//        List<ProductDto> productDtos = new ArrayList<>();
//
//        for (Product product : products) {
//            productDtos.add(new ProductDto());
//        }
        return products;
    }

    @Override
    public ProductResponse getProductById(long productId) {
        Product product = productRepository.findById(productId).get();
        if (productRepository.existsById(productId)) {
            return ProductResponse.builder()
                    .imageUrl(product.getImageUrl())
                    .description(product.getDescription())
                    .category(product.getCategory())
                    .name(product.getName())
                    .build();
        } else {
            return ProductResponse.builder()
                    .description("Product already exist")
                    .build();
        }
    }

    @Override
    public UpdatedProductResponse updateProduct(Long id, UpdateProductDto updateProductDto) {
        UpdatedProductResponse updatedProductresponse = new UpdatedProductResponse();
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return responseCodeUtil.updateResponseData(updatedProductresponse, ResponseCodeEnum.ERROR, "Product not found");
        }
                product.setName(updateProductDto.getProductName());
                product.setPrice(updateProductDto.getPrice());
                product.setQuantity(updateProductDto.getQuantity());
                productRepository.save(product);

                return responseCodeUtil.updateResponseData(updatedProductresponse, ResponseCodeEnum.SUCCESS, product.getName() + " updated successfully");
    }


}
