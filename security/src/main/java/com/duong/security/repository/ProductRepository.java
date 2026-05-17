package com.duong.security.repository;

import com.duong.security.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryContainingIgnoreCase(String categoryKey);
    List<Product> findByNameContainingIgnoreCase(String nameKey);
    List<Product> findByPriceBetween(double min, double max);
    Long countByIsActiveTrue();
    @Query("SELECT p FROM Product p WHERE (LOWER(p.name) LIKE CONCAT('%', LOWER(:key), '%')" +
            " OR LOWER(p.description) LIKE CONCAT('%', LOWER(:key), '%')) AND p.isActive = true")
    List<Product> searchBynameAndDescription(@Param("key") String key);
    @Query("SELECT p FROM Product p " +
            "WHERE p.stockQuantity > 0 AND p.stockQuantity < 5 " +
            "ORDER by p.stockQuantity ASC")
    List<Product> filterbyStock();
    @Query(value = "SELECT * FROM product " +
            "ORDER BY price DESC " +
            "LIMIT 5", nativeQuery = true)
    List<Product> top5byPrice();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM PRODUCT " +
            "WHERE stock_quantity = 0 AND is_active = false", nativeQuery = true)
    void deleteProductbyStock();

}
