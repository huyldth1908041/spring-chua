package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor //dependencies injection
public class ProductController {
    private final ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO getDetail(@PathVariable(value = "id") int id) {
        return productService.productDetail(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ProductDTO createProduct(@RequestBody ProductDTO.CreateProductDTO createProductDTO) {
        return productService.saveProduct(createProductDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "id") int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "id") int id) {
        productService.deleteProd(id);
    }
}
