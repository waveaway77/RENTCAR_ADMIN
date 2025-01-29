package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class UpdtCarStatusResponse {
    private HttpStatus status;

    public UpdtCarStatusResponse(HttpStatus status) {
        this.status = status;
    }

}