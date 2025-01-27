package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class FixCarInfoResponse {
    private HttpStatus status;

    public FixCarInfoResponse(HttpStatus status) {
        this.status = status;
    }
}