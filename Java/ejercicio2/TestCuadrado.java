package ejercicio2;

import ejercicio2.Cuadrado;
import ejercicio2.utiles.NoEsEnteroException;
import ejercicio2.utiles.Teclado;
/**
 * 
 *Test para pruebas de la clase cuadrado.
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class TestCuadrado {

  public static void main(String[] args) throws NoEsEnteroException {
    
    try {
      Cuadrado cuadrado1 = new Cuadrado(12);
      Cuadrado cuadrado2 = new Cuadrado(6);
      System.out.println("Cuadrado1");
      System.out.println(cuadrado1);

      System.out.println("Cuadrado2");
      System.out.println(cuadrado2);

      if (cuadrado1.compareTo(cuadrado2) == 0) {
        System.out.println("Son iguales.");
      } else if (cuadrado1.compareTo(cuadrado2) < 0) {
        System.out.println("Cuadrado1 menor a Cuadrado2");
      } else {
        System.out.println("Cuadrado1 mayor a Cuadrado2");
      }
    } catch (ArithmeticException ae) {
      System.err.println("No se puede crear el cuadrado, valores mal introducidos.");
    }
  }

}
