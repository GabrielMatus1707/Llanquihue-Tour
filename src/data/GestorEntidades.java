package data;

import model.Cliente;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

/**
 * Gestiona la colección polimórfica de entidades registrables del sistema
 * (guías, vehículos, colaboradores externos, etc.). Recorre la colección
 * diferenciando el tipo específico de cada objeto mediante instanceof,
 * para aplicar lógica particular cuando corresponde.
 *
 * Semana 8 - Colecciones genéricas, polimorfismo y validación de tipos.
 */
public class GestorEntidades {

    private ArrayList<Registrable> entidades = new ArrayList<>();

    public void agregar(Registrable entidad) {
        if (entidad == null)
            throw new IllegalArgumentException("La entidad no puede ser nula.");
        entidades.add(entidad);
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Recorre la colección con for-each y muestra el resumen de cada
     * entidad por consola. Usa instanceof para identificar el tipo
     * concreto y llevar un conteo diferenciado por categoría.
     */
    public void mostrarTodas() {
        System.out.println("\n===== ENTIDADES REGISTRADAS =====");
        if (entidades.isEmpty()) {
            System.out.println("  No hay entidades registradas.");
            return;
        }

        int guias = 0, vehiculos = 0, colaboradores = 0, clientes = 0, otros = 0;

        for (Registrable entidad : entidades) {
            System.out.println("  " + entidad.mostrarResumen());

            if (entidad instanceof GuiaTuristico) {
                guias++;
            } else if (entidad instanceof Vehiculo) {
                vehiculos++;
            } else if (entidad instanceof ColaboradorExterno) {
                colaboradores++;
            } else if (entidad instanceof Cliente) {
                clientes++;
            } else {
                otros++;
            }
        }

        System.out.println("\n  Total entidades    : " + entidades.size());
        System.out.println("  Guías turísticos   : " + guias);
        System.out.println("  Vehículos          : " + vehiculos);
        System.out.println("  Colaboradores ext. : " + colaboradores);
        System.out.println("  Clientes           : " + clientes);
        if (otros > 0) System.out.println("  Otros              : " + otros);
    }

    /**
     * Retorna un String con el resumen de todas las entidades, pensado
     * para mostrarse en un cuadro de diálogo de la interfaz gráfica.
     */
    public String resumenComoTexto() {
        if (entidades.isEmpty()) {
            return "No hay entidades registradas todavía.";
        }
        StringBuilder sb = new StringBuilder();
        for (Registrable entidad : entidades) {
            sb.append(entidad.mostrarResumen()).append("\n\n");
        }
        return sb.toString();
    }
}
