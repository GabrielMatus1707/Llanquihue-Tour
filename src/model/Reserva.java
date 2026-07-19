package model;

/**
 * Representa una reserva realizada por un Cliente sobre un PaqueteTuristico.
 * Aplica COMPOSICIÓN: una Reserva no puede existir sin un cliente y un
 * paquete asociados. Resuelve la problemática del caso sobre la gestión
 * manual de reservas (correo/WhatsApp) al modelarlas como objetos del
 * sistema, con control de cupo y trazabilidad de estado.
 *
 * Incluye SOBRECARGA de constructores: uno asume 1 persona por defecto,
 * el otro permite indicar explícitamente el número de personas.
 *
 * EFT - Semana 9.
 */
public class Reserva {

    private static int contadorId = 1;

    private final int id;
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private String fecha;
    private int numeroPersonas;
    private String estado; // CONFIRMADA, CANCELADA

    // Sobrecarga 1: número de personas por defecto (1)
    public Reserva(Cliente cliente, PaqueteTuristico paquete, String fecha) {
        this(cliente, paquete, fecha, 1);
    }

    // Sobrecarga 2: número de personas explícito
    public Reserva(Cliente cliente, PaqueteTuristico paquete, String fecha, int numeroPersonas) {
        this.id = contadorId++;
        setCliente(cliente);
        setPaquete(paquete);
        setFecha(fecha);
        setNumeroPersonas(numeroPersonas);
        this.estado = "CONFIRMADA";
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("La reserva debe tener un cliente asignado.");
        }
        this.cliente = cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException("La reserva debe tener un paquete turístico asignado.");
        }
        this.paquete = paquete;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if (fecha == null || fecha.isBlank()) {
            throw new IllegalArgumentException("La fecha de la reserva no puede estar vacía.");
        }
        this.fecha = fecha;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if (numeroPersonas <= 0) {
            throw new IllegalArgumentException("El número de personas debe ser mayor a 0.");
        }
        if (paquete != null && numeroPersonas > paquete.getCupoMaximo()) {
            throw new IllegalArgumentException("El número de personas (" + numeroPersonas +
                    ") supera el cupo máximo del paquete (" + paquete.getCupoMaximo() + ").");
        }
        this.numeroPersonas = numeroPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format(
            "[Reserva] ID: %d | Estado: %-10s | Fecha: %s%n" +
            "          Cliente : %s%n" +
            "          Paquete : %s (%d persona(s))",
            id, estado, fecha,
            cliente.getNombre() + " (" + cliente.getRut() + ")",
            paquete.getNombre(), numeroPersonas);
    }
}
