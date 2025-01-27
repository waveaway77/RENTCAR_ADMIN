package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoResponse;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusResponse;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

@RestController
public class FixCarStatusController {

    @Autowired
    CarRepository repository;

    @PostMapping("/fixcarstatus")
    public ResponseEntity<?> fixCarStatus(@RequestBody FixCarStatusRequest request) throws Exception {
        if (request.getCarIdArray().length == 0 || request.getStatus().isEmpty()) {
            throw new Exception("Car id or status is empty");
        }

        repository.updateCarStatus(request.getCarIdArray(), request.getStatus(), request.getUpdatedAt());

//        return ResponseEntity.ok().build();
        FixCarStatusResponse response = new FixCarStatusResponse(HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
