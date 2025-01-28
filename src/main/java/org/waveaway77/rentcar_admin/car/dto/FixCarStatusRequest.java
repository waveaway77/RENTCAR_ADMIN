package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FixCarStatusRequest {
    int[] carIdArray;
    String status = "";
    LocalDateTime updatedAt = LocalDateTime.now();
}
