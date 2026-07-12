package model;

/**
 * Representa a un guía turístico de la agencia. Hereda los atributos
 * comunes de Persona e implementa Registrable para integrarse a la
 * colección polimórfica del sistema.
 *
 * Semana 8 - Interfaces, herencia y polimorfismo.
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String especialidad;
    private int experienciaAnios;

    public GuiaTuristico(String nombre, String telefono, String especialidad, int experienciaAnios) {
        super(nombre, telefono);
        setEspecialidad(especialidad);
        setExperienciaAnios(experienciaAnios);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank())
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        this.especialidad = especialidad;
    }

    public int getExperienciaAnios() {
        return experienciaAnios;
    }

    public void setExperienciaAnios(int experienciaAnios) {
        if (experienciaAnios < 0)
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos.");
        this.experienciaAnios = experienciaAnios;
    }

    @Override
    public String mostrarResumen() {
        return "[Guía Turístico] " + nombre +
               " | Especialidad: " + especialidad +
               " | Experiencia: " + experienciaAnios + " años" +
               " | Tel: " + telefono;
    }
}
