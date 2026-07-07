package com.kstrodev09.sig_obras_backend.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.locationtech.jts.geom.Point;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "construction_sites")

public class ConstructionSite implements Serializable {
    /*
        *Relación con la entidad Municipality de Muchos a uno
    */
    @ManyToOne
    @JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del sitio de construcción no puede estar vacío")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "La dirección del sitio de construcción no puede estar vacía")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "La descripción del sitio de construcción no puede estar vacía")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "La ubicación del sitio de construcción no puede estar vacía")
    @Column(name = "ubication", columnDefinition = "geometry(Point, 4326)", nullable = false)
    private Point ubication;

    @NotNull(message = "La fecha de inicio del sitio de construcción no puede estar vacía")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ConstructionSiteState state;

}
