package org.example.aplication.service;

import org.example.domain.Facultad;

import java.util.List;

public interface FacultadService {
    List<Facultad> findAll();
    Facultad findById(int id);
    void save(Facultad facultad);
    void update(Facultad facultad);
    void delete(int id);
}