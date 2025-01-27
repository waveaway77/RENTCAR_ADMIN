package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RegCarResponse {
    private HttpStatus status;

    public RegCarResponse(HttpStatus status) {
        this.status = status;
    }
}
