package ui;

import data.GestorDatos;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase principal del sistema de gestión de tours de Llanquihue Tour.
 * Carga los tours desde un archivo, los recorre y filtra según condiciones.
 */
public class Main {

    public static void main(String[] args) {

        // --- Paso 1: Cargar los datos desde el archivo ---
        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours("resources/tours.txt");

        // --- Paso 2: Recorrido - mostrar todos los tours ---
        System.out.println("===== CATÁLOGO COMPLETO DE TOURS =====");
        for (Tour tour : tours) {
            System.out.println(tour);
        }

        // --- Paso 3: Filtrado por tipo "cultural" ---
        System.out.println("\n===== TOURS CULTURALES =====");
        ArrayList<Tour> toursCulturales = new ArrayList<>();

        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase("cultural")) {
                toursCulturales.add(tour);
            }
        }

        // Mostrar resultados del filtro por tipo
        if (toursCulturales.isEmpty()) {
            System.out.println("No se encontraron tours culturales.");
        } else {
            for (Tour tour : toursCulturales) {
                System.out.println(tour);
            }
        }

        // --- Paso 4: Filtrado por precio mayor a 40000 ---
        System.out.println("\n===== TOURS CON PRECIO MAYOR A $40.000 =====");
        ArrayList<Tour> toursPremium = new ArrayList<>();

        for (Tour tour : tours) {
            if (tour.getPrecio() > 40000) {
                toursPremium.add(tour);
            }
        }

        // Mostrar resultados del filtro por precio
        if (toursPremium.isEmpty()) {
            System.out.println("No se encontraron tours con ese precio.");
        } else {
            for (Tour tour : toursPremium) {
                System.out.println(tour);
            }
        }

        System.out.println("\n===== FIN DEL SISTEMA =====");
    }
}
