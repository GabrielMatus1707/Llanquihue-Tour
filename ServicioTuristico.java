package model;

/**
 * Subclase que representa un paseo lacustre.
 * Hereda de ServicioTuristico y agrega el atributo tipoEmbarcacion,
 * que indica qué tipo de embarcación se utiliza en el paseo.
 */
public class PaseoLacustre extends ServicioTuristico {

    // Atributo propio de esta subclase
    private String tipoEmbarcacion;

    /**
     * Constructor que invoca al constructor de la superclase con super(...)
     * y asigna el atributo específico.
     * @param nombre           Nombre del paseo.
     * @param duracionHoras    Duración en horas.
     * @param tipoEmbarcacion  Tipo de embarcación utilizada (ej: catamarán, kayak, lancha).
     */
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);   // llamada al constructor de ServicioTuristico
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Sobrescribe toString() para mostrar todos los atributos,
     * incluyendo los heredados de ServicioTuristico.
     */
    @Override
    public String toString() {
        return "[Paseo Lacustre]" +
               "\n  Nombre          : " + getNombre() +
               "\n  Duración        : " + getDuracionHoras() + " horas" +
               "\n  Tipo embarcación: " + tipoEmbarcacion;
    }
}
