package com.duong.security.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "stock_quantity")
    private int stockQuantity;
    @Column(name = "category")
    private String category;
    @Column(name = "is_active")
    private boolean isActive;
    public Product() {}
    public Product(String name, double price, String description, int stockQuantity, String category, boolean isActive) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.isActive = isActive;
    }
    public Product(Long productId, String name, double price, String description, int stockQuantity, String category, boolean isActive) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.isActive = isActive;
    }
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public boolean isActive() {return isActive;}
    public void setActive(boolean active) {isActive = active;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public int getStockQuantity() {return stockQuantity;}
    public void setStockQuantity(int stockQuantity) {this.stockQuantity = stockQuantity;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Long getProductId() {return productId;}
    public void setProductId(Long productId) {this.productId = productId;}
    @Override
    public String toString() {
        return "id: " + this.productId + " | ten: " + this.name + " | gia: " + this.price + " | mo ta: "
                + this.description + " | so luong ton kho: " + this.stockQuantity + " | danh muc: " + this.category;
    }
}
