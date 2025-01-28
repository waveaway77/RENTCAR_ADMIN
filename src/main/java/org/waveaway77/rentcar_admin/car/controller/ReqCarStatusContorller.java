package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.ReqCarInfoResponse;
import org.waveaway77.rentcar_admin.car.dto.ReqCarStatusRequest;
import org.waveaway77.rentcar_admin.car.dto.ReqCarStatusResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 전문명 : 차량 상태별 조회
 * 작성자 : 이지예
 * 작성일자 : 2025.01.28
 * 전문설명 : 카테고리에 해당하는 차량을 상태별로 조회한다. (AVAILABLE, RENTEND, CHECKING(점검), REPARING(수리), MISSING(분실)
 *           페이징 처리.
 */
@RestController
public class ReqCarStatusContorller {

    @Autowired
    CarRepository repository;

    @PostMapping("/carbystatus")
    public List<ReqCarStatusResponse> carByStatus(@RequestBody ReqCarStatusRequest request) throws Exception {
        /* 0. validation check */
        if ( request.getPageNo() < 0
                || request.getPageSize() == 0
                || request.getCategory().isEmpty()
                || request.getSTATUS().isEmpty()) {
            // todo logger
            throw new Exception("[carByStatus] validation check failed. category:"+request.getCategory());
        }

        /* 1. db 조회 */
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize());
        Page<Car> page;
        try {
            page = repository.findByCategoryAndStatus(request.getCategory(), request.getSTATUS(), pageRequest);
        } catch (Exception e) {
            throw new Exception("[carByStatus] DB 조회 실패. category:"+request.getCategory());
        }

        /* 2. return response */
        List<ReqCarStatusResponse> response = new ArrayList<>();
        List<Car> cars = page.getContent();
        try {
            response = cars.stream().map(car -> new ReqCarStatusResponse(
                    car.getCarId()
                    , car.getCategory()
                    , car.getProdYear()
                    , car.getCompany()
                    , car.getModel()
                    , car.getStatus()
            ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("[carInfo] Response 객체 생성 중 오류");
        }
        
        return response;
    }
}
