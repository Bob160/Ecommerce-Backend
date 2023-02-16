package com.efiom.ecommerce.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotBlank(message = "Name must not be blank")
    private String categoryName;
    @NotBlank(message = "Description must not be blank")
    private String description;
    @NotBlank(message = "imageUrl must not be blank")
    private String imageUrl;
}
