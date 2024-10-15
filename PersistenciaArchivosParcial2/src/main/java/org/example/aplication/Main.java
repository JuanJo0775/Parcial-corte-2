package org.example.aplication;

import org.example.aplication.service.FacultadService;
import org.example.aplication.service.FacultadServiceImpl;
import org.example.domain.Facultad;
import org.example.infraestructure.repository.FacultadRepositoryImpl;
import org.example.interfaces.FacultadRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FacultadService facultadService;

    static {
        FacultadRepository facultadRepository = new FacultadRepositoryImpl();
        facultadService = new FacultadServiceImpl(facultadRepository);
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Listar facultades");
            System.out.println("2. Crear facultad");
            System.out.println("3. Actualizar facultad");
            System.out.println("4. Eliminar facultad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarFacultades();
                    break;
                case 2:
                    crearFacultad();
                    break;
                case 3:
                    actualizarFacultad();
                    break;
                case 4:
                    eliminarFacultad();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void listarFacultades() {
        List<Facultad> facultades = facultadService.findAll();
        if (facultades.isEmpty()) {
            System.out.println("No hay facultades registradas.");
        } else {
            System.out.println("Listado de facultades:");
            for (Facultad facultad : facultades) {
                System.out.println(facultad);
            }
        }
    }

    private static void crearFacultad() {
        System.out.print("Ingrese el ID de la facultad: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el nombre de la facultad: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la dirección de la facultad: ");
        String direccion = scanner.nextLine();

        Facultad facultad = new Facultad();
        facultad.setId(id);
        facultad.setNombre(nombre);
        facultad.setDireccion(direccion);

        try {
            facultadService.save(facultad);
            System.out.println("Facultad creada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarFacultad() {
        System.out.print("Ingrese el ID de la facultad a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Facultad facultad = facultadService.findById(id);
        if (facultad == null) {
            System.out.println("No se encontró la facultad con ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre de la facultad (dejar en blanco para no cambiar): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            facultad.setNombre(nombre);
        }

        System.out.print("Ingrese la nueva dirección de la facultad (dejar en blanco para no cambiar): ");
        String direccion = scanner.nextLine();
        if (!direccion.isEmpty()) {
            facultad.setDireccion(direccion);
        }

        try {
            facultadService.update(facultad);
            System.out.println("Facultad actualizada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarFacultad() {
        System.out.print("Ingrese el ID de la facultad a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Facultad facultad = facultadService.findById(id);
        if (facultad == null) {
            System.out.println("No se encontró la facultad con ID " + id);
            return;
        }

        facultadService.delete(id);
        System.out.println("Facultad eliminada exitosamente.");
    }
}
