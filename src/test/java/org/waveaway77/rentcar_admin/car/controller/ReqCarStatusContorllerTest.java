package org.waveaway77.rentcar_admin.car.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

@SpringBootTest
class ReqCarStatusContorllerTest {

    @InjectMocks
    private ReqCarStatusController controller;
    @Mock
    private CarRepository repository;

    @Test
    @DisplayName("정상 조회")
    public void withValidRequest() throws Exception {}

    @Test
    @DisplayName("필수값 누락")
    public void wintWrongParameter() throws Exception {}

    @Test
    @DisplayName("조건에 따른 조회 결과 없음")
    public void emptyResult() throws Exception {}

}