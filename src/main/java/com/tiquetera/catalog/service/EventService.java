package com.tiquetera.catalog.service;

import com.tiquetera.catalog.dto.EventDTO;
import com.tiquetera.catalog.mapper.EventMapper;
import com.tiquetera.catalog.model.Event;
import com.tiquetera.catalog.repository.EventRepository;
import com.tiquetera.catalog.repository.VenueRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepo;
    private final VenueRepository venueRepo;

    public EventService(EventRepository eventRepo, VenueRepository venueRepo) {
        this.eventRepo = eventRepo;
        this.venueRepo = venueRepo;
    }

    public EventDTO create(EventDTO dto) {
        if (!venueRepo.findById(dto.getVenueId()).isPresent()) {
            throw new NoSuchElementException("Venue no encontrado para id " + dto.getVenueId());
        }
        Event saved = eventRepo.save(EventMapper.toDomain(dto));
        return EventMapper.toDto(saved);
    }

    public List<EventDTO> list() {
        return eventRepo.findAll().stream().map(EventMapper::toDto).collect(Collectors.toList());
    }

    public EventDTO getById(Long id) {
        Event e = eventRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Evento no encontrado"));
        return EventMapper.toDto(e);
    }

    public EventDTO update(Long id, EventDTO dto) {
        Event existing = eventRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Evento no encontrado"));
        dto.setId(existing.getId());
        if (!venueRepo.findById(dto.getVenueId()).isPresent()) {
            throw new NoSuchElementException("Venue no encontrado para id " + dto.getVenueId());
        }
        Event updated = eventRepo.save(EventMapper.toDomain(dto));
        return EventMapper.toDto(updated);
    }

    public void delete(Long id) {
        if (!eventRepo.findById(id).isPresent()) throw new NoSuchElementException("Evento no encontrado");
        eventRepo.deleteById(id);
    }
}
