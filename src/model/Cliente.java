package model;

import exception.RutInvalidoException;

/**
 * Representa a un cliente de la agencia Llanquihue Tour. Hereda los
 * atributos comunes de Persona (nombre, telefono) e implementa Registrable
 * para integrarse a la colección polimórfica de entidades del sistema.
 *
 * Resuelve directamente una de las problemáticas del caso: la ausencia de
 * categorización formal de clientes dentro del sistema. Aplica composición
 * con la clase Rut, cuya validación puede lanzar RutInvalidoException.
 *
 * EFT - Semana 9.
 */
public class Cliente extends Persona implements Registrable {

    private Rut rut;      // composición: un Cliente tiene un Rut válido
    private String email;

    public Cliente(String nombre, String telefono, String rutTexto, String email) throws RutInvalidoException {
        super(nombre, telefono);
        this.rut = new Rut(rutTexto);
        setEmail(email);
    }

    public Rut getRut() {
        return rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || email.isBlank()) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.email = email;
    }

    @Override
    public String mostrarResumen() {
        return "[Cliente] " + nombre +
               " | RUT: " + rut +
               " | Email: " + email +
               " | Tel: " + telefono;
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
