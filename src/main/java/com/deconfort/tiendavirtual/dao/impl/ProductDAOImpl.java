package com.deconfort.tiendavirtual.dao.impl;

import com.deconfort.tiendavirtual.dao.ProductDAO;
import com.deconfort.tiendavirtual.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private RestTemplate restTemplate= new RestTemplate();

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    @Value("${ui.rest.cursos.tiendita}")
    private String urlServidor;

    @Override
    public List<ProductDTO> getProducts() {

        ProductDTO[] productos= restTemplate.getForObject(urlServidor+"/products",ProductDTO[].class);
        return Arrays.asList(productos);
    }

    @Override
    public List<ProductDTO> getProductsPorIniciales(String iniciales) {
        ProductDTO[] productos= restTemplate.getForObject(urlServidor+"/products/name/"+iniciales,ProductDTO[].class);
        System.out.println(productos);
        return Arrays.asList(productos);
    }


    @Override
    public ProductDTO getProductById(int id) {
        ProductDTO productDTO= restTemplate.getForObject(urlServidor+"/products/"+id,ProductDTO.class);
        return productDTO;
    }

    @Override
    public void deleteProductById(int id) {
        restTemplate.delete(urlServidor+"/products/"+id);
    }

    @Override
    public void createProduct(ProductDTO product) {
        restTemplate.postForEntity(urlServidor+"/products/"+product.getId(),product,ProductDTO.class);
    }

    @Override
    public void updateProduct(ProductDTO product) {
        restTemplate.put(urlServidor+"/products/"+product.getId(),product);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoria) {
        ProductDTO[] productos= restTemplate.getForObject(urlServidor+"/products/category/"+categoria,ProductDTO[].class);
        System.out.println(productos);
        return Arrays.asList(productos);
    }
}
