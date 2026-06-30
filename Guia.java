package model;

/**
 * Clase que representa a un operador de servicios turísticos.
 */
public class Operador {

    private int id;
    private String nombre;
    private String tipoServicio;
    private String contacto;

    public Operador(int id, String nombre, String tipoServicio, String contacto) {
        this.id = id;
        setNombre(nombre);
        setTipoServicio(tipoServicio);
        setContacto(contacto);
    }

    public int getId()              { return id; }
    public String getNombre()       { return nombre; }
    public String getTipoServicio() { return tipoServicio; }
    public String getContacto()     { return contacto; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del operador no puede estar vacío.");
        this.nombre = nombre;
    }

    public void setTipoServicio(String tipoServicio) {
        if (tipoServicio == null || tipoServicio.isBlank())
            throw new IllegalArgumentException("El tipo de servicio no puede estar vacío.");
        this.tipoServicio = tipoServicio;
    }

    public void setContacto(String contacto) {
        if (contacto == null || contacto.isBlank())
            throw new IllegalArgumentException("El contacto no puede estar vacío.");
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return String.format("[Operador] ID: %d | %-25s | Servicio: %-20s | Contacto: %s",
                id, nombre, tipoServicio, contacto);
    }
}
