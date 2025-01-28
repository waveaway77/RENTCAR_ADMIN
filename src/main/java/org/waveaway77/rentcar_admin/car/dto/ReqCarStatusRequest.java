package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqCarStatusRequest {
    private int pageNo;
    private int pageSize;
    private String category = "";
    private String STATUS = "";
}
