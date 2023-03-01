package com.efiom.ecommerce.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {
    @NotNull(message = "Product name should not be null")
    private String productName;
    private Integer quantity;
    private BigDecimal price;
}
