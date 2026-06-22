package ui;

import data.GestorDatos;
import model.Guia;
import model.Operador;
import model.PaqueteTuristico;
import model.Tour;
import service.GestorTour;

import java.util.ArrayList;

/**
 * Clase principal del sistema de gestión de Llanquihue Tour.
 * Semana 5: se amplió con nuevas entidades, paquete service y composición.
 * Se mantiene la lógica original de Semana 3 (filtros por tipo y precio).
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║      LLANQUIHUE TOUR - Sistema de Gestión    ║");
        System.out.println("║               Versión Semana 5               ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("\nCargando datos desde archivos...\n");

        // --- Carga de datos desde archivos --------------------------------
        GestorDatos gestor = new GestorDatos();

        ArrayList<Tour>             tours      = gestor.cargarTours("resources/tours.txt");
        ArrayList<Guia>             guias      = gestor.cargarGuias("resources/guias.txt");
        ArrayList<Operador>         operadores = gestor.cargarOperadores("resources/operadores.txt");
        ArrayList<PaqueteTuristico> paquetes   = gestor.cargarPaquetes("resources/paquetes.txt",
                                                                        tours, guias, operadores);

        // --- Gestor de operaciones ----------------------------------------
        GestorTour gestorTour = new GestorTour(tours, guias, operadores, paquetes);

        // --- Paso 1: Mostrar todos los registros --------------------------
        gestorTour.mostrarTours();
        gestorTour.mostrarGuias();
        gestorTour.mostrarOperadores();
        gestorTour.mostrarPaquetes();

        // --- Paso 2: Filtros (continuación desde Semana 3) ----------------
        System.out.println("\n══════════════ FILTROS ══════════════");
        gestorTour.filtrarToursPorTipo("cultural");
        gestorTour.filtrarToursPorPrecioMayor(40000);
        gestorTour.filtrarGuiasPorExperiencia(5);

        // --- Paso 3: Búsqueda por nombre ----------------------------------
        System.out.println("\n══════════════ BÚSQUEDAS ══════════════");
        gestorTour.buscarTourPorNombre("Lago");

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║          Sistema finalizado con éxito.       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}
