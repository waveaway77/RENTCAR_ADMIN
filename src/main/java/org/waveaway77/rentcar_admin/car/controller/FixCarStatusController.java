package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarStatusResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;
import org.waveaway77.rentcar_admin.rent.entity.Rent;
import org.waveaway77.rentcar_admin.rent.repository.RentRepository;

import java.util.Optional;

@RestController
public class FixCarStatusController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    RentRepository rentRepository;

    @PostMapping("/fixcarstatus")
    public ResponseEntity<?> fixCarStatus(@RequestBody FixCarStatusRequest request) throws Exception {
        if (request.getCarIdArray().length == 0 || request.getStatus().isEmpty()) {
            throw new Exception("Car id or status is empty");
        }

        for (int carId : request.getCarIdArray()) {
            Optional<Car> car = carRepository.findById(carId);
            String status = car.get().getStatus();

            switch (status) {
                case "AVAILABLE" :
                case "MISSING" :
                    carRepository.updateCarStatus(request.getCarIdArray(), request.getStatus(), request.getUpdatedAt());
                    break;

                case "RENTED" : // 반납 확인 후 진행 가능

                    // 대여 정보 확인
                    String rentStatus = rentRepository.findByCarId(carId);
                    if (rentStatus == null) { throw  new Exception("Rent info not found"); }
                    if (!rentStatus.equals("RETURNED")) { throw new Exception("반납 완료 후에 변경 가능합니다."); }

                    // 변경 진행
                    carRepository.updateCarStatus(request.getCarIdArray(), request.getStatus(), request.getUpdatedAt());
                    break;

                case "CHECKING" : // 점검 완료 후에 진행 가능
                    // ...
                    break;

                case "REPARING" : // 수리 여부 확인 후에 진행 가능
                    // ...
                    break;

                default:
                    throw new Exception("Invalid car status");
            }

        }

        FixCarStatusResponse response = new FixCarStatusResponse(HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
