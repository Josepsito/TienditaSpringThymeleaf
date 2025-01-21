package com.deconfort.tiendavirtual.dao;

import com.deconfort.tiendavirtual.dto.ProductDTO;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> getProducts();

    List<ProductDTO> getProductsPorIniciales(String iniciales);

    ProductDTO getProductById(int id);
    void deleteProductById(int id);
    void createProduct(ProductDTO product);
    void updateProduct(ProductDTO product);
    List<ProductDTO> getProductsByCategory(String categoria);
    List<ProductDTO> getProductsByCategoryIniciales(String categoria, String iniciales);
}
