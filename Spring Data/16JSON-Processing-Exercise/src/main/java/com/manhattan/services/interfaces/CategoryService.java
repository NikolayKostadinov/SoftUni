package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.CategoriesByProductsDto;
import com.manhattan.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

    void saveAll(Iterable<Category> cate);

    List<CategoriesByProductsDto> getCategoriesOrderByNumberOfProducts();
}
