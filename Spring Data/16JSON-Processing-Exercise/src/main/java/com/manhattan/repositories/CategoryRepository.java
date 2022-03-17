package com.manhattan.repositories;

import com.manhattan.models.productsShop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(long id);

    @Query("SELECT c FROM Category c ORDER BY SIZE(c.products) ")
    List<Category> findAllOrderByProductCount();
}
