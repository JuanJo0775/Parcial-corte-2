package org.arle.service;

import org.arle.entity.Facultad;
import org.arle.repository.FacultadRepository;

import java.util.List;

public class FacultadService {

    private final FacultadRepository repository;

    public FacultadService() {
        this.repository = new FacultadRepository();
    }

    public void crearFacultad(Facultad facultad) {
        repository.crear(facultad);
    }

    public Facultad obtenerFacultad(Long id) {
        return repository.leer(id);
    }

    public List<Facultad> obtenerTodasLasFacultades() {
        return repository.leerTodas();
    }

    public void actualizarFacultad(Facultad facultad) {
        repository.actualizar(facultad);
    }

    public void eliminarFacultad(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
