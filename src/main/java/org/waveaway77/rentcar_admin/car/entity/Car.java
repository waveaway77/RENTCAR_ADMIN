package org.waveaway77.rentcar_admin.car.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Car")
@NoArgsConstructor
@Entity
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "category")
    private String category = "";

    @Column(name = "prod_year")
    private String prodYear = "";

    @Column(name = "company")
    private String company = "";

    @Column(name = "model")
    private String model = "";

    @Column(name = "status")
    private String status = "";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Car(int carId, String category, String prodYear, String company, String model, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.carId = carId;
        this.category = category;
        this.prodYear = prodYear;
        this.company = company;
        this.model = model;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
