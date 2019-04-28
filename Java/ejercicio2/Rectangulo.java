
package ejercicio2;

/**
 * <p>
 * Ejercicio 2 del examen.
 * </p>
 * <ul>
 * <li>1.Un objeto de esta clase se construye pasándole el ancho y el alto.
 * Ninguno de los dos atributos puede ser menor o igual a cero ni mayor que
 * diez, en esos casos se debe lanzar la excepción ArithmeticException.</li>
 * <li>2.Mediante getters y setters permite que se acceda y se modifique el
 * ancho y el alto del rectángulo teniendo en cuenta las restricciones en cuanto
 * a las dimensiones del apartado anterior.</li>
 * <li>3.Al imprimir en pantalla un objeto de la clase usando System.out.print
 * se debe dibujar el rectángulo por la pantalla (de manera similar a como se
 * imprime un cuadrado en la página 130 del libro Aprende Java con Ejercicios).
 * </li>
 *
 ****************************
 *Modificación:
 *  En la clase cuadrado, cambiar ancho y alto para pedir lado y añadir el compareTo.
 *
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class Rectangulo {

  // Estado de la clase Rectangulo.

  private int ancho;
  private int alto;

  // Constructor
  Rectangulo(int ancho, int alto) {
    setAncho(ancho);
    setAlto(alto);
  }

  /**
   * Método getter de ancho para devolver el valor de éste.
   * 
   * @return the ancho
   */
  public int getAncho() {
    return ancho;
  }

  /**
   * Método setter que controla que el ancho no puede ser menor o igual que 0 ni
   * mayor que 10 si ésto ocurre, saltará un excepción.
   * 
   * @param ancho
   *          pasado por teclado.
   */
  public void setAncho(int ancho) {
    if (ancho <= 0 || ancho > 10) {
      throw new ArithmeticException();
    } else
      this.ancho = ancho;
  }

  /**
   * Método getter de alto que devolverá dicho valor.
   * 
   * @return the alto
   */
  public int getAlto() {
    return alto;
  }

  /**
   * Método setter que controla que el alto no puede ser menor o igual que 0 ni
   * mayor que 10 si ésto ocurre, saltará un excepción.
   * 
   * @param alto
   *          pasado por teclado.
   */
  public void setAlto(int alto) {
    if (alto <= 0 || alto > 10) {
      throw new ArithmeticException();
    } else
      this.alto = alto;
  }
  
  @Override
  public String toString() {

    int i, espacios;
    String resultado = "";

    for (i = 0; i < this.alto; i++) {
      resultado += "[]";
    }
    resultado += "\n";
    
    for (i = 1; i < this.ancho - 1; i++) {
      resultado += "[]";
      for (espacios = 1; espacios < this.alto -1; espacios++) {
        resultado += "  ";
      }
      resultado += "[]\n";
    }
    
    for (i = 0; i < this.alto; i++) {
      resultado += "[]";
    }
    resultado += "\n";

    return resultado;
  }


  
  
}
