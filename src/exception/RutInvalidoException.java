package exception;

/**
 * Excepción personalizada (checked) que se lanza cuando un RUT ingresado
 * al sistema no cumple con el formato esperado o su dígito verificador
 * no corresponde al cuerpo numérico entregado.
 *
 * EFT - Semana 9: validación de atributos usando excepciones personalizadas.
 */
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
