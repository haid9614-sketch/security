package com.duong.security.Service;

import com.duong.security.Entity.Product;
import com.duong.security.repository.ProductRepository;
import com.duong.security.requestDTO.AddProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<?> addProduct(AddProduct addProduct, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String messageErrors = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(messageErrors);
        }
        Product product = new Product();
        product.setName(addProduct.getName());
        product.setPrice(addProduct.getPrice());
        product.setDescription(addProduct.getDescription());
        product.setStockQuantity(addProduct.getStockQuantity());
        product.setCategory(addProduct.getCategory());
        product.setActive(true);
        productRepository.save(product);
        return ResponseEntity.ok("da luu san pham thanh cong");
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
