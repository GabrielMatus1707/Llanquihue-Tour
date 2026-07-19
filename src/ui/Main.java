package ui;

import data.GestorDatos;
import data.GestorReservas;
import data.GestorServicios;
import service.GestorTour;
import model.Cliente;
import model.Guia;
import model.Operador;
import model.PaqueteTuristico;
import model.ServicioTuristico;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase principal del sistema Llanquihue Tour.
 *
 * Semana 6: demuestra la jerarquía de herencia simple (ServicioTuristico).
 * Semana 8: agrega gestión de entidades (Registrable) vía GUI.
 * EFT (Semana 9): integra la carga de clientes desde archivo, con
 * excepciones personalizadas, y el registro de reservas usando ArrayList,
 * HashMap y Stack (GestorReservas), antes de abrir la interfaz gráfica.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      LLANQUIHUE TOUR - Sistema de Gestión        ║");
        System.out.println("║   EFT Semana 9 - Evaluación Final Transversal    ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // ── Carga de datos desde archivos .txt ──────────────────────────
        GestorDatos gestorDatos = new GestorDatos();
        System.out.println("\n--- Cargando datos desde archivos ---");
        ArrayList<Tour> tours             = gestorDatos.cargarTours("resources/tours.txt");
        ArrayList<Guia> guias             = gestorDatos.cargarGuias("resources/guias.txt");
        ArrayList<Operador> operadores    = gestorDatos.cargarOperadores("resources/operadores.txt");
        ArrayList<PaqueteTuristico> paquetes = gestorDatos.cargarPaquetes("resources/paquetes.txt", tours, guias, operadores);
        ArrayList<Cliente> clientes       = gestorDatos.cargarClientes("resources/clientes.txt");

        // ── Catálogo y filtros (Semana 5) ───────────────────────────────
        GestorTour gestorTour = new GestorTour(tours, guias, operadores, paquetes);
        gestorTour.mostrarTours();
        gestorTour.mostrarPaquetes();

        // ── Jerarquía de herencia de servicios turísticos (Semana 6) ────
        GestorServicios gestorServicios = new GestorServicios();
        ArrayList<ServicioTuristico> servicios = gestorServicios.crearServiciosDePrueba();
        System.out.println("\n===== LISTADO DE SERVICIOS TURÍSTICOS =====\n");
        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio);
            System.out.println("-------------------------------------------");
        }

        // ── Clientes y reservas: HashMap + ArrayList + Stack (EFT S9) ───
        GestorReservas gestorReservas = new GestorReservas();
        for (Cliente c : clientes) {
            gestorReservas.registrarCliente(c);
        }
        System.out.println("\n===== CLIENTES CARGADOS =====");
        for (Cliente c : clientes) System.out.println("  " + c);

        if (!clientes.isEmpty() && !paquetes.isEmpty()) {
            System.out.println("\n--- Registrando reservas de ejemplo ---");
            gestorReservas.registrarReserva(clientes.get(0), paquetes.get(0), "20-08-2026", 2);
            gestorReservas.registrarReserva(clientes.get(1), paquetes.get(1), "22-08-2026");
            gestorReservas.mostrarHistorial();
        }

        // ── Semana 8 / EFT: gestión interactiva de entidades vía GUI ────
        System.out.println("\nAbriendo gestión de entidades y reservas...");
        EntidadesGUI entidadesGUI = new EntidadesGUI(gestorReservas, paquetes);
        entidadesGUI.iniciar();

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║           Sistema finalizado con éxito.          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
