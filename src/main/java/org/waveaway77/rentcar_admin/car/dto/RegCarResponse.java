package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RegCarResponse {
    private HttpStatus status;

    public RegCarResponse(HttpStatus status) {
        this.status = status;
    }
}
