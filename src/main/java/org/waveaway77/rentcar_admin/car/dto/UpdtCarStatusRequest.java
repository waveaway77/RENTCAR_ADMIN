package org.waveaway77.rentcar_admin.car.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UpdtCarStatusRequest {
    int[] carIdArray;
    String status = "";
    LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public UpdtCarStatusRequest(int[] carIdArray, String status) {
        this.carIdArray = carIdArray;
        this.status = status;
    }
}
