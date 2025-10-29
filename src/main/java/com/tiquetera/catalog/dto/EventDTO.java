package com.tiquetera.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "EventDTO", description = "Representación de un evento")
public class EventDTO {
    @Schema(description = "Identificador del evento", example = "1")
    private Long id;

    @NotBlank(message = "El nombre del evento no puede estar vacío")
    @Schema(description = "Nombre del evento", example = "Concierto Pop", required = true)
    private String name;

    @Schema(description = "Descripción del evento", example = "Gira 2026")
    private String description;

    @NotNull(message = "El id del venue es obligatorio")
    @Schema(description = "Id del venue asociado", example = "1", required = true)
    private Long venueId;

    @Schema(description = "Fecha y hora ISO-8601", example = "2026-03-10T20:00:00")
    private String date;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getVenueId() { return venueId; }
    public void setVenueId(Long venueId) { this.venueId = venueId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
