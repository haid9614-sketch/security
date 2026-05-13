package com.duong.security.repository;

import com.duong.security.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryContainingIgnoreCase(String categoryKey);
    List<Product> findByNameContainingIgnoreCase(String nameKey);
    List<Product> findByPriceBetween(double min, double max);
    Long countByIsActiveTrue();
}
