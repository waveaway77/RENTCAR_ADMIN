package org.waveaway77.rentcar_admin.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Model")
@NoArgsConstructor
@Entity
@Getter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelId;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    @Builder
    public Model(int modelId, String code, String value) {
        this.modelId = modelId;
        this.code = code;
        this.value = value;
    }
}
