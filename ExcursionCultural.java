package model;

/**
 * Subclase que representa una ruta gastronómica.
 * Hereda de ServicioTuristico y agrega el atributo numeroDeParadas,
 * que indica cuántas paradas gastronómicas incluye el recorrido.
 */
public class RutaGastronomica extends ServicioTuristico {

    // Atributo propio de esta subclase
    private int numeroDeParadas;

    /**
     * Constructor que invoca al constructor de la superclase con super(...)
     * y asigna el atributo específico.
     * @param nombre          Nombre de la ruta.
     * @param duracionHoras   Duración en horas.
     * @param numeroDeParadas Número de paradas gastronómicas del recorrido.
     */
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);   // llamada al constructor de ServicioTuristico
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Sobrescribe toString() para mostrar todos los atributos,
     * incluyendo los heredados de ServicioTuristico.
     */
    @Override
    public String toString() {
        return "[Ruta Gastronómica]" +
               "\n  Nombre          : " + getNombre() +
               "\n  Duración        : " + getDuracionHoras() + " horas" +
               "\n  N° de paradas   : " + numeroDeParadas;
    }
}
