package org.example.interfaces;

import org.example.domain.Facultad;

import java.util.List;

public interface FacultadRepository {
    List<Facultad> findAll();
    Facultad findById(int id);
    void save(Facultad facultad);
    void update(Facultad facultad);
    void delete(int id);
}