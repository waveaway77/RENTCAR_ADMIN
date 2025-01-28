package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FixCarInfoResponse {
    private HttpStatus status;

    public FixCarInfoResponse(HttpStatus status) {
        this.status = status;
    }
}