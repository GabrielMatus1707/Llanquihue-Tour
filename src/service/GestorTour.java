package service;

import model.Guia;
import model.Operador;
import model.PaqueteTuristico;
import model.Tour;

import java.util.ArrayList;

/**
 * Clase de servicio que gestiona las operaciones sobre las colecciones:
 * mostrar registros, búsquedas y filtros.
 * Paquete nuevo agregado en Semana 5.
 */
public class GestorTour {

    private ArrayList<Tour> tours;
    private ArrayList<Guia> guias;
    private ArrayList<Operador> operadores;
    private ArrayList<PaqueteTuristico> paquetes;

    public GestorTour(ArrayList<Tour> tours, ArrayList<Guia> guias,
                      ArrayList<Operador> operadores, ArrayList<PaqueteTuristico> paquetes) {
        this.tours      = tours;
        this.guias      = guias;
        this.operadores = operadores;
        this.paquetes   = paquetes;
    }

    // ── Mostrar todos ──────────────────────────────────────────────────
    public void mostrarTours() {
        System.out.println("\n===== CATÁLOGO COMPLETO DE TOURS =====");
        if (tours.isEmpty()) { System.out.println("  No hay tours registrados."); return; }
        for (Tour t : tours) System.out.println("  " + t);
    }

    public void mostrarGuias() {
        System.out.println("\n===== GUÍAS TURÍSTICOS =====");
        if (guias.isEmpty()) { System.out.println("  No hay guías registrados."); return; }
        for (Guia g : guias) System.out.println("  " + g);
    }

    public void mostrarOperadores() {
        System.out.println("\n===== OPERADORES =====");
        if (operadores.isEmpty()) { System.out.println("  No hay operadores registrados."); return; }
        for (Operador o : operadores) System.out.println("  " + o);
    }

    public void mostrarPaquetes() {
        System.out.println("\n===== PAQUETES TURÍSTICOS =====");
        if (paquetes.isEmpty()) { System.out.println("  No hay paquetes registrados."); return; }
        for (PaqueteTuristico p : paquetes) System.out.println("  " + p + "\n");
    }

    // ── Filtros (extendidos de Semana 3) ───────────────────────────────
    public void filtrarToursPorTipo(String tipo) {
        System.out.println("\n>> Tours de tipo \"" + tipo + "\":");
        boolean encontrado = false;
        for (Tour t : tours) {
            if (t.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println("  " + t);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("  No se encontraron tours de ese tipo.");
    }

    public void filtrarToursPorPrecioMayor(int precio) {
        System.out.println("\n>> Tours con precio mayor a $" + String.format("%,d", precio) + ":");
        boolean encontrado = false;
        for (Tour t : tours) {
            if (t.getPrecio() > precio) {
                System.out.println("  " + t);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("  No se encontraron tours con ese precio.");
    }

    public void filtrarGuiasPorExperiencia(int aniosMinimos) {
        System.out.println("\n>> Guías con experiencia ≥ " + aniosMinimos + " años:");
        boolean encontrado = false;
        for (Guia g : guias) {
            if (g.getExperienciaAnios() >= aniosMinimos) {
                System.out.println("  " + g);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("  No hay guías con esa experiencia.");
    }

    // ── Búsqueda por nombre ────────────────────────────────────────────
    public void buscarTourPorNombre(String texto) {
        System.out.println("\n>> Búsqueda de tour: \"" + texto + "\"");
        boolean encontrado = false;
        for (Tour t : tours) {
            if (t.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                System.out.println("  " + t);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("  No se encontró ningún tour con ese nombre.");
    }
}
