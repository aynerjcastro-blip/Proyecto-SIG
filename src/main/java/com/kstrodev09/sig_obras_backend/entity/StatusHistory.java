package com.kstrodev09.sig_obras_backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "status_history")

public class StatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado anterior del sitio de construcción no puede estar vacío")
    @Column(name = "previous_state", nullable = false)
    private ConstructionSiteState previousState;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado actual del sitio de construcción no puede estar vacío")
    @Column(name = "current_state", nullable = false)
    private ConstructionSiteState currentState;

    @NotNull(message = "La fecha de cambio no puede estar vacía")
    @Column(name = "change_date", nullable = false)
    private LocalDateTime changeDate;


    @Column(name = "observations")
    private String observations;


    @ManyToOne
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;
}
