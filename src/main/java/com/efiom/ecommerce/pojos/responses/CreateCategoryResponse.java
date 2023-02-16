package com.efiom.ecommerce.pojos.responses;

import com.efiom.ecommerce.config.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class CreateCategoryResponse extends BaseResponse {

    private String categoryName;
    private String description;
    private String imageUrl;
}
