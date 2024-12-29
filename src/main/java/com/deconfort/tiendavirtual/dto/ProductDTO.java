package com.deconfort.tiendavirtual.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private double price;
    private String category;
}
