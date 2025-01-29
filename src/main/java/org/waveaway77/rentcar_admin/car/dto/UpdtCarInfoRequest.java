package org.waveaway77.rentcar_admin.car.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdtCarInfoRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public UpdtCarInfoRequest(int carId, String category, String prodYear, String company, String model) {
        this.carId = carId;
        this.category = category;
        this.prodYear = prodYear;
        this.company = company;
        this.model = model;
    }

    @Override
    public String toString() {
        return "FixCarInfoRequest{" +
                "carId=" + carId +
                ", category='" + category + '\'' +
                ", prodYear='" + prodYear + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
