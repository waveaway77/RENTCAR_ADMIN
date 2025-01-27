package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FixCarInfoRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private LocalDateTime updatedAt = LocalDateTime.now();

}
