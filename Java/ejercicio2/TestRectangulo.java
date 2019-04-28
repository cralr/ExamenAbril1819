package ejercicio2;

import ejercicio2.Rectangulo;
import ejercicio2.utiles.NoEsEnteroException;
import ejercicio2.utiles.Teclado;

/**
 *Test para probar la clase Rectangulo.
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0s
 */
public class TestRectangulo {

  public static void main(String[] args) throws NoEsEnteroException, ArithmeticException{
    
    try {
      int alto = Teclado.leerEntero("Introduza el ancho del Rectángulo.");
      int ancho = Teclado.leerEntero("Introduza el alto del Rectángulo.");
      Rectangulo rectangulo = new Rectangulo(ancho, alto);
      System.out.println("El rectángulo creado es: ");
      System.out.println(rectangulo);
    } catch (ArithmeticException ae) {
      System.err.println("No se puede crear el rectángulo, valores mal introducidos.");
    }
    
 
  }

}
