package org.waveaway77.rentcar_admin.car.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReqCarInfoResponse {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private String status = "";
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public ReqCarInfoResponse(int carId, String category, String prodYear, String company, String model, String status) {
        this.carId = carId;
        this.category = category;
        this.prodYear = prodYear;
        this.company = company;
        this.model = model;
        this.status = status;
        this.createdAt = createdAt;
    }
}
