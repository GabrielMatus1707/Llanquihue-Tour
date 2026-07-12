package model;

/**
 * Interfaz que define el contrato de comportamiento común para todas las
 * entidades gestionables del sistema Llanquihue Tour (guías, vehículos,
 * colaboradores externos, etc.). Cualquier clase que la implemente puede
 * ser tratada de forma unificada dentro de una colección polimórfica.
 *
 * Semana 8 - Interfaces y polimorfismo.
 */
public interface Registrable {

    /**
     * Retorna un resumen legible de la entidad, con el formato propio
     * de cada clase que implemente esta interfaz.
     */
    String mostrarResumen();
}
