package org.example.aplication.service;

import org.example.domain.Facultad;
import org.example.interfaces.FacultadRepository;

import java.util.List;

public class FacultadServiceImpl implements FacultadService {
    private final FacultadRepository facultadRepository;

    public FacultadServiceImpl(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    public List<Facultad> findAll() {
        return facultadRepository.findAll();
    }

    @Override
    public Facultad findById(int id) {
        return facultadRepository.findById(id);
    }

    @Override
    public void save(Facultad facultad) {
        validarFacultad(facultad);
        facultadRepository.save(facultad);
    }

    @Override
    public void update(Facultad facultad) {
        validarFacultad(facultad);
        facultadRepository.update(facultad);
    }

    @Override
    public void delete(int id) {
        facultadRepository.delete(id);
    }

    private void validarFacultad(Facultad facultad) {
        if (facultad.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la facultad no puede estar vacío");
        }
        if (facultad.getDireccion().isEmpty()) {
            throw new IllegalArgumentException("La direccion de la facultad no puede estar vacia");
        }
    }
}
