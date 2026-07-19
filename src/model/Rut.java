package model;

import exception.RutInvalidoException;

/**
 * Representa un RUT chileno válido. Encapsula el cuerpo numérico y el
 * dígito verificador, calculando y verificando este último mediante el
 * algoritmo de Módulo 11. Si el RUT recibido no es válido, se lanza la
 * excepción personalizada RutInvalidoException.
 *
 * EFT - Semana 9: encapsulamiento y validación de atributos con
 * excepciones personalizadas.
 */
public class Rut {

    private String numero; // cuerpo del RUT, sin puntos ni guion
    private String dv;     // dígito verificador: '0'-'9' o 'K'

    public Rut(String rutTexto) throws RutInvalidoException {
        parsearYValidar(rutTexto);
    }

    private void parsearYValidar(String rutTexto) throws RutInvalidoException {
        if (rutTexto == null || rutTexto.isBlank()) {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }

        String limpio = rutTexto.replace(".", "").replace("-", "").trim().toUpperCase();
        if (limpio.length() < 2) {
            throw new RutInvalidoException("El RUT \"" + rutTexto + "\" tiene un formato inválido.");
        }

        String cuerpo = limpio.substring(0, limpio.length() - 1);
        String dvIngresado = limpio.substring(limpio.length() - 1);

        if (!cuerpo.matches("\\d+")) {
            throw new RutInvalidoException("El RUT \"" + rutTexto + "\" contiene caracteres inválidos en el cuerpo.");
        }

        String dvCalculado = calcularDV(cuerpo);
        if (!dvCalculado.equals(dvIngresado)) {
            throw new RutInvalidoException("El dígito verificador de \"" + rutTexto +
                    "\" es inválido (se esperaba " + dvCalculado + ").");
        }

        this.numero = cuerpo;
        this.dv = dvIngresado;
    }

    /** Calcula el dígito verificador de un cuerpo de RUT usando Módulo 11. */
    private String calcularDV(String cuerpo) {
        int suma = 0;
        int multiplicador = 2;
        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i)) * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }
        int resto = 11 - (suma % 11);
        if (resto == 11) return "0";
        if (resto == 10) return "K";
        return String.valueOf(resto);
    }

    public String getNumero() {
        return numero;
    }

    public String getDv() {
        return dv;
    }

    /** Retorna el RUT formateado con puntos y guion, ej: 12.345.678-5 */
    public String getFormateado() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for (int i = numero.length() - 1; i >= 0; i--) {
            sb.insert(0, numero.charAt(i));
            contador++;
            if (contador % 3 == 0 && i != 0) {
                sb.insert(0, '.');
            }
        }
        return sb + "-" + dv;
    }

    @Override
    public String toString() {
        return getFormateado();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rut)) return false;
        Rut otro = (Rut) obj;
        return numero.equals(otro.numero) && dv.equals(otro.dv);
    }

    @Override
    public int hashCode() {
        return (numero + dv).hashCode();
    }
}
