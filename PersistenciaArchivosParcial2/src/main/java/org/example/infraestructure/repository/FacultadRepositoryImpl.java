package org.example.infraestructure.repository;

import org.example.domain.Facultad;
import org.example.interfaces.FacultadRepository;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacultadRepositoryImpl implements FacultadRepository {
    private static final String FILE_NAME = "productos.dat";

    @Override
    public List<Facultad> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Facultad>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Facultad findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Facultad facultad) {
        List<Facultad> facultads = findAll();
        facultads.add(facultad);
        saveAll(facultads);
    }

    @Override
    public void update(Facultad facultad) {
        List<Facultad> facultads = findAll();
        facultads = facultads.stream()
                .map(f -> f.getId() == facultad.getId() ? facultad : f)
                .collect(Collectors.toList());
        saveAll(facultads);
    }

    @Override
    public void delete(int id) {
        List<Facultad> facultads = findAll();
        facultads = facultads.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(facultads);
    }

    private void saveAll(List<Facultad> facultads) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(facultads);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
