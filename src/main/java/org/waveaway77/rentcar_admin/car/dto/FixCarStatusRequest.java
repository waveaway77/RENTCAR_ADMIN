package org.waveaway77.rentcar_admin.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FixCarStatusRequest {
    int[] carIdArray;
    String status = "";
    LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public FixCarStatusRequest(int[] carIdArray, String status) {
        this.carIdArray = carIdArray;
        this.status = status;
    }
}
