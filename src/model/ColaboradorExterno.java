package model;

/**
 * Representa a un colaborador externo (empresa o persona) que presta
 * servicios puntuales a la agencia (ej: transporte, catering, seguridad).
 * Hereda de Persona e implementa Registrable.
 *
 * Semana 8 - Interfaces, herencia y polimorfismo.
 */
public class ColaboradorExterno extends Persona implements Registrable {

    private String empresa;
    private String servicioPrestado;

    public ColaboradorExterno(String nombre, String telefono, String empresa, String servicioPrestado) {
        super(nombre, telefono);
        setEmpresa(empresa);
        setServicioPrestado(servicioPrestado);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.isBlank())
            throw new IllegalArgumentException("La empresa no puede estar vacía.");
        this.empresa = empresa;
    }

    public String getServicioPrestado() {
        return servicioPrestado;
    }

    public void setServicioPrestado(String servicioPrestado) {
        if (servicioPrestado == null || servicioPrestado.isBlank())
            throw new IllegalArgumentException("El servicio prestado no puede estar vacío.");
        this.servicioPrestado = servicioPrestado;
    }

    @Override
    public String mostrarResumen() {
        return "[Colaborador Externo] " + nombre +
               " | Empresa: " + empresa +
               " | Servicio: " + servicioPrestado +
               " | Tel: " + telefono;
    }
}
