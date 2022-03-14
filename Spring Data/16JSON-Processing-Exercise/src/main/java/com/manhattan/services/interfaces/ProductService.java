package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.ProductsInRangeDto;
import com.manhattan.models.entities.Category;
import com.manhattan.models.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void saveAll(Iterable<Product> collect);
    Iterable<ProductsInRangeDto> getNotBoughtProductsWithPriceInRange(BigDecimal min, BigDecimal max);

    boolean hasNoRecords();
}
