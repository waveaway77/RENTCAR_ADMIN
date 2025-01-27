package org.waveaway77.rentcar_admin.company.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Company")
@NoArgsConstructor
@Entity
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    @Builder
    public Company(int companyId, String code, String value) {
        this.companyId = companyId;
        this.code = code;
        this.value = value;
    }
}
