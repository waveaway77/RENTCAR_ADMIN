package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegCarRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private String status = "";
    private LocalDateTime createdAt = LocalDateTime.now();
}
