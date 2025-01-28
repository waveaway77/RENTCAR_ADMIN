package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqCarInfoRequest {
    private int pageNo;
    private int pageSize;
    private String category = "";
    private String company = "";
    private String model = "";
    private String prodYear = "";
}
