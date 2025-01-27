package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoResponse;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

@RestController
public class FixCarInfoController {

    @Autowired
    CarRepository repository;

    @PostMapping("/fixcarinfo")
    public ResponseEntity<?> fixCarInfo(@RequestBody FixCarInfoRequest request) throws Exception {

        /* 0. validation check */
        if (request.getCategory().isEmpty() || request.getProdYear().isEmpty() || request.getCompany().isEmpty() || request.getModel().isEmpty()) {
            // logger
            throw new Exception();
        }

        repository.updateCarInfo(
                request.getCarId()
                , request.getCategory()
                , request.getProdYear()
                , request.getCompany()
                , request.getModel()
                , request.getUpdatedAt()
        );

        FixCarInfoResponse response = new FixCarInfoResponse(HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
