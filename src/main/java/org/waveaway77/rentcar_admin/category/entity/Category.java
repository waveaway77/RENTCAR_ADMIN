package org.waveaway77.rentcar_admin.category.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Category")
@NoArgsConstructor
@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "code")
    private String code = "";

    @Column(name = "value")
    private String value = "";

    @Builder
    public Category(int categoryId, String code, String value) {
        this.categoryId = categoryId;
        this.code = code;
        this.value = value;
    }
}
