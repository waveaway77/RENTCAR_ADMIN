package org.waveaway77.rentcar_admin.car.controller;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.waveaway77.rentcar_admin.car.dto.RegCarRequest;
import org.waveaway77.rentcar_admin.car.dto.RegCarResponse;
import org.waveaway77.rentcar_admin.car.entity.Car;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RegCarControllerTest {

    @InjectMocks
    private RegCarController carController;
    @Mock
    private CarRepository repository;

    @Test
    @DisplayName("차량 정상 등록되는지")
    public void testRegCar_WithValidRequest_ShouldPass() throws Exception {
        // given
        RegCarRequest request = new RegCarRequest(1, "101", "2025", "11", "마티즈", "AVAILABLE", LocalDateTime.now());
        // when
        RegCarResponse response = carController.regCar(request);
        // then
        assertEquals(HttpStatus.CREATED, response.getStatus());
        verify(repository, times(1)).save(any(Car.class));
    }

    @Test
    @DisplayName("요청 파라미터 누락 시 validation check")
    public void testRegCar_WithEmptyCategory_ShouldThrowException() throws Exception {
        // given
        RegCarRequest request = new RegCarRequest(1, "", "", "11", "마티즈", "AVAILABLE", LocalDateTime.now());
        // when
        Exception exception = assertThrows(Exception.class, () -> carController.regCar(request));
        // then
        assertTrue(exception.getMessage().contains("validation check failed"));
    }

    @Test
    @DisplayName("차량 등록 실패 시 throw exception 검증")
    public void testRegCar_WhenSaveFails_ShouldThrowException() {
        // given
        RegCarRequest request = new RegCarRequest(1, "101", "2025", "11", "마티즈", "AVAILABLE", LocalDateTime.now());
        when(repository.save(any(Car.class))).thenThrow(new RuntimeException("DB Error"));
        // mock 객체에 Car 객체가 전달되면 throw하게 된다.

        // when
        Exception exception = assertThrows(Exception.class, () -> carController.regCar(request));

        // then
        assertTrue(exception.getMessage().contains("차량 등록 실패"));
    }

}