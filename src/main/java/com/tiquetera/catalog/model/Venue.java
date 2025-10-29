package com.tiquetera.catalog.model;

public class Venue {
    private Long id;
    private String name;
    private String address;
    private Integer capacity;

    public Venue(Long id, String name, String address, Integer capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        validateInvariant();
    }

    private void validateInvariant() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("El nombre del venue no puede estar vacío");
        if (capacity != null && capacity < 0) throw new IllegalArgumentException("Capacity no puede ser negativa");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
