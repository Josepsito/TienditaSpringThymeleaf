package com.deconfort.tiendavirtual.service;

import com.deconfort.tiendavirtual.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();

    List<ProductDTO> getProductsByInit(String iniciales);
    List<ProductDTO> getProductsByCategory(String categoria);
    ProductDTO getProductById(int id);
    void deleteProductById(int id);
    void createProduct(ProductDTO product);
    void updateProduct(ProductDTO product);
}
