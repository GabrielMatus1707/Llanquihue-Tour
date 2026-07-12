package model;

/**
 * Subclase que representa una excursión cultural.
 * Hereda de ServicioTuristico y agrega el atributo lugarHistorico,
 * que indica el principal lugar de interés histórico que se visita.
 */
public class ExcursionCultural extends ServicioTuristico {

    // Atributo propio de esta subclase
    private String lugarHistorico;

    /**
     * Constructor que invoca al constructor de la superclase con super(...)
     * y asigna el atributo específico.
     * @param nombre          Nombre de la excursión.
     * @param duracionHoras   Duración en horas.
     * @param lugarHistorico  Nombre del lugar histórico o cultural principal.
     */
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);   // llamada al constructor de ServicioTuristico
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Sobrescribe toString() para mostrar todos los atributos,
     * incluyendo los heredados de ServicioTuristico.
     */
    @Override
    public String toString() {
        return "[Excursión Cultural]" +
               "\n  Nombre          : " + getNombre() +
               "\n  Duración        : " + getDuracionHoras() + " horas" +
               "\n  Lugar histórico : " + lugarHistorico;
    }
}
