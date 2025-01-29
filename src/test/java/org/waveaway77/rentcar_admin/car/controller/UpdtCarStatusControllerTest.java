package org.waveaway77.rentcar_admin.car.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.waveaway77.rentcar_admin.car.dto.UpdtCarStatusRequest;
import org.waveaway77.rentcar_admin.car.repository.CarRepository;
import org.waveaway77.rentcar_admin.rent.repository.RentRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UpdtCarStatusControllerTest {

    @InjectMocks
    private UpdtCarStatusController controller;
    @Mock(name = "carRepository")
    @Autowired
    private CarRepository carRepository;
    @Mock(name = "rentRepository")
    @Autowired
    private RentRepository rentRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Mock 초기화
    }

    @Test
    @DisplayName("차량상태 수정 성공")
    public void withValueRequest_ShouldPass() throws Exception {
        // given
        int[] carIdArray = new int[]{1, 2};
        UpdtCarStatusRequest request = new UpdtCarStatusRequest(carIdArray, "AVAILABLE");

        // when
        carRepository.updateCarStatus(carIdArray[0], request.getStatus());

        // then
        verify(carRepository, times(1)).updateCarStatus(carIdArray[0], request.getStatus());
    }

    @Test
    @DisplayName("차량이 id로 조회되지 않을 경우")
    public void withWrongId_ShouldNotPass() throws Exception {
        // given
        int[] carIdArray = new int[]{Integer.MAX_VALUE};
        UpdtCarStatusRequest request = new UpdtCarStatusRequest(carIdArray, "RENTED");
        // when
        Exception exception = assertThrows(Exception.class, () -> {
            controller.fixCarStatus(request);
        });
        // then
        assertTrue(exception.getMessage().contains("차량 조회되지 않음"));
    }

    @Test
    @DisplayName("빈 ID 배열이 들어온 경우")
    public void withEmptyCarIdArrayParameter_ShouldNotPass() throws Exception {
        // given
        int[] emptyArray = new int[]{};
        UpdtCarStatusRequest request = new UpdtCarStatusRequest(emptyArray, "AVAILABLE");
        // when
        Exception exception = assertThrows(Exception.class, () -> controller.fixCarStatus(request));
        // then
        assertTrue(exception.getMessage().contains("validation check"));
    }

    @Test
    @DisplayName("대여 정보가 조회되지 않을 경우")
    public void noRentInfo_ShouldNotPass() throws Exception {}

    @Test
    @DisplayName("잘못된 상태값이 들어온 경우")
    public void withWrongStatusParameter_ShouldNotPass() throws Exception {}

    @Test
    @DisplayName("RENTED로의 상태변경은 RETURNED일 때만 가능하다")
    public void withWrongRentStatus_ShouldNotPass() throws Exception {}


}