package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqCarInfoRequest {
    private int pageNo;
    private int pageSize;
    private String category = "";
    private String company = "";
    private String model = "";
    private String prodYear = "";
}
