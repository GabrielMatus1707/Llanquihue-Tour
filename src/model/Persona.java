package model;

/**
 * Clase base abstracta para las entidades del sistema que representan
 * personas (guías turísticos, colaboradores externos, etc.).
 * Concentra los atributos comunes: nombre y teléfono de contacto,
 * aplicando herencia entre las nuevas entidades de la Semana 8.
 */
public abstract class Persona {

    protected String nombre;
    protected String telefono;

    public Persona(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank())
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        this.telefono = telefono;
    }
}
