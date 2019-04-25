package ejercicio1.almacen.exceptions;
/**
 * Excepción creada para dar error cuando el tipo de iva no es correcto.
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */

public class IvaInvalidoException extends Exception {
  public IvaInvalidoException(String string) {
    super(string);
  }
}