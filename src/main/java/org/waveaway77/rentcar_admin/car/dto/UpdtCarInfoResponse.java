package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UpdtCarInfoResponse {
    private HttpStatus status;

    public UpdtCarInfoResponse(HttpStatus status) {
        this.status = status;
    }
}