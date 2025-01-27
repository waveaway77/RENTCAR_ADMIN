package org.waveaway77.rentcar_admin.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Customer")
@NoArgsConstructor
@Entity
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name")
    private String name = "";

    @Column(name = "phone_no")
    private String phoneNo = "";

    @Column(name = "emergency_phone_no")
    private String emergencyPhoneNo = "";

    @Column(name = "status")
    private String status = "";
}
