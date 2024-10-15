package org.arle;

import org.arle.entity.Facultad;
import org.arle.service.FacultadService;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final FacultadService facultadService = new FacultadService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Facultades ---");
            System.out.println("1. Crear facultad");
            System.out.println("2. Leer facultad");
            System.out.println("3. Actualizar facultad");
            System.out.println("4. Eliminar facultad");
            System.out.println("5. Listar todas las facultades");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearFacultad();
                case 2 -> leerFacultad();
                case 3 -> actualizarFacultad();
                case 4 -> eliminarFacultad();
                case 5 -> listarFacultades();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        facultadService.cerrar();
        scanner.close();
    }

    private static void crearFacultad() {
        System.out.print("Nombre de la facultad: ");
        String nombre = scanner.nextLine();

        Facultad facultad = new Facultad();
        facultad.setNombre(nombre);

        facultadService.crearFacultad(facultad);
        System.out.println("Facultad creada con éxito");
    }

    private static void leerFacultad() {
        System.out.print("ID de la facultad: ");
        Long id = scanner.nextLong();
        Facultad facultad = facultadService.obtenerFacultad(id);
        if (facultad != null) {
            System.out.println(facultad);
        } else {
            System.out.println("Facultad no encontrada");
        }
    }

    private static void actualizarFacultad() {
        System.out.print("ID de la facultad a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Facultad facultad = facultadService.obtenerFacultad(id);
        if (facultad != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                facultad.setNombre(nombre);
            }

            facultadService.actualizarFacultad(facultad);
            System.out.println("Facultad actualizada con éxito");
        } else {
            System.out.println("Facultad no encontrada");
        }
    }

    private static void eliminarFacultad() {
        System.out.print("ID de la facultad a eliminar: ");
        Long id = scanner.nextLong();
        facultadService.eliminarFacultad(id);
        System.out.println("Facultad eliminada con éxito");
    }

    private static void listarFacultades() {
        List<Facultad> facultades = facultadService.obtenerTodasLasFacultades();
        if (facultades.isEmpty()) {
            System.out.println("No hay facultades registradas");
        } else {
            for (Facultad facultad : facultades) {
                System.out.println(facultad);
            }
        }
    }
}
