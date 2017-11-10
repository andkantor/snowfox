package com.andkantor.snowfox.web.model.product;

import com.andkantor.snowfox.web.model.base.PageResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPageResponse extends PageResponse<Product> {
}
