package com.example.api;

import com.example.dto.ProductDTO;
import com.example.entity.OrderEntity;
import com.example.projection.ProductProjection;
import com.example.repository.OrderRepository;
import com.example.service.impl.OrderService;
import com.example.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<ProductProjection> getProduct(@RequestParam(required = false) Long category_id,
                                              @RequestParam(defaultValue = "0") int pageNumber,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        if (category_id != null){
            return productService.getAllByCategoryId(category_id, pageNumber, pageSize);
        } else {
            return productService.getAll(pageNumber, pageSize);
        }
    }

    @GetMapping("/{id}")
    public ProductProjection getDetailProduct(@PathVariable("id") Long id){
        return productService.getDetailProduct(id);
    }

    @GetMapping("/popular")
    public List<ProductProjection> getPopularProduct(){
        List<Long> ids = orderService.findTopProduct(100);
        return productService.getPopularProduct(100);
    }
}
