package org.waveaway77.rentcar_admin.car.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegCarRequest {
    private String car_id = "";
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private String status = "";
    private String createdAt = "";
}
