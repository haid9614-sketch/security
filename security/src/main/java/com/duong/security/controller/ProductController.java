package com.duong.security.controller;
import com.duong.security.Entity.Product;
import com.duong.security.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    // http://localhost:8080/api/product
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
    // http://localhost:8080/api/product/category?name=iphone
    @GetMapping("/category")
    public List<Product> getByCategory(@RequestParam(name = "name") String categoryKey) {
        return productService.getByCategory(categoryKey);
    }
    // http://localhost:8080/api/product/key
    @GetMapping("/key/{name}")
    public List<Product> getByName(@PathVariable("name") String name) {
        return productService.getByName(name);
    }
    // http://localhost:8080/api/product/price?min=15000000&max=25000000
    @GetMapping("/price")
    public List<Product> getByPrice(@RequestParam(name = "min") double min, @RequestParam(name = "max") double max) {
        return productService.getByPrice(min, max);
    }
    // http://localhost:8080/api/product/isactive
    @GetMapping("/isactive")
    public String kiemTraTonKho() {
        return "so luong san pham ton kho: " + productService.kiemTraTonKho();
    }
    //  http://localhost:8080/api/product
    @PostMapping
    public String addProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
        return "da them san pham thanh cong";
    }
    // http://localhost:8080/api/product/name/description?key=iphone
    @GetMapping("/name/description")
    public List<Product> searchByNameAnhDescription(@RequestParam(name = "key") String key) {
        return productService.searchByNameOrDescription(key);
    }
    // http://localhost:8080/api/product/stock
    @GetMapping("/stock")
    public List<Product> filterByStock() {
        return productService.filterByStock();
    }
    // http://localhost:8080/api/product/price/top5
    @GetMapping("price/top5")
    public List<Product> top5byPrice() {
        return productService.top5Byprice();
    }
    // http://localhost:8080/api/product/stock/delete
    @DeleteMapping("/stock/delete")
    public String deleteByStock() {
        productService.deleteByStock();
        return "Da xoa san pham khong kha dung";
    }

}
