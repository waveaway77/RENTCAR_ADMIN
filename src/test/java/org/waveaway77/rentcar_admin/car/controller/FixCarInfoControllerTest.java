package org.waveaway77.rentcar_admin.car.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoRequest;
import org.waveaway77.rentcar_admin.car.dto.FixCarInfoResponse;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FixCarInfoControllerTest {

    @InjectMocks
    private FixCarInfoController controller;
    @Mock
    private CarRepository repository;

    @Test
    @DisplayName("차량 수정 되는지")
    public void withValidRequest_ShouldPass() throws Exception {
        // given
        FixCarInfoRequest request = new FixCarInfoRequest(1, "101", "2025", "11", "마티즈");
        // when
        FixCarInfoResponse response = controller.fixCarInfo(request);
        // then
        assertNotNull(response);
    }

    @Test
    @DisplayName("요청 파라미터 누락 시 validation check")
    public void withEmptyParameter_ShouldThrowException() throws Exception {
        // given
        FixCarInfoRequest request = new FixCarInfoRequest(1, "", null, null, null);
        // when
        Exception exception = assertThrows(Exception.class, () -> controller.fixCarInfo(request));
        // then
        assertTrue(exception.getMessage().contains("validation check failed"));
    }

    @Test
    @DisplayName("차량 수정 실패 시 throw exception 검증")
    public void whenSaveFails_ShouldThrowException() throws Exception {
        // given
        FixCarInfoRequest request = new FixCarInfoRequest(1, "101", "2025", null, null);
        // when
        doNothing().when(repository).updateCarInfo(request.getCarId(), request.getCategory(), request.getProdYear(), request.getCompany(), request.getModel(), LocalDateTime.now());
        repository.updateCarInfo(request.getCarId(), request.getCategory(), request.getProdYear(), request.getCompany(), request.getModel(), LocalDateTime.now());
        // then
        verify(repository, times(0)).updateCarInfo(request.getCarId(), request.getCategory(), request.getProdYear(), request.getCompany(), request.getModel(), LocalDateTime.now());
    }

}