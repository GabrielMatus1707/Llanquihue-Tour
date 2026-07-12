package model;

/**
 * Representa un vehículo utilizado por la agencia para trasladar a los
 * turistas (van, bus, lancha, etc.). No es una Persona, por lo que
 * implementa Registrable de forma directa, demostrando que el contrato
 * de comportamiento común aplica también a entidades de otra naturaleza.
 *
 * Semana 8 - Interfaces y polimorfismo.
 */
public class Vehiculo implements Registrable {

    private String patente;
    private String tipo;
    private int capacidad;

    public Vehiculo(String patente, String tipo, int capacidad) {
        setPatente(patente);
        setTipo(tipo);
        setCapacidad(capacidad);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.isBlank())
            throw new IllegalArgumentException("La patente no puede estar vacía.");
        this.patente = patente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank())
            throw new IllegalArgumentException("El tipo de vehículo no puede estar vacío.");
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0)
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        this.capacidad = capacidad;
    }

    @Override
    public String mostrarResumen() {
        return "[Vehículo] Patente: " + patente +
               " | Tipo: " + tipo +
               " | Capacidad: " + capacidad + " pasajeros";
    }
}
