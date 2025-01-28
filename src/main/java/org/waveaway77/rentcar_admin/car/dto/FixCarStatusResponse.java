package org.waveaway77.rentcar_admin.car.dto;

import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
public class FixCarStatusResponse {
    private HttpStatus status;

    public FixCarStatusResponse(HttpStatus status) {
        this.status = status;
    }

}
