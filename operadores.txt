package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;

/**
 * Clase encargada de crear instancias de prueba de los servicios turísticos.
 * Crea al menos dos objetos de cada subclase de ServicioTuristico.
 *
 * Semana 6 - Herencia simple.
 */
public class GestorServicios {

    /**
     * Crea y retorna una lista con instancias de prueba de las tres subclases.
     * Se usa ServicioTuristico como tipo de referencia para demostrar polimorfismo.
     */
    public ArrayList<ServicioTuristico> crearServiciosDePrueba() {

        ArrayList<ServicioTuristico> servicios = new ArrayList<>();

        // --- Rutas Gastronómicas (2 instancias) ---
        servicios.add(new RutaGastronomica("Ruta Gastronómica del Lago", 3, 5));
        servicios.add(new RutaGastronomica("Ruta de la Cerveza Artesanal", 2, 4));

        // --- Paseos Lacustres (2 instancias) ---
        servicios.add(new PaseoLacustre("Paseo Lacustre Llanquihue", 4, "Catamarán"));
        servicios.add(new PaseoLacustre("Kayak en Lago Todos los Santos", 3, "Kayak doble"));

        // --- Excursiones Culturales (2 instancias) ---
        servicios.add(new ExcursionCultural("Tour Cultural Frutillar", 2, "Teatro del Lago"));
        servicios.add(new ExcursionCultural("Excursión Histórica Puerto Montt", 3, "Iglesia Catedral de Puerto Montt"));

        return servicios;
    }
}
