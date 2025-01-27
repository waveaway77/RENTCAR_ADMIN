package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.ReqCarInfoRequest;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.util.List;

@RestController
public class ReqCarInfoController {

    @Autowired
    CarRepository repository;

    @PostMapping("/carinfo")
    public List<Car> carInfo(@RequestBody ReqCarInfoRequest request) throws Exception {

        /* 0. validation check*/
        if (request.getCompany().isEmpty()
            && request.getModel().isEmpty()
            && request.getProdYear().isEmpty()
        ) {
            // todo logger
            throw new Exception();
        }

        if (request.getCategory().isEmpty()
        || request.getPageNo() == 0
        || request.getPageSize() == 0) {
            // todo logger
            throw new Exception();
        }

        /* 1. DB 조회 */
        // 페이징 설정
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize());
        Page<Car> page = repository.findByDynamicConditions(
                pageRequest
                , request.getCategory()
                , request.getModel()
                , request.getCompany()
                , request.getProdYear()

        );

        /* return response */
        return page.getContent();
    }

}
