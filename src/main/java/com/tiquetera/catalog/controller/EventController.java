package com.tiquetera.catalog.controller;

import com.tiquetera.catalog.dto.EventDTO;
import com.tiquetera.catalog.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) { this.service = service; }

    @Operation(summary = "Crear evento", description = "Crea un nuevo evento asociado a un venue existente")
    @ApiResponse(responseCode = "201", description = "Evento creado")
    @PostMapping
    public ResponseEntity<EventDTO> create(@Valid @RequestBody EventDTO dto) {
        EventDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/events/" + created.getId())).body(created);
    }

    @Operation(summary = "Listar eventos")
    @ApiResponse(responseCode = "200", description = "Lista de eventos")
    @GetMapping
    public ResponseEntity<List<EventDTO>> list() { return ResponseEntity.ok(service.list()); }

    @Operation(summary = "Obtener evento por id")
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> get(@PathVariable Long id) { return ResponseEntity.ok(service.getById(id)); }

    @Operation(summary = "Actualizar evento")
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @Valid @RequestBody EventDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Eliminar evento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
