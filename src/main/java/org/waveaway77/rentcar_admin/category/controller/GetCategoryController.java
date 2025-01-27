package org.waveaway77.rentcar_admin.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.category.dto.GetCategoryResponse;
import org.waveaway77.rentcar_admin.category.repository.CategoryRepository;

@RestController
public class GetCategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping("/getcategory")
    public GetCategoryResponse getCategory() {

        /* 1. DB 조회 */
        GetCategoryResponse response = new GetCategoryResponse();
        response.setCategoryArray(repository.findCategory());

        return response;
    }

}
