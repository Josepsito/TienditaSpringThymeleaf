package com.deconfort.tiendavirtual.controller;

import com.deconfort.tiendavirtual.dto.ProductDTO;
import com.deconfort.tiendavirtual.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private List<String> categorias;

    @ModelAttribute("categorias")
    private List<String> modelCategories(){
        return categorias;
    }

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

    @RequestMapping("/products/name")
    public ModelAndView verLosProductosPorIniciales(@RequestParam(name = "iniciales") String inicial) {
        List<ProductDTO> productList = productService.getProductsByInit(inicial);
        ModelAndView modelAndView = new ModelAndView("listaProductos");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("iniciales", inicial);
        return modelAndView;
    }

    @RequestMapping("/products/category_name")
    public ModelAndView verProductosPorInicialesConCategoria(@RequestParam(name = "iniciales",required = false) String iniciales, @RequestParam(name = "categoria",required = false) String categoria){

        List<ProductDTO> productList;

        if (categoria==null||categoria.isEmpty()|| categoria.equals("Selecciona una categoría")) {
            productList =productService.getProductsByInit(iniciales);
        } else if (iniciales == null || iniciales.isEmpty()) {
            productList = productService.getProductsByCategory(categoria);
        } else{
            productList =productService.getProductsByCategoryName(categoria,iniciales);
        }
        return new ModelAndView("listaProductos","productList",productList);
    }


    @RequestMapping("/products/category/{categoria}")
    public ModelAndView verLosProductosPorCategoria(@PathVariable String categoria){
        List<ProductDTO> productList =productService.getProductsByCategory(categoria);
        return new ModelAndView("listaProductos","productList",productList);
    }

    @RequestMapping("/products/{id}")
    public ModelAndView verProductoPorId(@PathVariable int id){
        ProductDTO product =productService.getProductById(id);
        return new ModelAndView("unProducto","product",product);
    }

    @RequestMapping("/addToShoppingCar/")
    public ModelAndView añadirAlCarrito(@PathVariable int id, HttpRequest request){
        ProductDTO product =productService.getProductById(id);
        return new ModelAndView("unProducto","product",product);
    }

}
