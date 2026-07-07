package com.kstrodev09.sig_obras_backend.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "municipalities")

/**
 * * Esta clase representa la entidad "Municipality" que se mapeará a la tabla
 * *"municipalities" en la base de datos.
 * *(@NoArgsConstructor) es una anotación de Lombok que genera automáticamente
 * *un constructor sin argumentos para la clase.
 * *(@AllArgsConstructor) es una anotación de Lombok que genera automáticamente
 * *un constructor
 * *con argumentos para todos los campos de la clase.
 * *(@Entity) es una anotación de JPA que indica que la clase es una entidad que
 * *se mapeará a una tabla en la base de datos.
 * *(@Table) es una anotación de JPA que se utiliza para especificar el nombre
 * *de la tabla en la base de datos a la que se mapeará la entidad.
 * *(@Id) es una anotación de JPA que indica que el campo es la clave primaria
 * *de la entidad.
 * *(@GeneratedValue) es una anotación de JPA que se utiliza para especificar
 * *cómo se generará el valor de la clave primaria.
 * *En este caso, se utiliza la estrategia de generación de identidad
 * *(IDENTITY), lo que significa que el valor se generará automáticamente por la
 * *base de datos.
 * *(@Column) es una anotación de JPA que se utiliza para especificar el nombre
 * *de la columna en la tabla de la base de datos a la que se mapeará el campo.
 * *También se puede utilizar para especificar si la columna puede ser nula o
 * *no.
 * *Definimos la stagegy para generar la primary key de la entidad, en este
 * *caso se genera un valor incremental para el id.
 */
public class Municipality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "El nombre del municipio no puede estar vacío")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "El departamento del municipio no puede estar vacío")
    @Column(name = "department", nullable = false)
    private String department;

    @NotBlank(message = "El codigo DANE del municipio no puede estar vacío")
    @Column(name = "dane_code", nullable = false, unique = true)
    private String daneCode;
}
