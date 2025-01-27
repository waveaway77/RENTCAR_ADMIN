package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.RegCarRequest;
import org.waveaway77.rentcar_admin.car.dto.RegCarResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.time.LocalDateTime;

@RestController
public class RegCarController {

    @Autowired
    CarRepository repository;

    @PostMapping("/regcar")
    public ResponseEntity<?> regCar(@RequestBody RegCarRequest request) throws Exception {

        /* 0. validation check */
        if (request.getCategory().isEmpty() || request.getProdYear().isEmpty() || request.getCompany().isEmpty() || request.getStatus().isEmpty() || request.getModel().isEmpty()) {
            // logger
            throw new Exception();
        }

        /* insert into DB */
        repository.save(Car.builder()
                .category(request.getCategory())
                .prodYear(request.getProdYear())
                .company(request.getCompany())
                .model(request.getModel())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .build());

        RegCarResponse response = new RegCarResponse(HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
