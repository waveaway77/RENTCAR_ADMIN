package org.waveaway77.rentcar_admin.car.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.waveaway77.rentcar_admin.car.dto.RegCarRequest;
import org.waveaway77.rentcar_admin.car.dto.RegCarResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RegCarControllerTest {

    @InjectMocks
    private RegCarController controller;
    @Mock
    private CarRepository repository;

    @Test
    @DisplayName("차량 정상 등록되는지")
    public void withValidRequest_ShouldPass() throws Exception {
        // given
        RegCarRequest request = new RegCarRequest(1, "101", "2025", "11", "쏘렌토", "AVAILABLE");
        // when
        RegCarResponse response = controller.regCar(request);
        // then
        assertEquals(HttpStatus.CREATED, response.getStatus());
        verify(repository, times(1)).save(any(Car.class));
    }

    @Test
    @DisplayName("요청 파라미터 누락 시 validation check")
    public void withEmptyParameter_ShouldThrowException() throws Exception {
        // given
        RegCarRequest request = new RegCarRequest(1, "", "", "11", "마티즈", "AVAILABLE");
        // when
        Exception exception = assertThrows(Exception.class, () -> controller.regCar(request));
        // then
        assertTrue(exception.getMessage().contains("validation check"));
    }

    @Test
    @DisplayName("차량 등록 실패 시 throw exception 검증")
    public void whenSaveFails_ShouldThrowException() {
        // given
        RegCarRequest request = new RegCarRequest(1, "101", "2025", "11", "마티즈", "AVAILABLE");
        // when
        when(repository.save(any(Car.class))).thenThrow(new RuntimeException("DB Error"));
        Exception exception = assertThrows(Exception.class, () -> controller.regCar(request));
        // then
        assertTrue(exception.getMessage().contains("차량 등록 실패"));
    }

}