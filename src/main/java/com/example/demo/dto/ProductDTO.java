package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private int qty;
    private String category;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.qty = product.getQuantity();
        this.category = product.getCategory().getName();
    }

    @Data
    public static class CreateProductDTO {
        private String name;
        private int qty;
        private int cateId;
    }
}
