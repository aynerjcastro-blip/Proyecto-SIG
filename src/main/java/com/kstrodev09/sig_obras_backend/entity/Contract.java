package com.kstrodev09.sig_obras_backend.entity;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")

public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número del contrato no puede estar vacío")
    @Column(name = "contract_number", nullable = false, unique = true)
    private String  contractNumber;

    @NotBlank(message = "El contratista del contrato no puede estar vacío")
    @Column(name = "contractor", nullable = false)
    private String contractor;

    @NotNull(message = "El valor del contrato no puede estar vacío")
    @Column(name = "value", nullable = false, precision = 15, scale = 2)
    private BigDecimal value;

    @NotNull(message = "La fecha de inicio del contrato no puede estar vacía")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    /*
        *Relación con la entidad ConstructionSite de Muchos a uno
    */
    @ManyToOne
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;

}
