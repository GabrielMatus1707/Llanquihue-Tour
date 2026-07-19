package data;

import model.Cliente;
import model.PaqueteTuristico;
import model.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Gestiona clientes y reservas del sistema Llanquihue Tour.
 *
 * Usa tres estructuras de datos distintas, cada una elegida por el
 * problema que resuelve:
 *  - HashMap<String, Cliente>: búsqueda de un cliente por RUT en O(1),
 *    evitando la duplicación de registros de clientes.
 *  - ArrayList<Reserva>: historial completo de reservas, en orden de
 *    creación, para recorrer y filtrar.
 *  - Stack<Reserva>: pila de las últimas reservas realizadas, que permite
 *    "deshacer" (cancelar) la última reserva ingresada — como ocurre en
 *    la operación real de la agencia cuando una reserva se toma por error.
 *
 * EFT - Semana 9.
 */
public class GestorReservas {

    private final HashMap<String, Cliente> clientesPorRut = new HashMap<>();
    private final ArrayList<Reserva> historial = new ArrayList<>();
    private final Stack<Reserva> ultimasReservas = new Stack<>();

    // ── Clientes ──────────────────────────────────────────────────────
    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        clientesPorRut.put(cliente.getRut().getNumero(), cliente);
    }

    public Cliente buscarClientePorRut(String rutNumero) {
        return clientesPorRut.get(rutNumero);
    }

    public ArrayList<Cliente> getClientes() {
        return new ArrayList<>(clientesPorRut.values());
    }

    // ── Reservas (sobrecarga: con y sin número de personas) ────────────
    public Reserva registrarReserva(Cliente cliente, PaqueteTuristico paquete, String fecha) {
        return registrarReserva(cliente, paquete, fecha, 1);
    }

    public Reserva registrarReserva(Cliente cliente, PaqueteTuristico paquete, String fecha, int numeroPersonas) {
        Reserva reserva = new Reserva(cliente, paquete, fecha, numeroPersonas);
        historial.add(reserva);
        ultimasReservas.push(reserva);
        return reserva;
    }

    /** Cancela (deshace) la última reserva ingresada, usando la pila. */
    public Reserva cancelarUltimaReserva() {
        if (ultimasReservas.isEmpty()) {
            System.out.println("  No hay reservas recientes para cancelar.");
            return null;
        }
        Reserva cancelada = ultimasReservas.pop();
        cancelada.setEstado("CANCELADA");
        System.out.println("  ✔ Reserva ID " + cancelada.getId() + " cancelada.");
        return cancelada;
    }

    public void mostrarHistorial() {
        System.out.println("\n===== HISTORIAL DE RESERVAS =====");
        if (historial.isEmpty()) {
            System.out.println("  No hay reservas registradas.");
            return;
        }
        for (Reserva r : historial) {
            System.out.println("  " + r);
        }
    }

    public void filtrarPorEstado(String estado) {
        System.out.println("\n>> Reservas en estado \"" + estado + "\":");
        boolean encontrado = false;
        for (Reserva r : historial) {
            if (r.getEstado().equalsIgnoreCase(estado)) {
                System.out.println("  " + r);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("  No hay reservas en ese estado.");
    }

    public ArrayList<Reserva> getHistorial() {
        return historial;
    }
}
