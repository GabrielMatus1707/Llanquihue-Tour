package model;

/**
 * Superclase que representa un servicio turístico genérico de la agencia Llanquihue Tour.
 * Define los atributos comunes que comparten todos los tipos de servicio:
 * nombre y duracionHoras.
 *
 * Semana 6 - Herencia simple.
 */
public class ServicioTuristico {

    // Atributos comunes a todos los servicios
    private String nombre;
    private int duracionHoras;

    /**
     * Constructor de la superclase.
     * @param nombre        Nombre del servicio turístico.
     * @param duracionHoras Duración en horas del servicio.
     */
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Representación base del servicio. Las subclases deben sobrescribir este método
     * para incluir sus atributos propios.
     */
    @Override
    public String toString() {
        return "ServicioTuristico{nombre='" + nombre + "', duracionHoras=" + duracionHoras + "}";
    }
}
