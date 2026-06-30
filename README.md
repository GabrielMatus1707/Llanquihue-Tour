package ui;

import data.GestorServicios;
import model.ServicioTuristico;

import java.util.ArrayList;

/**
 * Clase principal del sistema Llanquihue Tour.
 * Semana 6: demuestra la jerarquía de herencia simple.
 * Llama a GestorServicios para obtener instancias de prueba
 * y las muestra por consola usando toString().
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      LLANQUIHUE TOUR - Servicios Turísticos      ║");
        System.out.println("║          Semana 6 - Herencia Simple              ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Crear instancias de prueba desde GestorServicios
        GestorServicios gestor = new GestorServicios();
        ArrayList<ServicioTuristico> servicios = gestor.crearServiciosDePrueba();

        // Mostrar cada servicio usando su toString() sobrescrito
        System.out.println("\n===== LISTADO DE SERVICIOS TURÍSTICOS =====\n");
        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio);
            System.out.println("-------------------------------------------");
        }

        System.out.println("\nTotal de servicios registrados: " + servicios.size());
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║           Sistema finalizado con éxito.          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
