package com.efiom.ecommerce.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
