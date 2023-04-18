package com.example.api;

import com.example.dto.ProductDTO;
import com.example.projection.ProductProjection;
import com.example.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    private ProductService productService;

//    @GetMapping("{id}")
//    public List<ProductDTO> getProduct(@PathVariable Long id){
//        return productService.getAllByCategoryId(id);
//    }
    @GetMapping("")
    public List<ProductProjection> getProduct(@RequestParam(required = false) Long category_id) {
        if (category_id != null){
            return productService.getAllByCategoryId(category_id);
        } else {
            return productService.getAll();
        }
    }

    @GetMapping("/{id}")
    public ProductProjection getDetailProduct(@PathVariable("id") Long id){
        return productService.getDetailProduct(id);
    }
}
