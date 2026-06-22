package model;

/**
 * Clase que representa un Tour ofrecido por la agencia Llanquihue Tour.
 * Semana 5: se agregaron validaciones con try-catch, id y duracion,
 * y toString() mejorado.
 */
public class Tour {

    private int id;
    private String nombre;
    private String tipo;
    private int precio;
    private int duracionHoras;

    public Tour(int id, String nombre, String tipo, int precio, int duracionHoras) {
        this.id = id;
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
        setDuracionHoras(duracionHoras);
    }

    // Getters
    public int getId()              { return id; }
    public String getNombre()       { return nombre; }
    public String getTipo()         { return tipo; }
    public int getPrecio()          { return precio; }
    public int getDuracionHoras()   { return duracionHoras; }

    // Setters con validación básica
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del tour no puede estar vacío.");
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank())
            throw new IllegalArgumentException("El tipo del tour no puede estar vacío.");
        this.tipo = tipo;
    }

    public void setPrecio(int precio) {
        if (precio < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras <= 0)
            throw new IllegalArgumentException("La duración debe ser mayor a 0.");
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return String.format("[Tour] ID: %d | %-35s | Tipo: %-12s | Precio: $%,d | Duración: %d h",
                id, nombre, tipo, precio, duracionHoras);
    }
}
