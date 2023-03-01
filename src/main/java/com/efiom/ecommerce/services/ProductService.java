package com.efiom.ecommerce.services;

import com.efiom.ecommerce.models.Category;
import com.efiom.ecommerce.models.Product;
import com.efiom.ecommerce.pojos.requests.ProductDto;
import com.efiom.ecommerce.pojos.requests.UpdateProductDto;
import com.efiom.ecommerce.pojos.responses.ProductResponse;
import com.efiom.ecommerce.pojos.responses.UpdatedProductResponse;
import com.efiom.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
ProductResponse addProduct(ProductDto productDto);

List<ProductDto> allProducts();
UpdatedProductResponse updateProduct(Long id, UpdateProductDto updateProductDto);
}
