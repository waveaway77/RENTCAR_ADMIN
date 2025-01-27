package org.waveaway77.rentcar_admin.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.category.dto.GetCategoryResponse;
import org.waveaway77.rentcar_admin.category.repository.CategoryRepository;

/**
 * 작성자 : 이지예
 * 작성일자 : 2025.01.27
 * 전문정의 : admin 페이지의 카테고리 목록을 리턴한다
 */
@RestController
public class GetCategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping("/getcategory")
    public GetCategoryResponse getCategory() {

        /* 1. DB 조회 */
        GetCategoryResponse response = new GetCategoryResponse();
        response.setCategoryArray(repository.findCategory());

        /* 2. return response */
        return response;
    }

}
