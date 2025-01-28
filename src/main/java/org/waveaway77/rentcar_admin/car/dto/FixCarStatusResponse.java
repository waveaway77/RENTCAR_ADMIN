package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FixCarStatusResponse {
    private HttpStatus status;

    public FixCarStatusResponse(HttpStatus status) {
        this.status = status;
    }

}