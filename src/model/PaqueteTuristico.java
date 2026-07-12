package model;

/**
 * Clase que representa un paquete turístico completo.
 * Aplica COMPOSICIÓN con Tour, Guia y Operador.
 * Un paquete no puede existir sin su tour, guía y operador asignados.
 */
public class PaqueteTuristico {

    private int id;
    private String nombre;
    private Tour tour;          // composición con Tour
    private Guia guia;          // composición con Guia
    private Operador operador;  // composición con Operador
    private int cupoMaximo;

    public PaqueteTuristico(int id, String nombre, Tour tour, Guia guia,
                            Operador operador, int cupoMaximo) {
        this.id = id;
        setNombre(nombre);
        setTour(tour);
        setGuia(guia);
        setOperador(operador);
        setCupoMaximo(cupoMaximo);
    }

    public int getId()              { return id; }
    public String getNombre()       { return nombre; }
    public Tour getTour()           { return tour; }
    public Guia getGuia()           { return guia; }
    public Operador getOperador()   { return operador; }
    public int getCupoMaximo()      { return cupoMaximo; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del paquete no puede estar vacío.");
        this.nombre = nombre;
    }

    public void setTour(Tour tour) {
        if (tour == null)
            throw new IllegalArgumentException("El paquete debe tener un tour asignado.");
        this.tour = tour;
    }

    public void setGuia(Guia guia) {
        if (guia == null)
            throw new IllegalArgumentException("El paquete debe tener un guía asignado.");
        this.guia = guia;
    }

    public void setOperador(Operador operador) {
        if (operador == null)
            throw new IllegalArgumentException("El paquete debe tener un operador asignado.");
        this.operador = operador;
    }

    public void setCupoMaximo(int cupo) {
        if (cupo <= 0)
            throw new IllegalArgumentException("El cupo máximo debe ser mayor a 0.");
        this.cupoMaximo = cupo;
    }

    @Override
    public String toString() {
        return String.format(
            "[Paquete] ID: %d | %s%n" +
            "          Tour    : %s%n" +
            "          Guía    : %s%n" +
            "          Operador: %s%n" +
            "          Cupo máx: %d personas",
            id, nombre,
            tour.getNombre() + " ($" + String.format("%,d", tour.getPrecio()) + ")",
            guia.getNombre(),
            operador.getNombre(),
            cupoMaximo);
    }
}
