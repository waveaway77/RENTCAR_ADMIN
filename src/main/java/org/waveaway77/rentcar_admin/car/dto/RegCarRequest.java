package org.waveaway77.rentcar_admin.car.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RegCarRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private String status = "";
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public RegCarRequest(int carId, String category, String prodYear, String company, String model, String status) {
        this.carId = carId;
        this.category = category;
        this.prodYear = prodYear;
        this.company = company;
        this.model = model;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegCarRequest{" +
                "carId=" + carId +
                ", category='" + category + '\'' +
                ", prodYear='" + prodYear + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
