package com.efiom.ecommerce.pojos.requests;

import com.efiom.ecommerce.models.Product;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
//@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
public class ProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private int quantity;
    @NotBlank
    private String description;
    @NotBlank
    private String categoryName;

}
