package com.tiquetera.catalog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "VenueDTO", description = "Representación de un venue")
public class VenueDTO {
    @Schema(description = "Identificador del venue", example = "1")
    private Long id;

    @NotBlank(message = "El nombre del venue no puede estar vacío")
    @Schema(description = "Nombre del venue", example = "Estadio Central", required = true)
    private String name;

    @Schema(description = "Dirección del venue", example = "Av 1 #2-3")
    private String address;

    @Min(value = 0, message = "La capacidad no puede ser negativa")
    @Schema(description = "Capacidad del venue", example = "20000")
    private Integer capacity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
