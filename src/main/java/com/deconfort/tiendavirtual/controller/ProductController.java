package com.deconfort.tiendavirtual.controller;

import com.deconfort.tiendavirtual.dto.ProductDTO;
import com.deconfort.tiendavirtual.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @RequestMapping
    public ModelAndView verPaginaPrincipal(HttpSession session){

        if (session.getAttribute("user") == null){
            return new ModelAndView("login");
        }
        return new ModelAndView("principal","user",session.getAttribute("user"));
    }

    @RequestMapping("/products")
    public ModelAndView verLosProductos(){
        List<ProductDTO> productList =productService.getProducts();
        return new ModelAndView("listaProductos","productList",productList);
    }

    @RequestMapping("/products/name/{iniciales}")
    public ModelAndView verLosProductosPorIniciales(@PathVariable String iniciales){
        List<ProductDTO> productList =productService.getProductsByInit(iniciales);
        return new ModelAndView("listaProductos","productList",productList);
    }

    @RequestMapping("/products/category/{categoria}")
    public ModelAndView verLosProductosPorCategoria(@PathVariable String categoria){
        List<ProductDTO> productList =productService.getProductsByCategory(categoria);
        return new ModelAndView("listaProductos","productList",productList);
    }

    @RequestMapping("/products/{id}")
    public ModelAndView verLosProductos(@PathVariable int id){
        ProductDTO product =productService.getProductById(id);
        return new ModelAndView("unProducto","product",product);
    }

    @RequestMapping("/addToShoppingCar/")
    public ModelAndView añadirAlCarrito(@PathVariable int id, HttpRequest request){
        ProductDTO product =productService.getProductById(id);
        return new ModelAndView("unProducto","product",product);
    }

}