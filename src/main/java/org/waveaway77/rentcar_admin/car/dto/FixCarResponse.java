package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class FixCarResponse {
    private HttpStatus status;

    public FixCarResponse(HttpStatus status) {
        this.status = status;
    }
}