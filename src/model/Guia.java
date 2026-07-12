package model;

/**
 * Clase que representa a un guía turístico de la agencia.
 */
public class Guia {

    private int id;
    private String nombre;
    private String especialidad;
    private String telefono;
    private int experienciaAnios;

    public Guia(int id, String nombre, String especialidad, String telefono, int experienciaAnios) {
        this.id = id;
        setNombre(nombre);
        setEspecialidad(especialidad);
        setTelefono(telefono);
        setExperienciaAnios(experienciaAnios);
    }

    public int getId()                  { return id; }
    public String getNombre()           { return nombre; }
    public String getEspecialidad()     { return especialidad; }
    public String getTelefono()         { return telefono; }
    public int getExperienciaAnios()    { return experienciaAnios; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del guía no puede estar vacío.");
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank())
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        this.especialidad = especialidad;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank())
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        this.telefono = telefono;
    }

    public void setExperienciaAnios(int anios) {
        if (anios < 0)
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos.");
        this.experienciaAnios = anios;
    }

    @Override
    public String toString() {
        return String.format("[Guía] ID: %d | %-22s | Especialidad: %-25s | Tel: %s | Exp: %d años",
                id, nombre, especialidad, telefono, experienciaAnios);
    }
}
