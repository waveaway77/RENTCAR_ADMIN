package org.waveaway77.rentcar_admin.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.waveaway77.rentcar_admin.car.dto.ReqCarStatusRequest;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.util.List;

@RestController
public class ReqCarStatusContorller {

    @Autowired
    CarRepository repository;

    @PostMapping("/carbystatus")
    public List<Car> carByStatus(@RequestBody ReqCarStatusRequest request) throws Exception {
        /* 0. validation check */
        if ( request.getPageNo() < 0
                || request.getPageSize() == 0
                || request.getCategory().isEmpty()
                || request.getSTATUS().isEmpty()) {
            // todo logger
            throw new Exception();
        }

        /* 1. db 조회 */
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize());
        Page<Car> page = repository.findByCategoryAndStatus(request.getCategory(), request.getSTATUS(), pageRequest);

        /* 2. return response */
        return page.getContent();
    }
}
