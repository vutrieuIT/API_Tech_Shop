package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.dto.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    Response<List<CategoryDTO>> getAll();
}
