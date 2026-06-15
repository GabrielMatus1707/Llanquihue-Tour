package model;

/**
 * Clase que representa un Tour ofrecido por la agencia Llanquihue Tour.
 * Contiene los atributos nombre, tipo y precio del tour.
 */
public class Tour {

    // Atributos del tour
    private String nombre;
    private String tipo;
    private int precio;

    /**
     * Constructor que inicializa un Tour con sus datos.
     *
     * @param nombre Nombre del tour
     * @param tipo   Tipo de tour (gastronómico, lacustre, cultural, aventura)
     * @param precio Precio del tour en pesos chilenos
     */
    public Tour(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Retorna una representación legible del objeto Tour.
     */
    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
