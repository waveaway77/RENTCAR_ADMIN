package org.waveaway77.rentcar_admin.car.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.waveaway77.rentcar_admin.car.entity.Car;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FixCarRequest {
    private int carId;
    private String category = "";
    private String prodYear = "";
    private String company = "";
    private String model = "";
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Car saveCar(int carId, String category, String prodYear, String company, String model) {
        return  Car.builder()
                .carId(carId)
                .category(category)
                .prodYear(prodYear)
                .company(company)
                .model(model)
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
