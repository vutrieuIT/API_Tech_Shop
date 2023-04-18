package com.example.service;

import com.example.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<CategoryDTO> getAll();
}
