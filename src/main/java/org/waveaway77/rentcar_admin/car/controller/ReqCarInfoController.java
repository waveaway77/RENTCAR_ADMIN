package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.ReqCarInfoRequest;
import org.waveaway77.rentcar_admin.car.dto.ReqCarInfoResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 전문명 : 차량정보 조건검색
 * 작성자 : 이지예
 * 작성일자 : 2025.01.28
 * 전문설명 : 차량정보 조건검색, 페이징 처리
 */
@RestController
public class ReqCarInfoController {

    @Autowired
    CarRepository repository;

    @PostMapping("/carinfo")
    public List<ReqCarInfoResponse> carInfo(@RequestBody ReqCarInfoRequest request) throws Exception {

        /* 0. validation check*/
        if (request.getCompany().isEmpty()
            && request.getModel().isEmpty()
            && request.getProdYear().isEmpty()) {
            throw new Exception("[carInfo] validation check failed. request: "+request);
        }

        if (request.getCategory().isEmpty()
        || request.getPageNo() < 0
        || request.getPageSize() == 0) {
            // todo logger
            throw new Exception("[carInfo] validation check failed. request: "+request);
        }

        /* 1. DB 조회 */
        // 페이징 설정
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize());
        // 조회
        Page<Car> page;
        try {
            page = repository.findByDynamicConditions(
                    pageRequest
                    , request.getCategory()
                    , request.getModel()
                    , request.getCompany()
                    , request.getProdYear()

            );
        } catch (Exception e) {
            throw new Exception("[carInfo] DB 조회 실패 "+request);
        }

        if (page.isEmpty()) { // 검색 결과 없을 경우
            // return response
            return new ArrayList<ReqCarInfoResponse>();
        }

        // Car to Response
        List<ReqCarInfoResponse> responses;
        List<Car> cars = page.getContent();
        try {
            responses = cars.stream().map(car -> new ReqCarInfoResponse(
                            car.getCarId()
                            , car.getCategory()
                            , car.getProdYear()
                            , car.getCompany()
                            , car.getModel()
                            , car.getStatus()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("[carInfo] Response 객체 생성 중 오류. car:"+page.getContent());
        }

        /* return response */
        return responses;
    }

}
