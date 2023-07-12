package com.efiom.ecommerce.pojos.responses;

import com.efiom.ecommerce.config.BaseResponse;
import com.efiom.ecommerce.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder

public class ProductResponse extends BaseResponse {

    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Category category;
}
