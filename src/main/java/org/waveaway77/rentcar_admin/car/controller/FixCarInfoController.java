package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoResponse;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

/**
 * 전문명 : 차량 정보 수정
 * 작성자 : 이지예
 * 작성일자 : 2025.01.28
 * 전문설명 : 차량정보 업데이트
 */
@RestController
public class FixCarInfoController {

    @Autowired
    CarRepository repository;

    @PostMapping("/fixcarinfo")
    public FixCarInfoResponse fixCarInfo(@RequestBody FixCarInfoRequest request) throws Exception {

        /* 0. validation check */
        if (request.getCategory().isEmpty()
                || request.getProdYear().isEmpty()
                || request.getCompany().isEmpty()
                || request.getModel().isEmpty()) {
            throw new Exception("[fixCarInfo] validation check failed");
        }

        /* 1. DB update */
        try {
            repository.updateCarInfo(
                    request.getCarId()
                    , request.getCategory()
                    , request.getProdYear()
                    , request.getCompany()
                    , request.getModel()
                    , request.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new Exception("[fixCarInfo] 차량정보 수정 실패. carId: " + request.getCarId());
        }

        /* 2. return response */
        return new FixCarInfoResponse(HttpStatus.OK);
    }
}
