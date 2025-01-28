package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.RegCarRequest;
import org.waveaway77.rentcar_admin.car.dto.RegCarResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.time.LocalDateTime;

/**
 * 전문명 : 차량 신규 등록
 * 작성자 : 이지예
 * 작성일자 : 2025.01.28
 * 전문설명 : 차량 신규 등록
 */
@RestController
public class RegCarController {

    @Autowired
    CarRepository repository;

    @PostMapping("/regcar")
    public RegCarResponse regCar(@RequestBody RegCarRequest request) throws Exception {

        /* 0. validation check */
        if (request.getCategory().isEmpty()
        || request.getProdYear().isEmpty()
        || request.getCompany().isEmpty()
        || request.getStatus().isEmpty()
        || request.getModel().isEmpty()) {
            throw new Exception("[regCar] validation check failed. request: "+request);
        }

        /* 1. DB insert */
        try {
            repository.save(Car.builder()
                    .category(request.getCategory())
                    .prodYear(request.getProdYear())
                    .company(request.getCompany())
                    .model(request.getModel())
                    .status(request.getStatus())
                    .createdAt(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            throw new Exception("[regCar] 차량 등록 실패. request: "+request);
        }

        /* 2. return response */
        return new RegCarResponse(HttpStatus.CREATED);
    }
}
