package com.tiquetera.catalog.service;

import com.tiquetera.catalog.dto.VenueDTO;
import com.tiquetera.catalog.mapper.VenueMapper;
import com.tiquetera.catalog.model.Venue;
import com.tiquetera.catalog.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class VenueService {

    private final VenueRepository venueRepo;

    public VenueService (VenueRepository venueRepo) {
        this.venueRepo = venueRepo;
    }

    public VenueDTO create(VenueDTO dto) {
        Venue v = VenueMapper.toDomain(dto);
        Venue saved = venueRepo.save(v);
        return VenueMapper.toDto(saved);
    }

    public List<VenueDTO> list() {
        return venueRepo.findAll().stream().map(VenueMapper::toDto).collect(Collectors.toList());
    }

    public VenueDTO getById(Long id) {
        Venue v = venueRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Venue no encontrado"));
        return VenueMapper.toDto(v);
    }

    public VenueDTO update(Long id, VenueDTO dto) {
        Venue existing = venueRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Venue no encontrado"));
        dto.setId(existing.getId());
        Venue updated = venueRepo.save(VenueMapper.toDomain(dto));
        return VenueMapper.toDto(updated);
    }

    public void delete(Long id) {
        if (!venueRepo.findById(id).isPresent()) throw new NoSuchElementException("Venue no encontrado");
        venueRepo.deleteById(id);
    }
}