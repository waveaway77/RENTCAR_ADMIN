package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FixCarInfoRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private LocalDateTime updatedAt = LocalDateTime.now();

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
