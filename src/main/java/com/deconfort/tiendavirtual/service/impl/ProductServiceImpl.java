package com.deconfort.tiendavirtual.service.impl;

import com.deconfort.tiendavirtual.dao.ProductDAO;
import com.deconfort.tiendavirtual.dto.ProductDTO;
import com.deconfort.tiendavirtual.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    public List<ProductDTO> getProductsByInit(String iniciales) {
        return productDAO.getProductsPorIniciales(iniciales);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoria) {
        return productDAO.getProductsByCategory(categoria);
    }

    @Override
    public List<ProductDTO> getProductsByCategoryName(String categoria, String iniciales) {
        return productDAO.getProductsByCategoryIniciales(categoria,iniciales);
    }

    @Override
    public ProductDTO getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productDAO.deleteProductById(id);
    }

    @Override
    public void createProduct(ProductDTO product) {
        productDAO.createProduct(product);
    }

    @Override
    public void updateProduct(ProductDTO product) {
        productDAO.updateProduct(product);
    }


}
