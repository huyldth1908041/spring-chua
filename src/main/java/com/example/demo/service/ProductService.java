package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<ProductDTO> getAllProduct() {

        List<Product> allProducts = productRepository.findAll();
        List<ProductDTO> listDtos = allProducts.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
        return listDtos;
    }

    public ProductDTO productDetail(int id) {
        //linear search
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.orElse(null);
        return new ProductDTO(product);

    }

    public ProductDTO saveProduct(ProductDTO.CreateProductDTO dto) {
        Product toSave = new Product();
        toSave.setQuantity(dto.getQty());
        toSave.setName(dto.getName());
        Optional<Category> categoryOptional = categoryRepository.findById(dto.getCateId());
        Category category = categoryOptional.orElse(null);
        toSave.setCategory(category);
        return new ProductDTO(productRepository.save(toSave));
    }

    public Product updateProduct(int id, Product product) {
        Product toUpdate = productRepository.getById(id);
        toUpdate.setName(product.getName());
        toUpdate.setQuantity(product.getQuantity());
        Product save = productRepository.save(toUpdate);
        return save;
    }

    public void deleteProd(int id) {
        Product toDel = productRepository.getById(id);
        productRepository.delete(toDel);
    }

}
