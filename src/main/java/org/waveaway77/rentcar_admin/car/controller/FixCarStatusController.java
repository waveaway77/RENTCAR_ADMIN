package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;
import org.waveaway77.rentcar_admin.rent.repository.RentRepository;

import java.time.LocalDateTime;

/**
 * 전문명 : 다수 차량의 상태 수정
 * 작성자 : 이지예
 * 작성일자 : 2025.01.28
 * 전문설명 : 충족조건 확인 후 차량상태 업데이트
 */
@RestController
public class FixCarStatusController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    RentRepository rentRepository;

    @PostMapping("/fixcarstatus")
    public FixCarStatusResponse fixCarStatus(@RequestBody FixCarStatusRequest request) throws Exception {

        /*0. validation check */
        if (request.getCarIdArray().length == 0 || request.getStatus().isEmpty()) {
            throw new Exception("[fixCarStatus] validation check failed");
        }

        /*1. DB update */
        for (int carId : request.getCarIdArray()) {

            // 차량 조회
            carRepository.findById(carId)
                    .orElseThrow(() -> new Exception("[fixCarStatus] 차량 조회되지 않음. carId:" + carId));

            // 상태 수정
            switch (request.getStatus()) {
                case "AVAILABLE":
                case "MISSING":
                    carRepository.updateCarStatus(carId, request.getStatus());
                    break;

                case "RENTED": // 반납 확인 후 진행 가능

                    // 대여 정보 확인
                    String rentStatus = rentRepository.selectStatusByCarId(carId);
                    if (rentStatus == null || rentStatus.isEmpty()) {
                        throw new Exception("[fixCarStatus] 렌트 정보 조회되지 않음. carId:" + carId);
                    }
                    // 변경 조건 확인
                    if (!rentStatus.equals("RETURNED")) {
                        throw new Exception("[fixCarStatus] 상태 변경은 반납 완료 후 가능합니다.");
                    }

                    // 변경 진행
                    carRepository.updateCarStatus(carId, request.getStatus());
                    break;

                case "CHECKING": // 점검 완료 후에 진행 가능
                    // ...
                    break;

                case "REPARING": // 수리 여부 확인 후에 진행 가능
                    // ...
                    break;

                default:
                    throw new Exception("[fixCarStatus] Invalid car status");
            }

        }

        /* 3. return response */
        return new FixCarStatusResponse(HttpStatus.OK);
    }
}
