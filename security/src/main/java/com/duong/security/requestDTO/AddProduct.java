package com.duong.security.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddProduct {
    @NotBlank(message = "khong duoc de trong ten san pham")
    private String name;
    @NotBlank(message = "khong duoc bo trong gia tien")
    private double price;
    private String description;
    @NotBlank(message = "khong duoc bo trong ton kho")
    private int stockQuantity;
    @NotBlank(message = "Khong duoc bo trong danh muc")
    private String category;

}
