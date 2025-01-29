package org.waveaway77.rentcar_admin.rent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Rent")
@NoArgsConstructor
@Entity
@Getter
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private int rentId;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "rent_start_dt")
    private LocalDateTime rentStartDt;

    @Column(name = "return_end_dt")
    private LocalDateTime returnEndDt;

    @Column(name = "status")
    private String status = "";

    @Builder
    public Rent(int rentId, int carId, int customerId, LocalDateTime rentStartDt, LocalDateTime returnEndDt, String status) {
        this.rentId = rentId;
        this.carId = carId;
        this.customerId = customerId;
        this.rentStartDt = rentStartDt;
        this.returnEndDt = returnEndDt;
        this.status = status;
    }
}
