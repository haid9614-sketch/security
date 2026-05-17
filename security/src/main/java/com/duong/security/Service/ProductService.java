package com.duong.security.Service;

import com.duong.security.Entity.Product;
import com.duong.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product addProduct(Product product) {
       return productRepository.save(product);
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public List<Product> getByCategory(String categoryKey) {
       return productRepository.findByCategoryContainingIgnoreCase(categoryKey);
    }
    public List<Product> getByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Product> getByPrice(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }
    public Long kiemTraTonKho() {
        return productRepository.countByIsActiveTrue();
    }
    public List<Product> searchByNameOrDescription(String name) {
        return productRepository.searchBynameAndDescription(name);
    }
    public List<Product> filterByStock() {
        return productRepository.filterbyStock();
    }
    public List<Product> top5Byprice() {
        return productRepository.top5byPrice();
    }
    public void deleteByStock() {
        productRepository.deleteProductbyStock();
    }
}
